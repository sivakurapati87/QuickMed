'use strict';

App.controller('CheckoutAddressController', ['$scope','$http','$rootScope','$state','$location', function($scope,$http,$rootScope,$state,$location) {
	$rootScope.rsPageName = "checkoutAddress";
	 $location.hash('checkoutAddressDivId');
    
    //To get the gender combo
    $scope.getGenderCombo = function(){
		$scope.genderList = [{}];
		$scope.genderList.splice(0,1);
		var genders = ["Male","Female","Other"]
		//setting default angucomplete state value
		$scope.stateObj = {};
		$scope.stateObj.description = $rootScope.rsCustomerJson.customerDeliveryAddressJson.state;
		$scope.$broadcast('angucomplete-alt:changeInput', 'searchStateId', $scope.stateObj);
		
		for(var i=0;i<genders.length;i++){
			var obj = {};
			obj.value = genders[i];
			$scope.genderList.push(obj);
		}
    };
    
    $scope.saveCheckoutAddress = function(){
    	$state.go("checkout");
    }
    
  //getting the selected state name from auto complete
    $scope.selectedStateAction = function(selected) {
        if (selected) {
        	$rootScope.rsCustomerJson.customerDeliveryAddressJson.state = selected.description.description;
        } else {
          console.log('error at selected Country Action');
        }
      };
      
    //init
    $scope.getGenderCombo();
}]);