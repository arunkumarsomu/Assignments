
	// User login logic 
app.controller('loginCtrl', function($scope,$rootScope,$location, $http) {
		

		
		$rootScope.loginUser = function(){
		 	$rootScope.userId = $scope.userId;	
			$scope.surveyDone = false;
			$scope.addLink = "http://localhost:8080/login/" +$scope.userId+ "/"+$scope.passWord;
				console.log("userid =",$scope.userId);
				console.log("pwd =",$scope.passWord);				
				$http({
					  url: $scope.addLink,
					  method: 'POST',
					  transformResponse: [function (data) {
						  // Do whatever you want!
						  console.log("data=",data);
						  return data;
					  }]
					}).success(function(data){
						console.log("Success login");
						var str = data;
						console.log("String =",str);
						var res = str.search("password");
						console.log("res=",res);
						if (res === -1) {
							var pos1 = str.indexOf("!!");
							var pos2 = str.lastIndexOf("!!");
							var name = data.substring(pos1+2,pos2);
							$rootScope.storeUserInfo($scope.userId,name);
						//	  $rootScope.userId = $scope.userId;
						//	   $rootScope.userName = name;
						//	 $rootScope.loggedInFlag = true;
							
							console.log("Name =",name);
							$scope.loginSuccess = true;
							
		// this logic is to skip survey page if the user took survey already 					
							$scope.getLink = "http://localhost:8080/exerciseTracking/"+$rootScope.userId
							$http({
									  url: $scope.getLink,
									  method: 'POST'
								}).success(function(data){
									$scope.records = data;
									$scope.surveyDone = false;
									console.log("data = ",$scope.records);
										for (var desc in $scope.records){
											console.log("Exercise Names : ",$scope.records[desc].ex_name);
											if($scope.records[desc].todays_date !== null){
												$scope.records[desc].tracked = true;
											}
											$scope.surveyDone = true;
										}
										
										if($scope.loginSuccess && !$scope.surveyDone){
												console.log("path??? here");
												$location.path( "#/survey" );
											}
											if($scope.loginSuccess && $scope.surveyDone){
												console.log("survey done here");
											//	templateUrl = "/exercise-html/routineDisplay.html";
												$location.path( "/exercise-html/routineDisplay.html" );
											}
										
								})
								
							// console.log("$scope.surveyDone =",$scope.surveyDone);
							
						}else {
							$rootScope.clearUserInfo();
								
						}
						
						$scope.loginFlag = "true";
						$scope.loginResult = data;	
						$rootScope.loggedInFlag = true;
						console.log("here here");
					
					
					
					});
				
		}
	
	});	