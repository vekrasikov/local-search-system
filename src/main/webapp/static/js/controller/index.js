var app = angular.module('SearchSystem');
app.controller('indexController', function ($scope, $http, $interval) {
});

app.config(function ($mdThemingProvider) {
    //Available palettes: red, pink, purple,
    // deep-purple, indigo, blue, light-blue, cyan, teal,
    // green, light-green, lime, yellow, amber, orange,
    // deep-orange, brown, grey, blue-grey
    $mdThemingProvider.theme('default')
        .primaryPalette('blue')
        .accentPalette('blue-grey');
});