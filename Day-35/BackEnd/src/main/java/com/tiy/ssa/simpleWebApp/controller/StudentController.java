package com.tiy.ssa.simpleWebApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tiy.ssa.simpleWebApp.entity.Student;
import com.tiy.ssa.simpleWebApp.service.IStudentService;;

@Controller
@RequestMapping("/")
public class StudentController {

	@Autowired
	private IStudentService studentService;
	
	@RequestMapping(value= "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> student = studentService.getAllStudents();
        return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
    }
	
    @RequestMapping(value= "/studentOne/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> oneStudent(@PathVariable("id") Integer id,Model model) {
    	Student student = studentService.getStudentById(id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
  
	
	@RequestMapping(value="/student",method = RequestMethod.GET)
	    public String greetingForm(Model model) {
		 model.addAttribute("student", new Student());
		   
	        return "student";
	    }

	
	    @PostMapping("/student")
	    public String greetingSubmit(@ModelAttribute("student") Student student, Model model) {
//	    	System.out.println("ID is "+student.getId());
	    	student = studentService.getStudentById(student.getId());
//	    	 System.out.println("sutdent name:"+student.getLast_name());
	    	 model.addAttribute("id",student.getId());
	    	 model.addAttribute("first_name",student.getFirst_name());
	      	 model.addAttribute("last_name",student.getLast_name());
	    	 model.addAttribute("sat",student.getSat());
	    	 model.addAttribute("gpa",student.getGpa());
	    	 model.addAttribute("major_id",student.getMajor_id());
	        return "result";
	    }
	    
	    @RequestMapping(value= "/student/deleteOne/{id}", method = RequestMethod.GET)
	    public String deleteOneStudent(@PathVariable("id") Integer id,Model model) {
	    	Student student = studentService.getStudentById(id);
	        model.addAttribute("delete", "Deleted student " + student.getId() + " " + student.getFirst_name()+" "+student.getLast_name());
	        studentService.deleteStudent(id);
	        return "delete";
	    }
	    
	    @RequestMapping(value= "/student/delete/{id}", method = RequestMethod.GET)
	    @ResponseBody
	    public String deleteStudent(@PathVariable("id") Integer id) {
	    	Student student = studentService.getStudentById(id);
	        String deleteSuccess = "Deleted student " + student.getId() + " " + student.getFirst_name()+" "+student.getLast_name();
	        studentService.deleteStudent(id);
	        return deleteSuccess;
	    }
	    
	    @RequestMapping(value= "/student/update/{id}/{fname}/{lname}/{sat}/{gpa}/{major}", method = RequestMethod.GET)
	    @ResponseBody
	    public String updateStudent(@PathVariable("id") Integer id,@PathVariable("fname") String fname, @PathVariable("lname") String lname,@PathVariable("sat") Integer sat,@PathVariable("gpa") Double gpa,@PathVariable("major") Integer major) {
	    	Student student = studentService.getStudentById(id);
	    	student.setFirst_name(fname);
	    	student.setLast_name(lname);
	    	student.setGpa(gpa);
	    	student.setMajor_id(major);
	    	student.setSat(sat);
	        studentService.updateStudent(student);
	        String updateSuccess = "Updated student " + student.getId() + " " + student.getFirst_name()+" "+student.getLast_name();
	        return updateSuccess;
	    }
	    
	    @RequestMapping(value= "/student/add/{fname}/{lname}/{sat}/{gpa}/{major}", method = RequestMethod.GET)
	    @ResponseBody
	    public String addStudent(@PathVariable("fname") String fname, @PathVariable("lname") String lname,@PathVariable("sat") Integer sat,@PathVariable("gpa") Double gpa,@PathVariable("major") Integer major) {
	    	Student student = new Student(fname,lname,sat,gpa,major);
	        studentService.addStudent(student);
	        String addSuccess = "Added student " + student.getId() + " " + student.getFirst_name()+" "+student.getLast_name();
	        return addSuccess;
	    }
}
