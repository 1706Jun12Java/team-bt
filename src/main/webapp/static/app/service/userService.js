(function() {
    'use strict';

    angular
        .module('app')
        .factory('userService', ['$cookies', function userService ($cookies) {
                var userService = {
                    setInfo: function(info) {
                        console.log(info);

                        $cookies.put('user', JSON.stringify(info));
                        console.log($cookies.get('user'));

                        console.log(JSON.parse($cookies.get('user')).email);
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