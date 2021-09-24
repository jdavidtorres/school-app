package co.com.jdti.school.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "subjects")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "subject_id")
    private List<Schedule> schedules;
}
