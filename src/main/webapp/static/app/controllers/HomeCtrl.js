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
            vm.noMoreInfo = false;
            vm.totalDisplay = 6;

            vm.noMoreInfo = vm.haveInfo.length < vm.totalDisplay ? false : true;

            vm.loadMore = function () {
                if (vm.allImages.length < vm.totalDisplay + 6)
                    vm.noMoreInfo = true;
                vm.totalDisplay += 6;
            };

            if (vm.isAuthenticated){
                imageService.getAllImages().then(function (response){
                    vm.allImages = response;
                    vm.haveInfo = true;
                }, function (error){
                    console.log(error.data);
                })
            }

        }
})();