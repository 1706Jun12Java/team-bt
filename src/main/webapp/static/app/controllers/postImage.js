(function() {
    'use strict';

    angular
        .module('app')
        .controller('PostImageCtrl', ['$scope', '$http', '$location', 'userService', function($scope, $http, $location, userService){
            $scope.newImage = function() {

                var file    = document.querySelector('input[type=file]').files[0];
                var reader = new FileReader();
                reader.readAsDataURL(file);
                reader.onloadend = function(){
                    console.log(reader.result);
                    $http.post('/postImage', reader.result)
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
/*
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
                */
            };
        }]);
})();
