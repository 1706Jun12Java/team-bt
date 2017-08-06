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
                        $http.post('/api/postImage', $scope.postImage)
                            .then(function(response) {
                                userService.setInfo(response.data);
                                $location.path('/');
                            }, function (error) {
                            })
                    }
                };
        }
})();
