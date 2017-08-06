(function() {
    'use strict';

    angular
        .module('app')
        .controller('NavCtrl', NavCtrl);

        NavCtrl.$inject = ['$scope', '$location', '$route', 'userService', '$http'];

        function NavCtrl($scope, $location, $route, userService, $http) {
            let vm = this;
            vm.isAuthenticated = userService.isAuthenticated();
            vm.logout = function() {
                userService.removeInfo();
                $route.reload();
            };

            vm.home = function() {
                $location.path('/');
                $route.reload();
            }
        }
})();