package tech.crocier.studentmanager.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import tech.crocier.studentmanager.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
