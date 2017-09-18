function checkNameLength() {
	var name = document.getElementById("name").value
	var nameLength = name.length;
	if (nameLength < 5 || nameLength > 50) {

		// alert("Please enter correct password");
		// document.getElementById("msg").innerHTML="Please enter correct
		// password"

		document.getElementById("name").value = "";
		return false;

	}

}
function checkPasswordLength() {
	var password = document.getElementById("password").value
	var passwordLength = password.length;
	if (passwordLength < 5 || passwordLength > 15) {

		alert("Please enter correct password");
		// document.getElementById("password").value = "";
		return false;

	}

}
