(function() {
    'use strict';

    angular
        .module('app')
        .factory('userService', userService);

        userService.$inject = ['$cookies', '$http', '$route', '$location', 'toastr'];


        function userService($cookies, $http, $route, $location, toastr){
            let vm = this;
            let userService = {
                setInfo: function(info) {
                    $cookies.put('user', JSON.stringify(info));
                },
                removeInfo: function() {
                    $http.get('/api/logout')
                        .then(function(response) {
                            $cookies.remove('user');
                            $route.reload();
                            $location.path('/');
                            toastr.info('Logout Success');
                        }, function (error) {
                            console.log(error);
                        })
                },
                isAuthenticated: function() {
                    if ($cookies.get('user'))
                        return true;
                    return false;
                }
            };
            return userService;
        }

})();