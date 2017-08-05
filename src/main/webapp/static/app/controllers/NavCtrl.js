(function() {
    'use strict';

    angular
        .module('app')
        .controller('navCtrl', navCtrl);

    navCtrl.$inject = ['$scope', '$location', '$route', 'userService', '$http'];

    function navCtrl($scope, $location, $route, userService, $http) {
        var vm = this;
        vm.isAuthenticated = userService.isAuthenticated();
        vm.logout = function() {
            userService.removeInfo();
            $location.path('/');
            $route.reload();
        };

        vm.home = function() {
            $location.path('/');
            $route.reload();
        }
    }
})();