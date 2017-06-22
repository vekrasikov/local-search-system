var app = angular.module('SearchSystem');
app.controller('searchController', function ($scope, $http, $mdToast) {
    $scope.query = "";
    $scope.metricType = "Jaccard";
    $scope.vectorType = "TFIDF";
    $scope.searchResponse = {};

    $scope.showToastFail = function () {
        $mdToast.show({
            hideDelay: 3000,
            position: 'bottom right',
            controller: 'failToastController',
            templateUrl: 'view/failToast.html'
        });
    };
    $scope.search = function () {
        var queryObject = {
            searchText: $scope.query,
            metricType: $scope.metricType,
            vectorType: $scope.vectorType
        };
        $http.get('/api/search', queryObject)
            .then(function (response) {
                    $scope.searchResponse = response.data;
                },
                function (response) {
                    $scope.showToastFail();
                });
    };
});