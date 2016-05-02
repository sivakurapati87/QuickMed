'use strict';

App.controller('HomeController', ['$scope','$http','$rootScope','$state', function($scope,$http,$rootScope,$state) {
	$scope.isProcessing = true;
	$rootScope.rsPageName = "home";
	
	
	//getting the selected product name from auto complete
    $scope.selectedProductAction = function(selected) {
        if (selected) {
        	$rootScope.selectedProduct = selected.description.itemName;
        } else {
          console.log('error at selected Product Action');
        }
      };
     
      
    //when we click on search button
      $scope.onclickSearchAction = function(){
    	  if($rootScope.selectedProduct){
    		 $state.go("searchItems");
    	  }
      };
      
     /* $scope.obj={};
      
      $scope.init = function(){
    	$scope.obj.phone = "9603631480";
    	$scope.obj.email = "kssrao87@gmail.com";
    	$scope.obj.strTotalAmount = "100";
    	$scope.obj.firstname = "siva";
    	
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.LookUpController+'/hashCode').success(function(data) {
				$scope.hashJson = data;
			}).error(function() {
	      	  console.error('Could not get All Manufacturer List');
	        });
      };
      $scope.init();*/
}]);
