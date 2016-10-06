var app = angular.module("MyApp", ["ngRoute"]);

app.controller("mainCtrl", ['$http', function($http) {
		}])
		
app.config(['$routeProvider', function($routeProvider) {

		$routeProvider
		.when('/', {
			templateUrl: 'home.html'

		})
		.when('/about', {
		templateUrl : "/about.html"
		
		})
		.when('/editStudent', {
		templateUrl : "/editStudent.html"
		
		})
		.when('/addStudent', {
		templateUrl : "/addStudent.html"
		
		})
		.when('/oneStudent', {
		templateUrl : "/oneStudent.html"
		
		})
		.when('/students', {
			  templateUrl : "/students.html",
			controller : "listCtrl"

		})
		.otherwise({redirectTo: '/'});

	}]); // end config
  
  
	app.controller('listCtrl', function($scope, $http) {
	$scope.space = " ";
	$http.get("http://localhost:8080/students")
	.then(function(response) {
		$scope.records = response.data;
		for(var stud in $scope.records){
		   $scope.records[stud].name = $scope.records[stud].first_name + "  "+ $scope.records[stud].last_name;
		}
		
	});
		$scope.getVal = function (stud) {
			var id = stud.id;
			console.log("ID =",id);
			var newStud = [stud.id,stud.first_name+" "+stud.last_name,stud.sat,stud.gpa,stud.major_id," "," "];
			console.log("New stud=",newStud);
			localStorage.setItem("studID", stud.id);
			localStorage.setItem("studFname", stud.first_name);
			localStorage.setItem("studLname", stud.last_name);
			localStorage.setItem("studSat", stud.sat);
			localStorage.setItem("studGpa", stud.gpa);
			localStorage.setItem("studMajor", stud.major_id);
			console.log("localStorage.studFname=",localStorage.studFname);
				console.log("localStorage.studSat=",localStorage.studSat);
		};
		
		$scope.delCall = function(stud){
		
			 if (confirm('Sure? you want to delete student?')) {
					$http.get("http://localhost:8080/student/delete/"+stud.id)
						.success(function(result) {
						  location.reload();
					});
					
			} else {
				alert('Student record remains :)');
			}
		
		}
			
});



//var app2 = angular.module("myApp2", []);
app.controller('editCtrl', function($scope, $http) {
 
		$scope.id = localStorage.studID;
		$scope.fname = localStorage.studFname;	
		$scope.lname =localStorage.studLname ;
		$scope.sat = parseInt(localStorage.studSat, 10);
		$scope.gpa = parseInt(localStorage.studGpa,10);
		$scope.major = parseInt(localStorage.studMajor,10);
					
		console.log("id=",$scope.id);
		console.log("name=",$scope.fname);
		console.log("sat=",$scope.sat);
		console.log("sgpa=",$scope.gpa);
		console.log("maj=",$scope.major);
				
		 $scope.updateStudent = function(){
		
			localStorage.setItem("studID", $scope.id);
			localStorage.setItem("studFname", $scope.fname);
			localStorage.setItem("studLname", $scope.lname);
			localStorage.setItem("studSat", $scope.sat);
			localStorage.setItem("studGpa", $scope.gpa);
			localStorage.setItem("studMajor", $scope.major);
		 
		
			console.log("fname=",$scope.fname);
			console.log("lname=",$scope.lname);
			console.log("major=",$scope.major);
			$scope.editLink = "http://localhost:8080/student/update/" +$scope.id+"/"+$scope.fname+"/"+$scope.lname+"/"+$scope.sat+
							"/"+$scope.gpa+"/"+$scope.major;
							
							$http.get($scope.editLink)
							.then(function(response) {
								console.log("update success");
							});
		}
		});
		
	app.directive('myDirective', function() {
				  return {
					require: 'ngModel',
					link: function (scope, element, attr, ngModelCtrl) {
					  function fromUser(text) {
						var transformedInput = text.replace(/[^A-Za-z ]/g, '');
					//	console.log(transformedInput);
						if(transformedInput !== text) {
							ngModelCtrl.$setViewValue(transformedInput);
							ngModelCtrl.$render();
						}
						return transformedInput;
					  }
					  ngModelCtrl.$parsers.push(fromUser);
					}
				  };
				});
		
// Add Student logic 

app.controller('addCtrl', function($scope, $http) {
		 $scope.addStudent = function(){
		   $("#firstName").prop("disabled", true);
		   $("#lastName").prop("disabled", true);
		   $("#studSat").prop("disabled", true);
		   $("#studGpa").prop("disabled", true);
		   $("#studMajor").prop("disabled", true);
		
		$scope.addLink = "http://localhost:8080/student/add/" +$scope.fname+"/"+$scope.lname+"/"+$scope.sat+
			"/"+$scope.gpa+"/"+$scope.major;
			
			$http.get($scope.addLink)
			.then(function(response) {
				console.log("Add success");
			});
			
		}
	
	});			

	app.controller('oneCtrl', function($scope, $http) {
		 $scope.id = localStorage.studID;
		$scope.fname = localStorage.studFname;	
		$scope.lname =localStorage.studLname ;
		$scope.sat = parseInt(localStorage.studSat, 10);
		$scope.gpa = parseInt(localStorage.studGpa,10);
		$scope.major = parseInt(localStorage.studMajor,10);
	
	});	