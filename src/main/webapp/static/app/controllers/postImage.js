(function() {
    'use strict';

    angular
        .module('app')
        .controller('PostImageCtrl', ['$scope', '$http', '$location', 'userService', function($scope, $http, $location, userService){
            $scope.newImage = function() {

                var reader = new FileReader();
                reader.readAsDataURL($scope.postImage.image);
                reader.onloadend = function($scope){
                    $scope.postImage.image=reader.result;
                }


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
            };
        }]);
})();

function getBase64(file) {
    var reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function () {
        console.log(reader.result);
    };
    reader.onerror = function (error) {
        console.log('Error: ', error);
    };
}