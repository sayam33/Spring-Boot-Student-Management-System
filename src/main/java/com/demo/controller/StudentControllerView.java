package com.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entity.Student;
import com.demo.payload.StudentDto;
import com.demo.service.StudentService;




@Controller
public class StudentControllerView {

	
	Logger log = LoggerFactory.getLogger(StudentControllerView.class);

		
   @Autowired
   private StudentService service;
   
   //URL---> http://localhost:8080/view
   @RequestMapping("/view")
   public String viewRegistrationPage() {
	   return "create_registration";
   }

   
   //http://localhost:8080/create.
   //handler methods.
	    
    @RequestMapping("/createReg")
	public String createStudent(
			@ModelAttribute Student student,
//			@RequestParam String name,
//			@RequestParam String email,
//			@RequestParam String mobile,
//			@RequestParam String course,			
			ModelMap model
			) {
    	StudentDto dto = new StudentDto();
    	dto.setName(student.getName());
    	dto.setEmail(student.getEmail());
    	dto.setMobile(student.getMobile());
    	dto.setCourse(student.getCourse());
		StudentDto savedEntity = service.createStudent(dto);
		model.addAttribute("msg", "Record is saved");
		return "create_registration";
	}

    
	@RequestMapping("/deleteReg")
	public String deleteStudent(@RequestParam long id, Model model) {
		service.deleteStudent(id);
		List<StudentDto> dtos = service.getStudents();
		model.addAttribute("students", dtos);
		return "list_registration";
	}

	
	@RequestMapping("/updateReg")
	public String updateStudent(@ModelAttribute StudentDto dto,Model model){
		StudentDto studentDto = service.updateStudent(dto);
		List<StudentDto> dtos = service.getStudents();
		model.addAttribute("students", dtos);
		return "list_registration";
	}
	
	
	@GetMapping("/findReg")
	public String getAllStudents(
//			@RequestParam(name = "pageNo", defaultValue = "0", required = false) int pageNo,
//			@RequestParam(name = "pageSize", defaultValue = "5", required = false)int pageSize,
//			@RequestParam(name = "sortBy", defaultValue = "id", required = false)String sortBy,
//			@RequestParam(name = "sortDir", defaultValue = "asc", required = false)String sortDir,
			Model model
			){
		List<StudentDto> dtos = service.getStudents();
		model.addAttribute("students", dtos);
		return "list_registration";
	}
	
	
	@RequestMapping("/studentByIdReg")
	public String getStudentsById(@RequestParam long id, Model model){
		log.info("Inside getStudentById() method");
		StudentDto dto = service.getStudentById(id);
		model.addAttribute("dto",dto);
		return "update_registration";
	}
	
	
	@GetMapping("/studentByEmailReg")
	public ResponseEntity<?> getStudentByEmail(@RequestParam String email){
		log.info("Search record by email id: "+email);
		boolean val = service.verifyStudentByEmail(email);
		log.info("Record found:==>"+val);
		StudentDto dto = service.getStudentByEmail(email);
		if (dto==null) {
			return new ResponseEntity<>("No Record found", HttpStatus.OK);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	
	@GetMapping("/filterStudentByCourseReg")
	public ResponseEntity<List<StudentDto>> filterStudentByCourse(@RequestParam String course){
		List<StudentDto> dtos = service.filterStudentByCourse(course);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	
	@GetMapping("/filterStudentByEmailAndMobileReg")
	public ResponseEntity<?> filterStudentByEmailAndMobile(@RequestParam String email, @RequestParam String mobile) {
		StudentDto dto = service.filterStudentByEmailAndMobile(email,mobile);
		if (dto==null) {
			return new ResponseEntity<>("No Record found", HttpStatus.OK);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	
	@GetMapping("/filterStudentByEmailOrMobileReg")
	public ResponseEntity<?> filterStudentByEmailOrMobile(@RequestParam String email, @RequestParam String mobile) {
		List<StudentDto> dtos = service.filterStudentByEmailOrMobile(email,mobile);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	
	@GetMapping("/filterStudentByContainingNameReg")
	public ResponseEntity<?> filterStudentByContainingName(@RequestParam String name) {
		List<StudentDto> dtos = service.filterStudentByContainingName(name);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
}