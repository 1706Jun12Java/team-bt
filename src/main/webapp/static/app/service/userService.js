(function() {
    'use strict';

    angular
        .module('app')
        .factory('userService', ['$cookies', function userService ($cookies) {
                var userService = {
                    setInfo: function(info) {
                        $cookies.put('user', JSON.stringify(info));
                        console.log("user cookie: : ", $cookies.get('user'));
                    },
                    removeInfo: function() {
                        $cookies.remove('user');
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