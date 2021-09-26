package co.com.jdti.school.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "students")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

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
    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "mother_name")
    private String motherName;

    @NotEmpty
    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "course_id")
    private Long courseId;
}
