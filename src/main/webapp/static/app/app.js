(function() {
    'use strict';
    console.log("app.js");
    angular
        .module('app', ['ngRoute'])
        .config(config);

    function config($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                templateUrl: '/views/home.html',
                controller: 'HomeCtrl',
                controllerAs: 'vm'
            })
            .when('/login', {
                templateUrl: '/views/login.html',
                controller: 'LoginCtrl',
                controllerAs: 'vm'
            })
            .otherwise({
                redirectTo: '/'
            });
        $locationProvider.html5Mode(true);
    }

})();