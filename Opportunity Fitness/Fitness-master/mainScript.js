
var app = angular.module("MyApp", ["youtube-embed","ngRoute","ng-fusioncharts",'ngLoadingSpinner']);

app.controller("mainCtrl", function($scope, $rootScope,$location, $http) {
	
	 $rootScope.getUserInfo();
	
	$scope.logout = function(){
		
		
		if( confirm("Are you sure you want to logout?")==true) 
		{
			$rootScope.clearUserInfo();
			$rootScope.userId = "null";
			$rootScope.userName = "null";
			$rootScope.loginFlag = "false";
			$rootScope.loggedInFlag = false;
			$rootScope.surveyDone = false;
			$rootScope.hrefval = "/index.html"
		}
		else{
			var url = $location.absUrl().split('?')[0];
			console.log("Url=",url);
			var shref = url.substr(	21,url.length - 21);
			console.log("shref=",shref);
			$rootScope.hrefval = shref; 
			console.log("reload");
			//location.reload();
		}
	//	$rootScope.loggedInFlag = loggedIn;
	//	alert("You are logged out successfully!!!");	
	
	//else alert(" You are not logged in ");
	}
	
	
		$rootScope.loginUser = function(){
		 	$rootScope.userId = $scope.userId;
			$rootScope.loginFlag = "false";
			$rootScope.loginResult = "";	
			$rootScope.loggedInFlag = false;	
						
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
						var res = str.search("failed");
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
									
									console.log("data = ",$scope.records);
										for (var desc in $scope.records){
											$rootScope.surveyDone = true;
											$rootScope.storeUserInfo2();
											console.log("Exercise Names : ",$scope.records[desc].ex_name);
											if($scope.records[desc].todays_date !== null){
												$scope.records[desc].tracked = true;
											}
											
										}
										
								})
								
							 console.log("$scope.surveyDone =",$rootScope.surveyDone);
							
						}
						
						else {
							$rootScope.clearUserInfo();
								
						}
						
						
						$rootScope.loginFlag = "true";
						$rootScope.loginResult = data;	
				//		$rootScope.loggedInFlag = true;	
						console.log("");
					
					});
				
		}
	
		});
		
app.directive('bDatepicker', function () {
    return {
        restrict: 'A',
        link: function (scope, el, attr) {
            el.datepicker({});
            var component = el.siblings('[data-toggle="datepicker"]');
            if (component.length) {
                component.on('click', function () {
                    el.trigger('focus');
                });
            }
        }
    };
});
		
		
app.config(['$routeProvider', function($routeProvider) {

		$routeProvider
		.when('/', {
			templateUrl: '/exercise-html/home.html'
		})
		.when('/about', {
		templateUrl : "/exercise-html/about.html"
		
		})
		.when('/addUser', {
		templateUrl : "/exercise-html/createUser.html"
		
		})
		.when('/login', {
		templateUrl : "/exercise-html/loginUser.html"
		
		})
		.when('/exerciseCategories', {
		templateUrl : "/exercise-html/exerciseCategories.html"
		
		})
		.when('/exercise', {
		templateUrl : "/exercise-html/exercises.html"
		
		})
		.when('/survey', {
		templateUrl : "/exercise-html/survey.html"
		
		})
		.when('/exerciseTracking', {
				
		templateUrl : "/exercise-html/routineDisplay.html"
							
		})
		.when('/trackThisDay', {
		templateUrl : "/exercise-html/oneDayAndFoodTrack.html"
		
		})
			.when('/foodTracking', {
		templateUrl : "/food-html/foodTracking.html"
		
		})
		.when('/weeklyProgress', {
		templateUrl : "/exercise-html/weeklyProgress.html"
			
		})
		.when('/food', {
		templateUrl : "/food-html/food.html"
		
		})
		.when('/week1', {
		templateUrl : "/exercise-html/Week1.html"
			
		})
		.when('/week2', {
		templateUrl : "/exercise-html/Week2.html"
			
		})
		.when('/week3', {
		templateUrl : "/exercise-html/Week3.html"
			
		})
		.when('/week4', {
		templateUrl : "/exercise-html/Week4.html"
			
		})
		
				
		.otherwise({redirectTo: '/'});

	}]); // end config
  
  	
	
	

app.run(function($rootScope,$location,$anchorScroll){
	$rootScope.storeUserInfo = function(userid,username){
		   sessionStorage.setItem("userName", username);
			sessionStorage.setItem("userId", userid);
			sessionStorage.setItem("loginflag", true);
			
		   $rootScope.userId = userid;
		   $rootScope.userName = username;
	   	  $rootScope.loggedInFlag = true;
		  
	}
	
	$rootScope.storeUserInfo2 = function(){
		sessionStorage.setItem("surveyDone", $rootScope.surveyDone);
	}
	
	 $rootScope.getUserInfo = function(){
			$rootScope.userId = sessionStorage.userId;
			$rootScope.userName = sessionStorage.userName;
			$rootScope.loggedInFlag = (sessionStorage.loginflag == 'true');
			$rootScope.surveyDone = (sessionStorage.surveyDone == 'true');
	    console.log("$rootScope.userId =",$rootScope.userId);
		console.log("$rootScope.userName =",$rootScope.userName);
		console.log("$rootScope.loggedInFlag =",$rootScope.loggedInFlag);
		
	 }

	 $rootScope.clearUserInfo = function(){
		   $rootScope.userId = "";
		   $rootScope.userName = "";
		   $rootScope.loggedInFlag = false;
		   sessionStorage.setItem("userName", "");
		   sessionStorage.setItem("userId", "");
		   sessionStorage.setItem("loginflag", false);
		   sessionStorage.setItem("surveyDone", false);
	}
	
	// register listener to watch route changes
  /*  $rootScope.$on( "$routeChangeStart", function(event, next, current) {
		console.log("ROute change");
		console.log("url =",next.templateUrl);
		
      if ( $rootScope.loggedInFlag == false ) {
        // no logged user, we should be going to #login
		console.log("Not logged in");
		
        if ( next.templateUrl == "/exercise-html/routineDisplay.html" ) {
			console.log("URL matched");
          $location.path( "/secondPage.html" );
		  
        }
      }         
    });  */
	
		$('li.adduser').find('a').click(function(){
		console.log("Inside my scroll logic2");
		var $href = $(this).attr('href');
		if ($href.charAt(1)=== '/') {
				var temp = $href.substr(2,$href.length);
				$location.hash(temp);
			console.log($location.hash());
			$anchorScroll();
		}
	});
	
	$('div.col-xs-4').find('a').click(function(){
		console.log("Inside my scroll logic");
		var $href = $(this).attr('href');
		var temp = $href.substr(2,$href.length);
   $location.hash(temp);
    console.log($location.hash());
    $anchorScroll();
	});
	
});