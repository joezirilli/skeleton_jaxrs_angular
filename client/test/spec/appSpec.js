'use strict';

describe('TeamsCtrl', function () {
  var $httpBackend, $controller;

  beforeEach(module('clientApp'));

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
});