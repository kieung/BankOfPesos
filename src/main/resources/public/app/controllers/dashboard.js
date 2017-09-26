angular.module('JWTDemoApp')
// Creating the Angular Controller
.controller('DashboardController', function($http, $scope, AuthService) {
	
	$http.get('dashboard').success(function(res) {
		
		$scope.balance = res;
		
	}).error(function(error) {
		$scope.message = error.message;
	});
	
});