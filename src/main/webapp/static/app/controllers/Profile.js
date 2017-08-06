(function() {
    'use strict';

    angular
        .module('app')
        .controller('ProfileCtrl', ProfileCtrl);

    ProfileCtrl.$inject = ['$scope', '$http', '$location', 'userService'];

    function ProfileCtrl($scope, $http, $location, userService) {
        var info;
            $http.get('/getProfile')
                .then(function(response) {
                    console.log("sucess");
                    console.log(response);
                    info=response;
                }, function (error) {
                    console.log("error");
                    console.log(error);
                });
    }
})();