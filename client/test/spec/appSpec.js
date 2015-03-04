'use strict';

describe('MainCtrl', function () {
  var $httpBackend, $controller;

  beforeEach(module('clientApp'));

  beforeEach(inject(function (_$httpBackend_, _$controller_) {
    $httpBackend = _$httpBackend_;
    $controller = _$controller_;
  }));

  describe('when the controller is initiallized', function () {
    it('should request the teams and set them on the controller', function () {
      var main;
      $httpBackend.expectGET('rest/teams').respond(200, ['Yankees', 'Red Sox', 'Brewers']);
      main = $controller('MainCtrl');

      expect(main.teams).toBeUndefined();
      $httpBackend.flush();
      expect(main.teams).toEqual(['Yankees', 'Red Sox', 'Brewers']);
    });
  });
});