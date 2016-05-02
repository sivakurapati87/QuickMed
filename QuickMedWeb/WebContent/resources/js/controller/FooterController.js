'use strict';

App.controller('FooterController', ['$scope','$http','$rootScope','$state','Base64', function($scope,$http,$rootScope,$state,Base64) {
	
		
		// get module names with all sub modules
		$scope.getAllCategoriesWithItemsBySubModuleCode = function(subModuleCode){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ItemController+'/getAllCategoriesWithItemsBySubModuleCode/'+subModuleCode).success(function(data) {
				$rootScope.itemWithCategoryMap = data;
				$state.go("category");
//				$state.reload();//To reload the current state
			}).error(function() {
	      	  console.error('Could not get All Categories With Items By SubModule Code');
	        });
		};
		
	      
	      
          
}]);
