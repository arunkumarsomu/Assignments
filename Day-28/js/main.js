
$(document).ready(function() {
  var tryBox = $("#try-count");
  var resultMessage = $(".result");
  var num;
  var increment;
  $("#zero").hide();
  
  function loadNumbers(){
   num  = Number($("#numBox").val());
   if ($('#myCheck').is(":checked")){
	   increment = Math.floor((Math.random() * 21) - 10);
	   console.log("Random number is " + increment);
   }else {   
   increment = Number($("#increment").val());
   }
  }
  
  $("#increase").click(function() {
    console.log("Clicked + button");
     loadNumbers();
	 num += increment;
	 evenNumCheck(num);
	 if ( num > 8 ) {
	  $("#numBox").removeClass("black"); 
	  $("#numBox").addClass("red");
	 }
	 checkSeven(num);
	 checkZero(num);
	  $("#numBox").val(num);
	 		
  });

    $("#decrease").click(function() {	
    console.log("Clicked - button");
     loadNumbers();
	 num -= increment;
	 evenNumCheck(num);
	 if (num <= 8) {
	   $("#numBox").removeClass("red"); 
	 }else $("#numBox").addClass("red");
	 checkSeven(num);
	 checkZero(num);
	  $("#numBox").val(num);
		
  });
  
   $("#reset").click(function() {
    console.log("Clicked Reset button");
	$("#numBox").addClass("black");
    $("#numBox").val("0");
	   	
  });
     function checkSeven(p1){
		 var str = p1.toString();
		 var n = str.search("7");
		 console.log("N = "+n);
		 if (n !== -1 ){
		  $("#numBox").removeClass("red"); 
		  $("#numBox").removeClass("black"); 
		  $("#numBox").addClass("green");
		 }
		 else
			  $("#numBox").removeClass("green"); 
	 }
	 
	 function evenNumCheck(p1) {
	 if (p1%2 === 0 ) 
		 $("#numBox").addClass("italic");
	 else
         $("#numBox").removeClass("italic");
}
	function checkZero(p1){
		if (p1 === 0)
			$("#zero").show();
		else
			$("#zero").hide();
	}
  });

  
