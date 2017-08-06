(function() {
    'use strict';

    angular
        .module('app')
        .controller('HomeCtrl', HomeCtrl);

        HomeCtrl.$inject = ['$scope', '$location', '$route', '$http', 'userService', 'imageService'];

        function HomeCtrl($scope, $location, $route, $http, userService, imageService) {
            let vm = this;

            vm.isAuthenticated = userService.isAuthenticated();

            let allImages = imageService.getAllImages();
            console.log(allImages)
        }
})();