var app = angular.module('SearchSystem');
app.controller('successToastController', function ($scope, $mdToast) {

    var isDlgOpen = false;
    $scope.closeToast = function () {
        if (isDlgOpen) return;

        $mdToast
            .hide()
            .then(function () {
                isDlgOpen = false;
            });
    };
});