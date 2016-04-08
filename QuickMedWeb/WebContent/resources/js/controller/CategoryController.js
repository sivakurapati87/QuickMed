'use strict';

App.controller('CategoryController', ['$scope','$http','$rootScope','$state','$location','$anchorScroll', function($scope,$http,$rootScope,$state,$location,$anchorScroll) {
	$scope.isProcessing = true;
	$rootScope.rsPageName = "category";
	
	$location.hash('categoriesDivId');
	
	$scope.displayItemInfo = function(item){
		$rootScope.itemInfoObj = item;
		$state.go("itemInfo");
	};
	
//	 $scope.calculatePageNavigationValues = function(){
//		 $scope.categoryWithItemsMap = $rootScope.itemWithCategoryMap;
//			$scope.pages = [{}];
//			$scope.pages.splice(0,1);
//			
//			var alphabets = ['A','B','C','D'];
//			
//			for(var i=0;i<alphabets.length;i++){
//				var obj = {};
//				obj.number = alphabets[i];
//				obj.value = alphabets[i];
//				$scope.pages.push(obj);
//			}
//	    };
	
	
//	
//	$scope.onclickSearchAction = function(searchValue){
//		if($rootScope.itemWithCategoryMap){
//			alert(searchValue);
//			 $scope.categoryWithItemsMap = [{}];
//			 $scope.categoryWithItemsMap.splice(0,1);
//	angular.forEach($rootScope.itemWithCategoryMap, function(value, key) {
//		if(key.startsWith(searchValue))
//			{
//			alert(key+" "+value);
//			$scope.categoryWithItemsMap.push({key : value});
//			}
//	});
//		}
//	};
	
	
//	$scope.calculatePageNavigationValues();
}]);
