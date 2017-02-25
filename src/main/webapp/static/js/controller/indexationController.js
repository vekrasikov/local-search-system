var app = angular.module('SearchSystem');
app.controller('indexationController', function ($scope, $http, $mdToast) {
    $scope.text = "";

    $scope.showToastSuccess = function () {
        $mdToast.show({
            hideDelay: 3000,
            position: 'bottom right',
            controller: 'successToastController',
            templateUrl: 'view/successToast.html'
        });
    };
    $scope.showToastFail = function () {
        $mdToast.show({
            hideDelay: 3000,
            position: 'bottom right',
            controller: 'failToastController',
            templateUrl: 'view/failToast.html'
        });
    };
    $scope.indexing = function () {
        $http.post('/api/index', {text: $scope.text})
            .then(function (response) {
                    $scope.saveResponse = response.data;
                    $scope.showToastSuccess();
                },
                function (response) {
                    $scope.saveResponse = response.data;
                    $scope.showToastFail();
                });
    };
});