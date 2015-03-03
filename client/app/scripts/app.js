'use strict';

angular
  .module('clientApp', [
    'ngRoute'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .otherwise({
        redirectTo: '/'
      });
  })

  .controller('MainCtrl', function ($http) {
    var main = this;
    $http.get('rest/stuff').then(function (response) {
      main.stuff = response.data;
    });
  });
