
// Add New user logic 

app.controller('addCtrl', function($scope, $rootScope,$http) {
//	$rootScope.getUserInfo();
	
		 $scope.createUser = function(){
		   $("#FName").prop("disabled", true);
		   $("#LName").prop("disabled", true);
		   $("#UserId").prop("disabled", true);
		   $("#PassWord").prop("disabled", true);
		   $("#ConPwd").prop("disabled", true);
		
		$scope.addLink = "http://localhost:8080/user/add/" +$scope.fname+"/"+$scope.lname+"/"+$scope.UserId+
			"/"+$scope.passWord;
			
			$http({
				  url: $scope.addLink,
				  method: 'POST',
				  transformResponse: [function (data) {
					  // Do whatever you want!
					  console.log("data=",data);
					  alert(data);
					  return data;
				  }]
				});
			
		}
	
	});	