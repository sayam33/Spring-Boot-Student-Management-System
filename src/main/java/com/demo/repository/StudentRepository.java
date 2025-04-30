package com.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entity.Student;

// public interface StudentRepository extends CrudRepository<Student, Long>{

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Optional<Student> findByEmail(String email);
	
	List<Student> findByCourse(String java);
	
    Optional<Student> findByEmailAndMobile(String email, String mobile);
    
    List<Student> findByEmailOrMobile(String email, String mobile);
    
    List<Student> findByNameContainingIgnoreCase(String name);
   
    
    
    //@Query Examples
    //This is a JPQL query method.
    @Query("select s from Student s where s.email= ?1")
    Optional<Student> searchByEmail(String email);    
         //Anather Way (native queries( write plain SQL instead of JPQL ))  
//    @Query(value = "SELECT * FROM student WHERE email = ?1", nativeQuery = true)
//   Optional<Student> searchByEmail(String email);

    
    //common query method.
    @Query("Select s from Student s where s.course=?1")
    List<Student> searchByCourse(@Param("y") String name);   
         //Anather Way (native queries( write plain SQL instead of JPQL ))    
//    @Query(value = "SELECT * FROM student WHERE course = :courseName", nativeQuery = true)
//   List<Student> searchByCourse(@Param("courseName") String name);

    
    //This is a JPQL query method.
    @Query("Select s from Student s where s.email=?1 and s.mobile=?2")
    Optional<Student> searchByEmailAndMobile(String email, String mobile);   
         //Anather Way (native queries( write plain SQL instead of JPQL ))   
//    @Query(value = "SELECT * FROM student WHERE email = :email AND mobile = :mobile", nativeQuery = true)
//    Optional<Student> searchByEmailAndMobile(@Param("email") String email, @Param("mobile") String mobile);
    
    
    boolean existsByEmail(String email);
}
