angular.module('JWTDemoApp')
// Creating the Angular Controller
.controller('HomeController', function($http, $scope, AuthService) {
	$scope.buttonText = 'Send';
		
	$scope.submit = function() {
		$http({
			url: "home",
			method: "POST",
			params: {
				recipient: $scope.transferProcess.recipient,
				amount: $scope.transferProcess.amount,
				message: $scope.transferProcess.message
			}
		}).success(function(res) {
			$scope.transferProcess = null;
			
			$scope.transfer.$setPristine();
			$scope.message = "To recipient is successful!";
			
		}).error(function(error){
			$scope.message = error.message; 
		
		});
	};
	
});
