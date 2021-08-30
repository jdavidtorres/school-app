package co.com.jdti.school.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subjects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false, updatable = false)
	private Integer id;

	@NotEmpty
	@Column(name = "name", nullable = false)
	private String name;

	@ManyToMany(mappedBy = "subject")
	private List<Course> course;
}
