(function() {
    'use strict';

    angular
        .module('app')
        .controller('PostImageCtrl', PostImageCtrl);

        PostImageCtrl.$inject = ['$scope', '$http', '$location', 'userService'];

        function PostImageCtrl($scope, $http, $location, userService) {
                $scope.newImage = function() {

                    let file    = document.querySelector('input[type=file]').files[0];
                    let reader = new FileReader();
                    reader.readAsDataURL(file);


                    reader.onloadend = function(){
                        $scope.postImage.image = reader.result;
                        // console.log(reader.result);
                        $http.post('/postImage', $scope.postImage)
                            .then(function(response) {
                                console.log("sucess");
                                console.log($scope.postImage);
                                userService.setInfo(response.data);
                                $location.path('/');
                            }, function (error) {
                                console.log("error");
                                console.log(error);
                            })
                    }
                };
        }
        // .controller('PostImageCtrl', ['$scope', '$http', '$location', 'userService', function($scope, $http, $location, userService){
        //     $scope.newImage = function() {
        //
        //         let file    = document.querySelector('input[type=file]').files[0];
        //         let reader = new FileReader();
        //         reader.readAsDataURL(file);
        //
        //
        //         reader.onloadend = function(){
        //             $scope.postImage.image = reader.result;
        //             // console.log(reader.result);
        //             $http.post('/postImage', $scope.postImage)
        //                 .then(function(response) {
        //                     console.log("sucess");
        //                     console.log($scope.postImage);
        //                     userService.setInfo(response.data);
        //                     $location.path('/');
        //                 }, function (error) {
        //                     console.log("error");
        //                     console.log(error);
        //                 })
        //
        //         }
        //     };
        // }]);
})();
