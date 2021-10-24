package tech.crocier.studentmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.crocier.studentmanager.model.Student;
import tech.crocier.studentmanager.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = studentService.findAllStudents();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
		Student student = studentService.findStudentById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student newStudent = studentService.addStudent(student);
		return new ResponseEntity<Student>(newStudent, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		Student updateStudent = studentService.updateStudent(student);
		return new ResponseEntity<Student>(updateStudent, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudentById(@PathVariable("id") Long id) {
		studentService.deletestudent(id);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}

}
