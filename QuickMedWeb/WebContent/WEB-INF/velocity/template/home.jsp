<script type="text/javascript">
	$('.carosel-control-right').click(
			function() {
				$(this).blur();
				$(this).parent().find('.carosel-item').first().insertAfter(
						$(this).parent().find('.carosel-item').last());
			});
	$('.carosel-control-left').click(
			function() {
				$(this).blur();
				$(this).parent().find('.carosel-item').last().insertBefore(
						$(this).parent().find('.carosel-item').first());
			});
</script>

<div class="container-fluid" style="background: white; width: 100%;">
	<div class="row"
		style="background: url('resources/images/background.png'); height: auto;">
		<div class="col-md-12">
			<div class="row" style="margin-top: 30px;">
				<div class="col-md-12">
					<img alt="logo" src="resources/images/offer.png"
						class="img-responsive image_response">
				</div>
			</div>
			<div class="row searchbg_bg_image"
				style="background: #edeab1; margin-bottom: 30px; padding-bottom: 30px;">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-9">
							<div class="row" style="margin-top: 15px;">
								<div class="col-md-12">
									<label class="lable_blue_24">Search from thousands of
										products available on quickmeds</label>
								</div>
							</div>
							<div class="row" style="margin-top: 15px;">
								<div class="col-md-9">

									<div angucomplete-alt id="searchProductId"
										input-class="form-control height40"
										placeholder="Type your product name here.." pause="100"
										selected-object="selectedProductAction"
										search-fields="searchItemName" title-field="searchItemName"
										minlength="3"
										remote-url="http://localhost:8080/QuickMedService/ItemController/searchProduct/"
										match-class="highlight"></div>
								</div>
								<div class="col-md-3">
									<button type="button" class="btn btn-info"
										ng-click="onclickSearchAction()"
										style="width: 100%; height: 40px;">Search</button>
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<div class="row" style="margin-top: 15px;">
								<div class="col-md-12">
									<label class="lable_blue_24">Upload Prescription</label>
								</div>
							</div>
							<div class="row" style="margin-top: 15px;">
								<div class="col-md-8">
									<button type="button" class="btn btn-info"
										style="width: 100%; height: 40px;">Upload</button>
								</div>
							</div>
						</div>

					</div>

				</div>
			</div>
		</div>

	</div>
	<div class="carosel" id="carosel1" style="margin-top: 50px;">
		<a
			class="carosel-control carosel-control-left glyphicon glyphicon-chevron-left"></a>
		<div class="carosel-inner">
			<img class="carosel-item" style="border-radius: 50%;"
				src="resources/images/slides/baby_infants.jpg" /> <img
				class="carosel-item" style="border-radius: 50%;"
				src="resources/images/slides/diabetes.jpg" /> <img
				class="carosel-item" style="border-radius: 50%;"
				src="resources/images/slides/healthcare.jpg" /> <img
				class="carosel-item" style="border-radius: 50%;"
				src="resources/images/slides/household.jpg" /><img
				class="carosel-item" style="border-radius: 50%;"
				src="resources/images/slides/personlacare.png" /> <img
				class="carosel-item" style="border-radius: 50%;"
				src="resources/images/slides/wellness.jpg" />
		</div>
		<a
			class="carosel-control carosel-control-right glyphicon glyphicon-chevron-right"></a>
	</div>

</div>
