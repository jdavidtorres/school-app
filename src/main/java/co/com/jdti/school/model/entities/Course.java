package co.com.jdti.school.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", unique = true, nullable = false, updatable = false)
	private String id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "director_id")
	private Teacher director;

	@OneToMany(mappedBy = "course")
	private List<Student> students;

	@JoinTable(name = "rel_subject_course", joinColumns = @JoinColumn(name = "course_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "subject_id", nullable = false))
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Subject> subject;

	public Course(String id) {
		this.id = id;
	}
}
