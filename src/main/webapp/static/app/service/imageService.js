(function() {
    'use strict';

    angular
        .module('app')
        .factory('imageService', imageService);

    imageService.$inject = ['$cookies', '$http', '$route', '$location'];


    function imageService($cookies, $http, $route, $location){
        let vm = this;
        let imageService = {
            getAllImages: function(){
                return $http.get('/getAllImages')
                    .then(function(response) {
                        return response.data;
                    }, function (){
                        return 'No Images';
                    });
            },
        };
        return imageService;
    }

})();