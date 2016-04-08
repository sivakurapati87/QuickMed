'use strict';

App.controller('ViewAllSubCategoryOrManufacturersController', ['$scope','$http','$rootScope','$state', function($scope,$http,$rootScope,$state) {
	$scope.isProcessing = true;
	$rootScope.rsPageName = "ViewAllSubCategoryOrManufacturersController";
	
	// get module names with all sub modules
	$scope.getAllCategoriesWithItemsBySubModuleCode = function(subModuleCode){
		$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ItemController+'/getAllCategoriesWithItemsBySubModuleCode/'+subModuleCode).success(function(data) {
			$rootScope.itemWithCategoryMap = data;
			$state.go('category', {}, {reload : true});
		}).error(function() {
      	  console.error('Could not get All Categories With Items By SubModule Code');
        });
	};
	
	// get all categories with corresponding items map by manufacturer name
	$scope.getACategoryWithItemsByManufacturerName = function(manufacturer){
		$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ItemController+'/getACategoryWithItemsByManufacturerName/'+manufacturer).success(function(data) {
			$rootScope.itemWithCategoryMap = data;
			 $state.go('category', {}, {reload : true});
		}).error(function() {
      	  console.error('Could not get A Category With Items By Manufacturer Name');
        });
	};
}]);
