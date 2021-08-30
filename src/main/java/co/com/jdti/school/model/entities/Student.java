package co.com.jdti.school.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", unique = true, nullable = false, updatable = false)
	private String id;

	@NotEmpty
	@Column(name = "dni", nullable = false, unique = true)
	private String dni;

	@NotEmpty
	@Column(name = "student_name", nullable = false)
	private String name;

	@NotEmpty
	@Column(name = "lastname", nullable = false)
	private String lastname;

	@NotEmpty
	@Column(name = "blood_group", nullable = false)
	private String bloodGroup;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "mother_name")
	private String motherName;

	@NotEmpty
	@Column(name = "address", nullable = false)
	private String address;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	public Student(String name, String lastname) {
		this.name = name;
		this.lastname = lastname;
	}
}
