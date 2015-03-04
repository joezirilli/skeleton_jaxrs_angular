'use strict';

angular
  .module('exampleApp', [
    'teams'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .otherwise({
        redirectTo: '/'
      });
  });
