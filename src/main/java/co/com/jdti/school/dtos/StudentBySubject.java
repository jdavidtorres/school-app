package co.com.jdti.school.dtos;

import co.com.jdti.school.model.entities.ScoreReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentBySubject {

    private Long studentId;
    private Long subjectId;
    private List<ScoreReference> scoreReferenceList;
}
