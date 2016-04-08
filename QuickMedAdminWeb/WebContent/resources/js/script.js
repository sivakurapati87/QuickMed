function isNumberKey(evt) {
	var charCode = (evt.which) ? evt.which : event.keyCode
	if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
		return false;

	return true;
}
function validateFloat(evt, txtObject) {
	var charCode = (evt.which) ? evt.which : evt.keyCode
	if (txtObject.value.indexOf(".") == -1 || charCode != 46) {
		if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57)) {
			return false;
		}
		return true;
	}
	return false;
}