var app = angular.module('studentManagement', []);

app.controller('StudentListCtrl', [
  '$scope',
  '$http',
  ($scope, $http) => {
      $http.get('http://localhost:8080/student-management-services-web/students').success(data => {
        $scope.students = data;
      });
  }
]);
