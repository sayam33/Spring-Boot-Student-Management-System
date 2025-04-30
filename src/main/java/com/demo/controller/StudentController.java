package com.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import com.demo.payload.StudentBranchDto;
import com.demo.payload.StudentDto;
//import com.demo.repository.BranchRepo;
//import com.demo.repository.StudentRepository;
import com.demo.service.StudentService;

import javax.validation.Valid;


//i can develop Rest API
@RestController
public class StudentController {

	
	Logger log = LoggerFactory.getLogger(StudentController.class);

	
   // private final StudentRepository studentRepository;

	
   @Autowired
   private StudentService service;

   
   // StudentController(StudentRepository studentRepository) {
   //     this.studentRepository = studentRepository;
   // }

   
   //http://localhost:8080/create.

   
	//.Create a student branch code.
	//private final BranchRepo branchRepo;
	   //StudentController(BranchRepo branchRepo) {
	    //this.branchRepo = branchRepo;
	    //}
	//public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto dto) {
		//StudentDto savedEntity = service.createStudent(dto);
		//savedEntity.setMessage("Record is saved!!");
		//return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
	//}
	 //@PostMapping("/createStudentWithBranch")
	//public String createStudentWithBranch(@RequestBody StudentBranchDto dto) {
	//service.createStudentWithBranch(dto);
	//return "Record is saved!!";
	
    
    
    @PostMapping("/create")
	public ResponseEntity<?> createStudent(
			@Valid @RequestBody StudentDto dto,
			BindingResult result 
			) {
    	if (result.hasErrors()) {
    		return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		StudentDto savedEntity = service.createStudent(dto);
	//	savedEntity.setMessage("Record is saved!!");
		return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
	}

    
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteStudent(@RequestParam long id) {
		service.deleteStudent(id);
		return new ResponseEntity<>("Deleted!!", HttpStatus.OK);
	}

	
	@PutMapping("/update")
	public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto dto){
		StudentDto studentDto = service.updateStudent(dto);
				return new ResponseEntity<>(studentDto, HttpStatus.OK);
	}
	
	
	@GetMapping("/find")
	public ResponseEntity<List<StudentDto>> getAllStudents(
			@RequestParam(name = "pageNo", defaultValue = "0", required = false) int pageNo,
			@RequestParam(name = "pageSize", defaultValue = "5", required = false)int pageSize,
			@RequestParam(name = "sortBy", defaultValue = "id", required = false)String sortBy,
			@RequestParam(name = "sortDir", defaultValue = "asc", required = false)String sortDir
			){
//		List<StudentDto> dtos = service.getStudents(pageNo,pageSize, sortBy,sortDir);
//		return new ResponseEntity<>(dtos, HttpStatus.OK);
		return null;
	}
	
	
	@GetMapping("/studentById")
	public ResponseEntity<?> getStudentsById(@RequestParam long id){
		log.info("Inside getStudentById() method");
		StudentDto dto = service.getStudentById(id);
		if (dto==null) {
			log.error("No record found for id :"+id);
			return new ResponseEntity<>("No Record found", HttpStatus.OK);
		}
		log.info("Record found");
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	
	@GetMapping("/studentByEmail")
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
	
	
	@GetMapping("/filterStudentByCourse")
	public ResponseEntity<List<StudentDto>> filterStudentByCourse(@RequestParam String course){
		List<StudentDto> dtos = service.filterStudentByCourse(course);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	
	@GetMapping("/filterStudentByEmailAndMobile")
	public ResponseEntity<?> filterStudentByEmailAndMobile(@RequestParam String email, @RequestParam String mobile) {
		StudentDto dto = service.filterStudentByEmailAndMobile(email,mobile);
		if (dto==null) {
			return new ResponseEntity<>("No Record found", HttpStatus.OK);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	
	@GetMapping("/filterStudentByEmailOrMobile")
	public ResponseEntity<?> filterStudentByEmailOrMobile(@RequestParam String email, @RequestParam String mobile) {
		List<StudentDto> dtos = service.filterStudentByEmailOrMobile(email,mobile);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	
	@GetMapping("/filterStudentByContainingName")
	public ResponseEntity<?> filterStudentByContainingName(@RequestParam String name) {
		List<StudentDto> dtos = service.filterStudentByContainingName(name);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
}