package com.tiy.ssa.exerciseWebApp.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tiy.ssa.exerciseWebApp.entity.Date_Map;
import com.tiy.ssa.exerciseWebApp.entity.Exercise;
import com.tiy.ssa.exerciseWebApp.entity.Exercise_Tracking;
import com.tiy.ssa.exerciseWebApp.entity.Exercise_Tracking_Data;
import com.tiy.ssa.exerciseWebApp.entity.Food_Tracking;
import com.tiy.ssa.exerciseWebApp.entity.Userinfo;
import com.tiy.ssa.exerciseWebApp.entity.WeeklyProgress;
import com.tiy.ssa.exerciseWebApp.service.IDate_MapService;
import com.tiy.ssa.exerciseWebApp.service.IExerciseService;
import com.tiy.ssa.exerciseWebApp.service.IExercise_CategoryService;
import com.tiy.ssa.exerciseWebApp.service.IExercise_TrackingService;
import com.tiy.ssa.exerciseWebApp.service.IFood_TrackingService;
import com.tiy.ssa.exerciseWebApp.service.IUserinfoService;

@Controller
@RequestMapping("/")
@CrossOrigin
public class Exercise_TrackingController {

	
	@Autowired
	private IUserinfoService userinfoService;
	
	@Autowired
	private IExerciseService exerciseService;
	
	@Autowired
	private IExercise_CategoryService exercise_CategoryService;
	
	@Autowired
	private IExercise_TrackingService exrcise_TrackingService;
	
	@Autowired
	private IFood_TrackingService food_TrackingService;
	
	@Autowired
	private IDate_MapService date_mapService;
	// Create workout routine for the user 
	
	  @RequestMapping(value="/dateMap/{userid}/{intensity}", method = RequestMethod.POST)
	    @ResponseBody
	    @CrossOrigin
	public String createDateMap(@PathVariable("userid") String userid,@PathVariable("intensity") Integer intensity){
		  String dayno = " "; 
		  String date1 = "11/01/2016";
		  int increment = 1;
		 	HashMap<Integer,String> dayStr = new HashMap<Integer,String>();
	    	dayStr.put(1, "One");
	    	dayStr.put(2, "Two");
	    	dayStr.put(3, "Three");
	    	dayStr.put(4, "Four");
	    	dayStr.put(5, "Five");
	    	dayStr.put(6, "Six");
	    	dayStr.put(7, "Seven");
	    	
	        DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
	        Date dateVal = new Date();
	        Date start_date = new Date();
	        try {
	        	dateVal = df.parse(date1);
	        	start_date = df.parse(date1);
	            String newDateString = df.format(dateVal);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	    	
	    	
	    	for(int i=1; i<5;i++){
	    		for(int j=1;j<8;j++){
	    			dayno = "Week" + dayStr.get(i) + "Day" + dayStr.get(j) ;
//	    			System.out.println("Day = "+dayno);
	    			  Date_Map dm = new Date_Map(userid,dayno,dateVal);
	    			  date_mapService.insertDateMap(dm);
	    			  
	    	        	Calendar c = Calendar.getInstance();
	    	        	c.setTime(dateVal); 
	    	        	 c.add(Calendar.DATE, increment); 
	    	        	dateVal = c.getTime();
	    					  
	    		}
	    	}
			
	    	return(createWorkoutRoutineForUser(userid,  intensity,start_date));
		
	}
    
//    @RequestMapping(value="/exerciseTracking/{userid}/{intensity}", method = RequestMethod.POST)
//    @ResponseBody
//    @CrossOrigin
//    public String createWorkoutRoutineForUser(@PathVariable("userid") String userid,@PathVariable("intensity") Integer intensity) {
  
	  public String createWorkoutRoutineForUser(String userid, Integer intensity, Date start_date) {
    	String response ="Failure";
    	int noOfSets = 2;
    	int noOfReps = 10;
    	int caloriesPerDay = 1500;
    	String dayno = " "; 
    	HashMap<Integer,String> dayStr = new HashMap<Integer,String>();
    	dayStr.put(1, "One");
    	dayStr.put(2, "Two");
    	dayStr.put(3, "Three");
    	dayStr.put(4, "Four");
    	dayStr.put(5, "Five");
    	dayStr.put(6, "Six");
    	dayStr.put(7, "Seven");
    	for(int i=1; i<5;i++){
    		for(int j=1;j<8;j++){
    			dayno = "Week" + dayStr.get(i) + "Day" + dayStr.get(j) ;
//    			System.out.println("Day = "+dayno);
    		}
    	}
    	
    	List<Exercise> exercise = exerciseService.getExerciseListByIntensity(intensity);
    	caloriesPerDay = 2000;
    
    	int week = 1;
    	//logic for creating routine for 4 weeks, 5 days a week workout routine 
    		for(int i=1;i < 21;i++){
    			for(Exercise ex : exercise){
    				  if (i>5 && i <=10) week =2;
	    			  if (i>10 && i <=15) week =3;
	    			  if (i>15 && i <=20) week =4;
	    		     	switch(week){
	    		     	case 1: noOfSets = 2;
	    		     			noOfReps = 10;
    		     				break;
	    		    	case 2: noOfSets = 3;
	    		    	        noOfReps = 8;
	    		    	        break;
	    		    	case 3: noOfSets = 3;
	    		    			noOfReps = 10;
	    		    			break;
	    		    	case 4: noOfSets = 4;
	    						noOfReps = 8;
	    						break;
	    		    	}
    				int j = i % 5;
    				if (j==0) { j+=5;}
	    			 if(j == ex.getCategory_id() ) {
	    				 dayno = "Week" + dayStr.get(week) + "Day" + dayStr.get(j) ;
//	    				 System.err.println(dayno);
		    			  Exercise_Tracking ex_trk = new Exercise_Tracking(userid,dayno,ex.getId(),noOfSets,noOfReps);
		    			  exrcise_TrackingService.insertWorkoutRoutine(ex_trk);
		    			  response = "Success";
		    			  
	    			 }
    			}
    		}
    		
    		Userinfo user = userinfoService.getUserByUsername(userid);
    		user.setStart_date(start_date);
    		user.setCaloriesPerDay(caloriesPerDay);
    		user.setRoutine_created(true);
    		userinfoService.updateUser(user);
    	
    	return response;
    }
    
    
//Retrieve workout routine for a user 
    
    @RequestMapping(value="/exerciseTracking/{userid}", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
//    public ResponseEntity<List<Exercise_Tracking>> getWorkoutRoutineForUser(@PathVariable("userid") String userid) {
    public List<Exercise_Tracking_Data> getWorkoutRoutineForUser(@PathVariable("userid") String userid) {
    	String ex_name;
    	List<Exercise_Tracking_Data> ex_data = new ArrayList<>();
    	List<Exercise_Tracking> exTrack = exrcise_TrackingService.getWorkoutRoutineByUser(userid);
   // 	System.err.println("Ex id ="+exTrack.get(0).getExercise_id());
    	for(Exercise_Tracking ex : exTrack){
    		
    		Exercise exercise = exerciseService.getExerciseById(ex.getExercise_id());
   // 		System.err.println("Ex name ="+ exercise.getExercise_name());
    		
    		 ex_data.add(new Exercise_Tracking_Data(ex.getDayNo(),exercise.getExercise_name(),ex.getNumberOfSets(),
    						ex.getNumberOfReps(),ex.getTimeInMins(),ex.getTodays_date(),ex.isComplete()));
    		 
 //   		 System.err.println("Ex name again ="+ ex_data.get(0).getEx_name());
    	}
    	 return ex_data;
    }
    
//Retrieve workout for the selected day for the given user
    @RequestMapping(value="/trackThisDay/{userid}/{dayno}", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public List<Exercise_Tracking_Data> getWorkoutRoutineForUserByDay(@PathVariable("userid") String userid,@PathVariable("dayno") String dayno) {
    	String ex_name;
    	List<Exercise_Tracking_Data> ex_data = new ArrayList<>();
    	List<Exercise_Tracking> exTrack = exrcise_TrackingService.getWorkoutRoutineByUserByDay(userid,dayno);
//    	System.err.println("Ex id ="+exTrack.get(0).getExercise_id());
    	for(Exercise_Tracking ex : exTrack){
    		
    		Exercise exercise = exerciseService.getExerciseById(ex.getExercise_id());
//    		System.err.println("Ex name ="+ exercise.getExercise_name());
    		
    		 ex_data.add(new Exercise_Tracking_Data(ex.getDayNo(),exercise.getExercise_name(),ex.getNumberOfSets(),
    						ex.getNumberOfReps(),ex.getTimeInMins(),ex.getTodays_date(),ex.isComplete()));
    		 
//    		 System.err.println("Ex name again ="+ ex_data.get(0).getEx_name());
    	}
    	 return ex_data;
    }
    
    @RequestMapping(value="/updateThisDay/{userid}/{dayno}/{ex_name}/{complete}/{sets}/{reps}", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public boolean updateWorkoutRoutineForUserByDay(@PathVariable("userid") String userid,@PathVariable("dayno") String dayno,
    		@PathVariable("ex_name") String ex_name, 
    			@PathVariable("complete") boolean complete,
    @PathVariable("sets") Integer sets,
    @PathVariable("reps") Integer reps ){
    	int ex_id;
    	boolean response = false;
    	Exercise exercise  = exerciseService.getExerciseByName(ex_name);
    	List<Exercise_Tracking> exTrack = new ArrayList<>();
    	exTrack = exrcise_TrackingService.getWorkoutRoutineByUserByDay(userid, dayno);
    	for(Exercise_Tracking ex : exTrack){
    	
    	 if (ex.getExercise_id() == exercise.getId()){
    		 ex.setComplete(complete);
    		 ex.setTodays_date(new Date());
    		 ex.setNumberOfSets(sets);
    		 ex.setNumberOfReps(reps);
    		response = exrcise_TrackingService.updateWorkoutRoutine(ex);
    		 
    	 }
//    	 	System.err.println("Ex id ="+exTrack.get(0).getExercise_id());
    	
    	}
    	 return response;
    }
    
    //Delete a workout 
    @RequestMapping(value="/deleteThisExercise/{userid}/{dayno}/{ex_name}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public boolean deleteExerciseForUserByDay(@PathVariable("userid") String userid,@PathVariable("dayno") String dayno,
    		@PathVariable("ex_name") String ex_name) {
    	int ex_id;
    	boolean response = false;
    	Exercise exercise  = exerciseService.getExerciseByName(ex_name);
    	ex_id = exercise.getId();
    	System.out.println("ex id =  "+ex_id);
    	System.out.println("user id =  "+userid);
    	System.out.println("dayno =  "+dayno);
    	List<Exercise_Tracking> exTrack = new ArrayList<>();
    	exTrack = exrcise_TrackingService.getWorkoutRoutineByUserByDay(userid, dayno);
    	 System.out.println("BEfore calling delete 1 "+exTrack.get(0).getUser_id());
    	for(Exercise_Tracking ex : exTrack){
    		 System.out.println("Loop  ex id "+ex.getExercise_id());
    	 if (ex.getExercise_id() == ex_id){
    		 System.out.println("BEfore calling delete 2");
    		response = exrcise_TrackingService.deleteOneWorkout(userid, dayno,ex_id);
    		
    	 }
//    	 	System.err.println("Ex id ="+exTrack.get(0).getExercise_id());
    	
    	}
    	 return response;
    }
    
 // Retrieve weekly progress for the given user
    @RequestMapping(value="/weeklyProgress/{userid}", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public List<WeeklyProgress> getWeeklyProgressForUser(@PathVariable("userid") String userid) {
    	String dayno=" ";
    	int count=0, completeCount=0, oneVal=0,totalCalories,totalProtein,totalCarbs,totalFat;
    	int proteinPercent=0,carbsPercent=0,fatPercent=0;
    	List<Integer[]> percentWO = new ArrayList<>();
    	List<Integer[][]> foodWK = new ArrayList<>();
    	List<WeeklyProgress> weekPr = new ArrayList<>();
    	HashMap<Integer,String> dayStr = new HashMap<Integer,String>();
    	dayStr.put(0, "One");
    	dayStr.put(1, "Two");
    	dayStr.put(2, "Three");
    	dayStr.put(3, "Four");
    	dayStr.put(4, "Five");
    	dayStr.put(5, "Six");
    	dayStr.put(6, "Seven");
    	Userinfo user = userinfoService.getUserByUsername(userid);
    	 for (int i=0; i<4;i++){
    		 Integer[] percent = {0,0,0,0,0,0,0};
    		 Integer[][] percentfd = new Integer[7][];
    		 percentfd[0] = new Integer[4];
    		 percentfd[1] = new Integer[4];
    		 percentfd[2] = new Integer[4];
    		 percentfd[3] = new Integer[4];
    		 percentfd[4] = new Integer[4];
    		 percentfd[5] = new Integer[4];
    		 percentfd[6] = new Integer[4];
    		 WeeklyProgress week = new WeeklyProgress();
    		 
    		 for(int j=0;j<7;j++){
    			 dayno = "Week" + dayStr.get(i) + "Day" + dayStr.get(j) ;
    			 List<Exercise_Tracking> exTrack = exrcise_TrackingService.getWorkoutRoutineByUserByDay(userid,dayno);
    			 List<Food_Tracking> fdTrack = food_TrackingService.getFoodTrackByUserByDay(userid, dayno);
    			 percent[j]=0;
    			 percentfd[j][0]=0;
    			 percentfd[j][1]=0;
    			 percentfd[j][2]=0;
    			 percentfd[j][3]=0;
    			 count = 0;
    			 completeCount =0 ;
    			 totalCalories =0;
    			 totalCarbs =0;
    			 totalProtein =0;
    			 totalFat =0;
    			 proteinPercent=0;carbsPercent=0;fatPercent=0;
    			 	for(Exercise_Tracking ex : exTrack){
    		    		count++;
    		    		if (ex.isComplete()){
    		    			completeCount++;
    		    		}
    		    		
    		    	}
    			 	if (count != 0){
	    			 	oneVal = 100 / count; 
	    			 	percent[j] = oneVal * completeCount;
    			 	}
	    			 for(Food_Tracking fd : fdTrack){
	    			 		totalCalories += fd.getCalories();
	    			 		totalCarbs += fd.getCarbs();
	    			 		totalProtein += fd.getProtein();
	    			 		totalFat += fd.getFat();
	    			 	}
    			 	
	    			 	if (totalCalories != 0){
	    			 		float temp;
	    			 		temp =  ( totalProtein  * 4  * 100 ) / totalCalories  ;
	    			 		proteinPercent =  Math.round(temp);
	    			 		temp =  ( totalCarbs  * 4  * 100 ) / totalCalories  ;
	    			 		carbsPercent  = Math.round(temp);
	    			 		fatPercent = 100  - ( proteinPercent + carbsPercent ) ;
	    			 		percentfd[j][0] = totalCalories;
	    			 		percentfd[j][1] = proteinPercent;
	    			 		percentfd[j][2] = carbsPercent;
	    			 		percentfd[j][3] = fatPercent;
	    			 	}
    		 }
//    		 WeeklyProgress week = new WeeklyProgress(percent[0],percent[1],percent[2],percent[3],percent[4]);
				 percentWO.add(percent);
				 foodWK.add(percentfd);
       			 week.setDay1(percentWO.get(i)[0]);
       			 week.setDay2(percentWO.get(i)[1]);
       			 week.setDay3(percentWO.get(i)[2]);
       			 week.setDay4(percentWO.get(i)[3]);
       			 week.setDay5(percentWO.get(i)[4]);
       			 week.setDay6(percentWO.get(i)[5]);
       			 week.setDay7(percentWO.get(i)[6]);
       			 week.setDay1fd(foodWK.get(i)[0]);
       			 week.setDay2fd(foodWK.get(i)[1]);
       			 week.setDay3fd(foodWK.get(i)[2]);
       			 week.setDay4fd(foodWK.get(i)[3]);
       			 week.setDay5fd(foodWK.get(i)[4]);
       			 week.setDay6fd(foodWK.get(i)[5]);
       			 week.setDay7fd(foodWK.get(i)[6]);
       	    	 weekPr.add(week);
//
//    		 for(Integer[] per : percentWO){
//    			 for (int k=0;k<7;k++){
//    			 System.out.println("Item in list ="+per[k]);
//    			 }
//    		 }
    	 }
    	 return weekPr;
    }
	
    @RequestMapping(value="/deleteRoutine/{userid}", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public boolean deleteWorkoutRoutineForUserByDay(@PathVariable("userid") String userid) {
    	boolean response = false;
    	response = exrcise_TrackingService.deleteWorkoutRoutine(userid);
    	food_TrackingService.deleteFoodTrackByDay(userid, "Not Used");
    	date_mapService.deleteDateMapByUserid(userid);
    	
    	Userinfo user = userinfoService.getUserByUsername(userid);
		user.setStart_date(null);
		user.setCaloriesPerDay(0);
		user.setRoutine_created(false);
		userinfoService.updateUser(user);
		
    	 return response;
    }
    
	
    @RequestMapping(value="/addExToRoutine/{userid}/{dayno}/{exName}", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public boolean addExToRoutineForUserByDay(@PathVariable("userid") String userid,@PathVariable("dayno") String dayno,@PathVariable("exName") String exName) {
    	boolean response = false;
    	Exercise ex = exerciseService.getExerciseByName(exName);
    	List<Exercise_Tracking> exTrack = exrcise_TrackingService.getWorkoutRoutineByUserByDay(userid,dayno);
    	
    	 Exercise_Tracking ex_trk = new Exercise_Tracking(userid,dayno,ex.getId(),exTrack.get(0).getNumberOfSets(),exTrack.get(0).getNumberOfReps());
		 response = exrcise_TrackingService.insertWorkoutRoutine(ex_trk);
    	
    	 return response;
    }
	
}
