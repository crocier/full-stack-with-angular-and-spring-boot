package tech.crocier.studentmanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Student implements Serializable { // bicoz this java class can be converted to diff types of stream bicoz,
												// this class is going to be the database, to json

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	private String email;
	private String dept;
	private String phone;
	private String imageUrl;

	@Column(nullable = false, updatable = false)
	private String studentCode;

}
