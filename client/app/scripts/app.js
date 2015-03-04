'use strict';

angular
  .module('clientApp', [
    'ngRoute'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/teams.html',
        controller: 'TeamsCtrl',
        controllerAs: 'teamsView'
      })
      .otherwise({
        redirectTo: '/'
      });
  })

  .controller('TeamsCtrl', function ($http) {
    var teamsView = this;
    $http.get('rest/teams').then(function (response) {
      teamsView.teams = response.data;
    });
  });
