(function (angular) {
  'use strict';

  angular.module('teams', ['ngRoute'])

    .config(function ($routeProvider) {
      $routeProvider
        .when('/', {
          templateUrl: 'views/teams.html',
          controller: 'TeamsCtrl',
          controllerAs: 'teamsView'
        });
    })

    .controller('TeamsCtrl', function ($http) {
      var teamsView = this;
      $http.get('rest/teams').then(function (response) {
        teamsView.teams = response.data;
      });

      teamsView.addTeam = function (team) {
        teamsView.saving = true;
        $http.post('rest/teams', team)
        .then(function () {
          teamsView.teams.push(team);
        })
        .finally(function () {
          teamsView.saving = false;
        });
      };
    });
})(angular);