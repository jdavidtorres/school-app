package co.com.jdti.school;

import java.util.ArrayList;

import co.com.jdti.school.services.CoursesServices;
import co.com.jdti.school.services.StudentServices;
import co.com.jdti.school.services.SubjectServices;
import co.com.jdti.school.services.TeacherServices;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.com.jdti.school.model.entities.Course;
import co.com.jdti.school.model.entities.Student;
import co.com.jdti.school.model.entities.Subject;
import co.com.jdti.school.model.entities.Teacher;

@RequiredArgsConstructor
@SpringBootApplication
public class SchoolApplication implements CommandLineRunner {

    private final StudentServices studentServices;
    private final CoursesServices coursesServices;
    private final TeacherServices teacherServices;
    private final SubjectServices subjectServices;

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Teacher teacher2A = iTeacherServices.save(Teacher.builder().name("Laracrisa Euclidiana").build());
        Teacher teacher3A = iTeacherServices.save(Teacher.builder().name("Pepito Perez").build());

        Course course1 = iCourseServices.save(Course.builder()
                .name("2A")
                .director(teacher2A)
                .build());
        iCourseServices.save(Course.builder()
                .name("3A")
                .director(teacher3A)
                .build());
        iCourseServices.save(new Course("aka2", "4A", iTeacherServices.save(new Teacher("id2", "Fulanito de Tal")), null));
        iCourseServices.save(new Course("aka3", "5A", iTeacherServices.save(new Teacher("id3", "Juanita Perez")), new ArrayList<>()));
        iCourseServices.save(new Course("aka4", "6A", iTeacherServices.save(new Teacher("id4", "Pepito Jr. Perez")), new ArrayList<>()));
        iStudentServices.save(new Student("aka1", "dni1", "Hugo", "Fulano", "A-", null, null, "Calle 1", course1));
        iStudentServices.save(new Student("aka2", "dni2", "Paco", "Perez", "O-", "Pepito", "Perez", "Calle 2", course1));
        iStudentServices.save(new Student("aka3", "dni3", "Luis", "Mengano", "O+", "", "", "Calle 3", null));
        iStudentServices.save(new Student("aka4", "dni4", "Paco", "Mengano", "O+", "", "", "Calle 4", null));
        iSubjectServices.save(Subject.builder().name("Matemáticas").build());
        iSubjectServices.save(Subject.builder().name("Lenguaje").build());
        iSubjectServices.save(Subject.builder().name("Historia").build());
        iSubjectServices.save(Subject.builder().name("Geometría").build());
        iSubjectServices.save(Subject.builder().name("Ética").build());
        iSubjectServices.save(Subject.builder().name("Matemáticas").build());
        Teacher teacher2A = teacherServices.save(Teacher.builder().name("Laracrisa Euclidiana").build());
        Teacher teacher3A = teacherServices.save(Teacher.builder().name("Pepito Perez").build());

        Course course1 = coursesServices.save(Course.builder().name("2A").director(teacher2A).build());
        coursesServices.save(Course.builder().name("3A").director(teacher3A).build());
        subjectServices.save(Subject.builder().name("Matemáticas").build());
        subjectServices.save(Subject.builder().name("Lenguaje").build());
        subjectServices.save(Subject.builder().name("Historia").build());
        subjectServices.save(Subject.builder().name("Geometría").build());
        subjectServices.save(Subject.builder().name("Ética").build());
        subjectServices.save(Subject.builder().name("Matemáticas").build());
    }
}
