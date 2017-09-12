function checkName()
{
	var name=document.getElementById("name").value;
	if(nameLength<5||nameLength>15)
		{
		     alert("Please enter correct username");
		     document.getElementById("name").value = "";
		     return false;
		     
		}
}