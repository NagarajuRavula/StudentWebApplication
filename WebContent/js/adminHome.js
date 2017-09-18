 var close = document.getElementsByClassName("closebtn");
    var i;
    console.log(close);
    console.log(close.length);
    for (i = 0; i < close.length; i++) {
        close[i].onclick = function(){
            var div = this.parentElement;
            console.log(div);
            div.style.opacity = "0";
            setTimeout(function(){ div.style.display = "none"; }, 600);
            }
   }