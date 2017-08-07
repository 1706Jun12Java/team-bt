(function() {
    'use strict';

    angular
        .module('app')
        .controller('NavCtrl', NavCtrl);

        NavCtrl.$inject = ['$location', '$route', 'userService'];

        function NavCtrl($location, $route, userService) {
            let vm = this;
            vm.isAuthenticated = userService.isAuthenticated();
            vm.logout = function() {
                userService.removeInfo();
            };

            vm.home = function() {
                $location.path('/');
                $route.reload();
            }
        }
})();