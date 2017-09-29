angular.module('JWTDemoApp')
// Creating the Angular Controller
.controller('HomeController', function($http, $scope, AuthService) {
	$scope.buttonText = 'Send';
	
	var init = function() {
		$http.get('home').success(function(res) {
			
			$scope.transfers = res;
			$scope.buttonText = 'Send';
			console.log(res);
								
		}).error(function(error) {
			$scope.error = error.message;
			
		});
		
	};
		
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
	
	init();
	
});
