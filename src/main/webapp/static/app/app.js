(function() {
    'use strict';

    angular
        .module('app', ['ngRoute', 'ngCookies'])
        .config(config);

    function config($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                templateUrl: '/static/views/home.html',
                controller: 'HomeCtrl',
                controllerAs: 'vm'
            })
            .when('/login', {
                templateUrl: '/static/views/login.html',
                controller: 'LoginCtrl',
                controllerAs: 'vm'
            })
            .otherwise({
                redirectTo: '/'
            });
        $locationProvider.html5Mode(true);
    }

})();