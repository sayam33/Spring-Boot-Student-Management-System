package com.demo.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

//import com.demo.entity.Branch;
import com.demo.entity.Student;
import com.demo.exception.ResourceNotfoundException;
//import com.demo.payload.StudentBranchDto;
import com.demo.payload.StudentDto;
//import com.demo.repository.BranchRepo;
import com.demo.repository.StudentRepository;

//Model layer
@Service
public class StudentService {
	
	Logger log = LoggerFactory.getLogger(StudentService.class);
	
	//Database Operations
	//1.Create Repository layer - This will provide utility methods to perform
	//db operations on entity class object.
	//Dependency Injection for repository layer.
		
	//Database Operations-->Service/Model
		//Create repository layer in SpringBoot to perform database operation on entity class object.
		//Repository layer gives us utility methods like - save().
		//a.save() - Entity object will be saved in database.
	    //b.deleteById(long id No.) -> we can delete data from database.
	    //c.findById(id) -> search the record based on id number.
	    //d.findAll() -> Will read all data from database.
	
	//.create a student branch code.
		//@Autowired 
		//private BranchRepo branchRepo;
		//public void createStudentWithBranch(StudentBranchDto dto) {
		//	Student s = new Student();
		//	s.setId(dto.getSid());
		//	s.setName(dto.getName());
		//	s.setEmail(dto.getEmail());
		//	s.setCourse(dto.getCourse());
		//	repo.save(s);			
			//Branch b = new Branch();
			//b.setId(dto.getBid());
			//b.setBranch(dto.getBranch());			
			//branchRepo.save(b);

	
	@Autowired
	private StudentRepository repo;
	public StudentDto createStudent(StudentDto dto) {
		
		Student s = new Student();
		BeanUtils.copyProperties(dto,s);	
		Student savedEntity = repo.save(s);//---> ORM saves that in the database.
		BeanUtils.copyProperties(savedEntity, dto);		
		return dto;
	}


	
	public void deleteStudent(long id) {
		repo.deleteById(id);		
	}

	
	public StudentDto updateStudent(StudentDto dto) {
		Student s = new Student();
		BeanUtils.copyProperties(dto,s);
		Student savedEntity = repo.save(s);		
		BeanUtils.copyProperties(savedEntity, dto);
		return dto;
	}


	
	public List<StudentDto> getStudents() {
//		Sort sort = Sort.by(sortBy);
//		if (sortDir.equals("asc")) {
//			sort = sort.ascending();
//		}
//		if (sortDir.equals("desc")) {
//			sort = sort.descending();
//		}
//		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
//		 Page<Student> page = repo.findAll(pageable);
		 List<Student> students = repo.findAll();	 
		List<StudentDto> dtos = students.stream().map(s->convertToDto(s)).collect(Collectors.toList());			   
		return dtos;		
	}

	
	
	public StudentDto getStudentById(long id) {
		log.info("inside service layer getStudentById()");
		Student student = repo.findById(id).orElseThrow(
				  ()->new ResourceNotfoundException("Record not found with id: "+id)
				);
		return convertToDto(student);		
//		Optional<Student> opStudent = repo.findById(id);//--100
//		if (opStudent.isPresent()) {
//			Student student = opStudent.get();
//			log.info("Found record :"+student.getId() + " "+ student.getName());
//			return convertToDto(student);
//		}	
	}


	
	public StudentDto getStudentByEmail(String email) {
        Optional<Student> opstudent = repo.searchByEmail(email);
        if (opstudent.isPresent()) {
        	Student student = opstudent.get();
        	 return convertToDto(student);
		}
        return null;
    }


	
    public StudentDto convertToDto(Student s) {
        StudentDto dto = new StudentDto();
        BeanUtils.copyProperties(s, dto);
        return dto;
    }
	public List<StudentDto> filterStudentByCourse(String course) {
		List<Student> students = repo.searchByCourse(course);
		List<StudentDto> dtos = students.stream().map(s->convertToDto(s)).collect(Collectors.toList());
		return dtos;
	}


	
	public StudentDto filterStudentByEmailAndMobile(String email, String mobile) {
		Optional<Student> opStudent = repo.searchByEmailAndMobile(email, mobile);
		if (opStudent.isPresent()) {
			Student student = opStudent.get();
			return convertToDto(student);
		}
		return null;
	}


	
	public List<StudentDto> filterStudentByEmailOrMobile(String email, String mobile) {
		List<Student> students = repo.findByEmailOrMobile(email, mobile);
		List<StudentDto> dtos = students.stream().map(s->convertToDto(s)).collect(Collectors.toList());		
		return dtos;
	}

	
	
	public List<StudentDto> filterStudentByContainingName(String name) {
		List<Student> students = repo.findByNameContainingIgnoreCase(name);
		List<StudentDto> dtos = students.stream().map(s->convertToDto(s)).collect(Collectors.toList());		
		return dtos;
	}


	
	public boolean verifyStudentByEmail(String email) {
		return repo.existsByEmail(email);		
	}
}