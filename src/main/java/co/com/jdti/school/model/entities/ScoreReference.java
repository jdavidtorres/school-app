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

@Entity
@Table(name = "score_references")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScoreReference {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "reference_father_id")
    private String scoreReferenceFather;
}
