var app = angular.module('SearchSystem', ['ngRoute', 'ngMaterial', 'ngMessages', 'material.svgAssetsCache'])
app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
        when('/indexation', {
            templateUrl: 'view/indexation.html',
            controller: 'indexationController'
        }).
        when('/search', {
            templateUrl: 'view/search.html',
            controller: 'searchController'
        }).
        otherwise({
            redirectTo: '/search'
        });
    }]);