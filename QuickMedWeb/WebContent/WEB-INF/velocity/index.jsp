<!doctype html>
<html lang="en" ng-app="myApp">
<head>

<meta charset="utf-8">
<title>QuickMeds</title>

<script src="webjars/jquery/2.1.1/jquery.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="resources/css/angucomplete-alt.css" />
<link rel="stylesheet" href="resources/css/nv.d3.min.css" />
<link rel="stylesheet"
	href="webjars/font-awesome/4.3.0/css/font-awesome.css">
<link rel="stylesheet"
	href="webjars/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/app.css" />
<link rel="stylesheet" href="resources/css/ng-grid.css" />
<link rel="stylesheet" href="resources/css/image-crop-styles.css" />
<link rel="stylesheet" href="resources/css/quickmed.css" />
<link rel="stylesheet" href="resources/css/ngTimepicker.css" />

<script
	src="webjars/angularjs/1.4.4/angular.js"></script>
<script src="resources/js/angucomplete-alt.js"></script>
<script src="resources/js/d3.min.js"></script>
<script src="resources/js/nv.d3.min.js"></script>
<script src="resources/js/angular-nvd3.js"></script>
<script src="resources/js/moment.js"></script>
<script src="resources/js/ngTimepicker.min.js"></script>

<script src="resources/js/angular-ui-router.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="resources/js/ui-bootstrap-tpls.js"></script>
<script src="resources/js/ng-grid.js"></script>
<script src="resources/js/image-crop.js"></script>


<script src="resources/js/app.js"></script>
<script src="resources/js/controller/HomeController.js"></script>
<script src="resources/js/controller/HeaderController.js"></script>
<script src="resources/js/controller/CategoryController.js"></script>
<script src="resources/js/controller/ItemController.js"></script>
<script src="resources/js/controller/SearchItemController.js"></script>
<script src="resources/js/controller/ViewAllSubCategoryOrManufacturersController.js"></script>
<script src="resources/js/controller/AccountController.js"></script>
<script src="resources/js/controller/ShoppingCartController.js"></script>
<script src="resources/js/controller/CheckoutAddressController.js"></script>
<script src="resources/js/controller/CheckoutController.js"></script>


<script src="resources/js/service/constants.js"></script>
   
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body style="background: white;">

	<div ui-view="header"></div>
	<div ui-view="content"></div>
	<div ui-view="footer"></div>

       

</body>
</html>
