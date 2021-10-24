package tech.crocier.studentmanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.crocier.studentmanager.exception.UserNotFoundException;
import tech.crocier.studentmanager.model.Student;
import tech.crocier.studentmanager.repo.StudentRepo;

@Service
public class StudentService {

	private final StudentRepo studentRepo;

	@Autowired
	public StudentService(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}

	public Student addStudent(Student student) {
		student.setStudentCode(UUID.randomUUID().toString());
		studentRepo.save(student);
		return student;
	}

	public List<Student> findAllStudents() {
		return studentRepo.findAll();
	}

	public Student findStudentById(Long id) {
		return studentRepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Student by ID+" + id + "not found"));
	}

	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}

	public void deletestudent(Long id) {
		studentRepo.deleteById(id);
	}

}
