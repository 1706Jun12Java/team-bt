(function() {
    'use strict';

    angular
        .module('app')
        .controller('HomeCtrl', HomeCtrl);

        HomeCtrl.$inject = ['$scope', '$location', '$route', '$http', 'userService', 'imageService'];

        function HomeCtrl($scope, $location, $route, $http, userService, imageService) {
            let vm = this;

            vm.isAuthenticated = userService.isAuthenticated();

            vm.haveInfo = false;

            if (vm.isAuthenticated){
                imageService.getAllImages().then(function (response){
                    console.log(response);
                    vm.haveInfo = true;
                }, function (error){
                    console.log(error.data);
                })
            }

        }
})();