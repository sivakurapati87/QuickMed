'use strict';

App.controller('SearchItemController', ['$scope','$http','$rootScope','$state', function($scope,$http,$rootScope,$state) {
	$rootScope.rsPageName = "searchitem";
	
	 
    //when we click on search button
    $scope.onclickSearchAction = function(){
  	  if($rootScope.selectedProduct){
  		$scope.isProcessing = true;
  		 $http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ItemController+'/getNoOfRequiredsearchProducts/'+$rootScope.selectedProduct).success(function(data) {
  			 $scope.noOfRecords = data;
  			 $scope.pageNo = 0;
  	    	$scope.getCurrentPageRecords();
  	    	$scope.calculatePageNavigationValues();
  	    	}).error(function() {
  	    	  console.error('Could not perform search action');
  	    	});
  	  }
    };
    
    $scope.calculatePageNavigationValues = function(){
		$scope.pages = [{}];
		$scope.pages.splice(0,1);
		var j=1;
		
		for(var i=1;i<$scope.noOfRecords;){
			var obj = {};
			obj.number = j++;
				obj.recordOffset = i-1;
			$scope.pages.push(obj);
			i += constants.records_per_page;
		}
    };
    
    //when we click on search button
    $scope.getCurrentPageRecords = function(){
  	  if($rootScope.selectedProduct){
  		$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ItemController+'/getRequiredsearchProducts?productName='+$rootScope.selectedProduct+"&pageNo="+$scope.pageNo).success(function(data) {
      		$scope.productList = data;
      		$scope.isProcessing = false;
      		}).error(function() {
      		  console.error('Could not perform search action');
      		});
  	  }
    };
    
    $scope.nextPageRecords = function(pageNo){
    	$scope.isProcessing = true;
  	  $scope.pageNo = pageNo;
  	  $scope.getCurrentPageRecords();
    };
    //Display item info
    $scope.displayItemInfo = function(item){
		$rootScope.itemInfoObj = item;
		$state.go("itemInfo");
	};
	
	//init action
	$scope.onclickSearchAction();
}]);
