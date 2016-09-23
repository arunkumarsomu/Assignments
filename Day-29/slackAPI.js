var accToken = getSlackToken();

$(document).ready(function(){
  
  function postMessage(message,channelName) {
		$.ajax("https://slack.com/api/chat.postMessage", {
		data: {
			token: accToken,
			channel: channelName,
			text: message
		},
		method: "POST"
		})
	  
	}
	      
	$("#submit").click(function() {
		  var msg  = $("#message").val();
			console.log("Clicked Post ");
		 var channel = $("input[name=channel]:checked").val();
		 console.log(channel);
		 postMessage(msg,channel)	;
		});
		
  
    $.ajax("https://slack.com/api/channels.list", {
    data: {
	  token: accToken
    },
	}).then(function(result) {
   // console.log("Message posted in slack");
	console.log("Result is: ",result);
     console.log("Result length is ", result.channels.length);
	 
     for (var i=0; i < result.channels.length; i++) {
		console.log("the data was", result.channels[i].name);

		 var div1=document.getElementById('channel');
		 	
		 var radioButton1 = "<input name='channel'  type='radio' value='" + result.channels[i].name  + "'/>" + result.channels[i].name;
		 var $addDiv = $("#channel");
		 	$addDiv.append("<br>")
		 $addDiv.append(radioButton1)
		 $addDiv.append("<br>")
		 
		// div1.appendChild(radioButton1);
			 
	 }
 
    })
  });


function getChannelList() {
  var url = "https://slack.com/api/channels.list"

  var requestData = {
   token: accToken
  }
  $.ajax(url, {
    data: JSON.stringify(requestData),
    method: "GET"
  })
}



	
		
		
		