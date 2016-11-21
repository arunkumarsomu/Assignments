	
// Survey for user

app.controller('surveyCtrl', function($scope,$rootScope, $http) {
	
	
	console.log("desc = ",$rootScope.userId);	
	$scope.getRoutine = function(intensity){
		
   // alert("Please give us a minute, while we work on your request!!!");
	     $rootScope.surveyDone = false;
		 $rootScope.storeUserInfo2();
		 $rootScope.getUserInfo();
		 
		// console.log("Selected date =",dateVal);
		 
		
		
			$scope.intensity = intensity;
			console.log("Intensity=",$scope.intensity);
	//		$scope.getLink = "http://localhost:8080/exerciseTracking/" + $rootScope.userId + "/" + $scope.intensity;
			$scope.getLink = "http://localhost:8080/dateMap/" + $rootScope.userId + "/" + $scope.intensity;
				$http({
				  url: $scope.getLink,
				  method: 'POST',
				  transformResponse: [function (data) {
					  console.log("data=",data);
					  return data;
						}]
					}).success(function(data){
						if(data === "Failure"){
							alert("Please select appropriate values and submit");
							
						}
						if(data === "Success"){
						//	alert("Your customized workout is ready, click Proceed to see it!!!");
							$rootScope.surveyDone = true;
							$rootScope.storeUserInfo2();
						}
					});
									
	}
	

				
	});	