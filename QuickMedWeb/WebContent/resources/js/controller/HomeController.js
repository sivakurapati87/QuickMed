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
}]);
