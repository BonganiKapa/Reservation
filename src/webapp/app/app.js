(function() {
	
	'use strict';
	
	angular
		.module('app', ['ngRoute'])
		.config(config)
		.run(run);
	
	config.$inject = ['$routeProvider', '$locationProvider'];
	function config($routeProvider, $locationProvider){
		$routeProvider.when('/', {
			controller: 'HomeController',
			templateUrl: 'Home.html',
			controllerAs: 'client'
		}).when('/login', {
		controller: 'LoginController',
            templateUrl: 'login.html',
            controllerAs: 'client'
        }).otherwise({ redirectTo: '/login' });
    }
 
    run.$inject = ['$rootScope', '$location', '$http', '$window'];
    function run($rootScope, $location, $http, $window) {
        var userData = $window.sessionStorage.getItem('clientData');
        if (userData) {
            $http.defaults.headers.common['Authorization']
              = 'Basic ' + JSON.parse(userData).authData;
        }
 
        $rootScope
        .$on('$locationChangeStart', function (event, next, current) {
            var restrictedPage
              = $.inArray($location.path(), ['/login']) === -1;
            var loggedIn
              = $window.sessionStorage.getItem('clientData');
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }
})();