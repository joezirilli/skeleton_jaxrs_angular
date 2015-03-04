'use strict';

describe('TeamsCtrl', function () {
  var $httpBackend, $controller;

  beforeEach(module('teams'));

  beforeEach(inject(function (_$httpBackend_, _$controller_) {
    $httpBackend = _$httpBackend_;
    $controller = _$controller_;
  }));

  describe('when the controller is initiallized', function () {
    it('should request the teams and set them on the controller', function () {
      var teamsView;
      $httpBackend.expectGET('rest/teams').respond(200, ['Yankees', 'Red Sox', 'Brewers']);
      teamsView = $controller('TeamsCtrl');

      expect(teamsView.teams).toBeUndefined();
      $httpBackend.flush();
      expect(teamsView.teams).toEqual(['Yankees', 'Red Sox', 'Brewers']);
    });
  });

  describe('adding a team', function () {

    var teamsView;

    beforeEach(function () {
      $httpBackend.whenGET('rest/teams').respond(200, ['Yankees', 'Red Sox', 'Brewers']);
      teamsView = $controller('TeamsCtrl');
      $httpBackend.flush();
    });

    it('should save the team to the server', function () {
      $httpBackend.expectPOST('rest/teams').respond(200, 'abc123');
    });

    it('should add the team to the list upon a successful response', function () {
      $httpBackend.whenPOST('rest/teams').respond(200, 'abc123');
      expect(teamsView.teams.length).toBe(3);
      teamsView.addTeam('Pirates');
      expect(teamsView.teams.length).toBe(3); // not added yet

      $httpBackend.flush();
      expect(teamsView.teams.length).toBe(4);
      expect(teamsView.teams[3]).toBe('Pirates');
    });

    it('should not add the team to the list upon an error response', function () {
      $httpBackend.whenPOST('rest/teams').respond(400);
      expect(teamsView.teams.length).toBe(3);
      teamsView.addTeam('Pirates');
      expect(teamsView.teams.length).toBe(3);

      $httpBackend.flush();
      expect(teamsView.teams.length).toBe(3);
    });

    it('should manage a "saving" flag', function () {
      $httpBackend.whenPOST('rest/teams').respond(200, 'abc123');
      expect(teamsView.saving).toBeFalsy();
      teamsView.addTeam('Pirates');
      expect(teamsView.saving).toBeTruthy();

      $httpBackend.flush();
      expect(teamsView.saving).toBeFalsy();

      $httpBackend.whenPOST('rest/teams').respond(400);
      expect(teamsView.saving).toBeFalsy();
      teamsView.addTeam('Pirates');
      expect(teamsView.saving).toBeTruthy();

      $httpBackend.flush();
      expect(teamsView.saving).toBeFalsy();
    });
  });
});