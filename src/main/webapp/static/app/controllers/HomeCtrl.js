(function() {
    'use strict';

    angular
        .module('app')
        .controller('HomeCtrl', HomeCtrl);

        HomeCtrl.$inject = ['$scope', '$location', '$route', 'userService', '$http'];

        function HomeCtrl($scope, $location, $route, userService, $http) {
            let vm = this;

            vm.isAuthenticated = userService.isAuthenticated();
        }
})();