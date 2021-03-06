(function() {
    'use strict';

    angular
        .module('app', ['ngRoute', 'ngCookies', 'toastr'])
        .config(config);

    function config($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                templateUrl: '/static/views/home.html',
                controller: 'HomeCtrl',
                controllerAs: 'vm'
            })
            .when('/postImage', {
                templateUrl: '/static/views/postimage.html',
                controller: 'PostImageCtrl',
                controllerAs: 'vm'
            })
            .when('/register', {
                templateUrl: '/static/views/register.html',
                controller: 'RegisterCtrl',
                controllerAs: 'vm'
            })
            .when('/profile', {
                templateUrl: '/static/views/profile.html',
                controller: 'ProfileCtrl',
                controllerAs: 'vm'
            })
            .when('/login', {
                templateUrl: '/static/views/login.html',
                controller: 'LoginCtrl',
                controllerAs: 'vm'
            })
            .when('/image/:id', {
                templateUrl: '/static/views/image.html',
                controller: 'ImageCtrl',
                controllerAs: 'vm'
            })
            .otherwise({
                redirectTo: '/'
            });
        $locationProvider.html5Mode(true);
    }
})();