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
        Teacher teacher2A = teacherServices.save(Teacher.builder().name("Laracrisa Euclidiana").build());
        Teacher teacher3A = teacherServices.save(Teacher.builder().name("Pepito Perez").build());

        Course course1 = coursesServices.save(Course.builder().name("2A").director(teacher2A).build());
        coursesServices.save(Course.builder().name("3A").director(teacher3A).build());
        coursesServices.save(Course.builder().name("4A").director(teacherServices.save(Teacher.builder().name("Fulanito de Tal").build())).build());
        coursesServices.save(Course.builder().name("5A").director(teacherServices.save(Teacher.builder().name("Juanita Perez").build())).build());
        coursesServices.save(Course.builder().name("6A").director(teacherServices.save(Teacher.builder().name("Pepito Jr. Perez").build())).build());
        subjectServices.save(Subject.builder().name("Matemáticas").build());
        subjectServices.save(Subject.builder().name("Lenguaje").build());
        subjectServices.save(Subject.builder().name("Historia").build());
        subjectServices.save(Subject.builder().name("Geometría").build());
        subjectServices.save(Subject.builder().name("Ética").build());
        subjectServices.save(Subject.builder().name("Matemáticas").build());
    }
}
