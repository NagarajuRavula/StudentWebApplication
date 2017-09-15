function validateName() {
	var name = document.getElementById("name").value;
	var letters = /^[A-Za-z]+$/;
	if (name.length > 50 || !name.match(letters)) {
		document.getElementById("nameMessage").innerHTML = "Please enter correct Name";

	} else {
		document.getElementById("nameMessage").innerHTML = "";
	}
}