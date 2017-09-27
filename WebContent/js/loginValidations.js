
function checkPassword() {
	var password = document.getElementById("password").value
	var passwordLength = password.length;
	if (passwordLength < 5 || passwordLength > 15) {

		alert("Please enter correct password");
		return false;

	}
	else
		return true;

}
