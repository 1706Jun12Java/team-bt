(function() {
    'use strict';

    angular
        .module('app')
        .factory('userService', ['$cookies', '$http', '$route',function userService ($cookies, $http, $route) {
                var userService = {
                    setInfo: function(info) {
                        $cookies.put('user', JSON.stringify(info));
                        console.log("user cookie: : ", $cookies.get('user'));
                    },
                    removeInfo: function() {
                        $http.get('/logout')
                            .then(function(response) {
                                $cookies.remove('user');
                                $route.reload();
                                $location.path('/');
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
        }])
})();