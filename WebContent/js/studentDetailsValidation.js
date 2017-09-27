function enableFileds()
{
  document.getElementById("formFields").disabled = false;
 
}
function checkName(nameObj) {
	name = nameObj.value;
    var regEx = /^[A-Za-z\s]+$/;
	if (name==null||name == "") {
		alert("Name must be enterd");
		setTimeout(function() {
			nameObj.focus()
		}, 10);

		return false;
	}
	 if (!name.match(regEx)) {
		alert("Name must contain letters and spaces only");
		setTimeout(function() {
			nameObj.focus()
		}, 10);
		return false;
	}
}
function checkGender() {

	gender = document.getElementById("gender").value;
	if (gender == "Gender") {
		alert("Please select gender");
		setTimeout(function() {
			document.getElementById("gender").focus()
		}, 10);
		return false;

	} else {
		return true;
	}

}

function checkPassword(passwordObj)
{
	password=passwordObj.value;
	passwordLength=password.length;
    var regEx = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{5,15})");
	if(password==""||password==null)
		{
		   alert("Password must be entered");
		   setTimeout(function() {
			   passwordObj.focus()
			}, 10);
			return false;
		  
		}

	else if(!password.match(regEx))
		{
		  alert("password must be 5-15 character length And, must include At-least one low,high alphabet and number")
		}
	
}


function temp()
{
	alert("hello");
	
	
	var element = document.getElementById('gender');
    element.value = valueToSelect;
}

