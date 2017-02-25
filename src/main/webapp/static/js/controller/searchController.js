var app = angular.module('SearchSystem');
app.controller('searchController', function ($scope, $http, $mdToast) {
    $scope.query = "";
    $scope.metricType = "Jaccard";
    $scope.vectorType = "TFIDF";
    $scope.queryObject = {};
    $scope.searchResponse = { some: "sd "};

    $scope.showToastFail = function () {
        $mdToast.show({
            hideDelay: 3000,
            position: 'bottom right',
            controller: 'failToastController',
            templateUrl: 'view/failToast.html'
        });
    };
    $scope.search = function () {
        $scope.queryObject = {
            searchText: $scope.query,
            metricType: $scope.metricType,
            vectorType: "TFIDF"
        };
        $http.post('/api/search', $scope.queryObject)
            .then(function (response) {
                    $scope.searchResponse = response.data;
                    $scope.showToastSuccess();
                },
                function (response) {
                    $scope.showToastFail();
                });
    };
});