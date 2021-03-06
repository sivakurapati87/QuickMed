'use strict';

App.controller('AccountController', ['$scope','$http','$rootScope','$location', '$anchorScroll','$state', function($scope,$http,$rootScope, $location, $anchorScroll,$state) {
	$scope.isAscending = false;
	$scope.isSignupAscending = false;
	$rootScope.rsPageName = "account";
	$rootScope.rsCustomerJson = {};
	 $location.hash('login_signupDivId');
	//To register a customer
	$scope.registrationAction = function(){
		$scope.errorMsg = null;
		if($rootScope.rsCustomerJson.password != $rootScope.rsCustomerJson.confirmPassword){
			$scope.errorMsg = "Passwords mismatch"
		}
		if(!$scope.errorMsg){
		$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.CustomerController+'/registrationAction',$rootScope.rsCustomerJson).success(function(data) {
			if(data)
			{
				if(data.errorMsg){
					$scope.errorMsg = data.errorMsg;
				}else{
				$rootScope.rsCustomerJson = data;
				if($rootScope.rsAddedCartItemList){
					$state.go("shopping_cart");
				}else{
					$state.go("home");
				}
				}
			}
		}).error(function() {
      	  console.error('Could not perform registration action');
        });
		}
	};
	
	//To login a customer
	$scope.loginAction = function(){
		$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.CustomerController+'/loginAction',$rootScope.rsCustomerJson).success(function(data) {
			if(data){
				if(data.errorMsg){
					$scope.errorMsg = data.errorMsg;
				}else{
					$rootScope.rsCustomerJson = data;
					if($rootScope.rsAddedCartItemList){
					$state.go("shopping_cart");
					}else{
						$state.go("home");
					}
				}}
		}).error(function() {
      	  console.error('Could not perform login action');
        });
	};
	
	//To get password
	$scope.forgetPassword = function(){
		$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CustomerController+'/forgetPassword/'+$scope.requestedEmail).success(function(data) {
			$scope.errorMsg = data.errorMsg;
		}).error(function() {
      	  console.error('Could not perform forget password action');
        });
	};
	
}]);