package co.com.jdti.school;

import co.com.jdti.school.model.entities.Course;
import co.com.jdti.school.model.entities.Schedule;
import co.com.jdti.school.model.entities.ScoreReference;
import co.com.jdti.school.model.entities.Student;
import co.com.jdti.school.model.entities.Subject;
import co.com.jdti.school.model.entities.Teacher;
import co.com.jdti.school.model.repositories.IScoreDao;
import co.com.jdti.school.model.repositories.IScoreReferenceDao;
import co.com.jdti.school.services.CoursesServices;
import co.com.jdti.school.services.ScheduleServices;
import co.com.jdti.school.services.StudentServices;
import co.com.jdti.school.services.SubjectServices;
import co.com.jdti.school.services.TeacherServices;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@RequiredArgsConstructor
@SpringBootApplication
public class SchoolApplication implements CommandLineRunner {

    private final StudentServices studentServices;
    private final CoursesServices coursesServices;
    private final TeacherServices teacherServices;
    private final SubjectServices subjectServices;
    private final ScheduleServices scheduleServices;
    private final IScoreDao iScoreDao;
    private final IScoreReferenceDao iScoreReferenceDao;

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Teacher director2A = teacherServices.save(Teacher.builder().name("Laracrisa Euclidiana").build());
        Teacher director3A = teacherServices.save(Teacher.builder().name("Pepito Perez").build());
        Teacher director4A = teacherServices.save(Teacher.builder().name("Fulanito de Tal").build());
        Teacher director5A = teacherServices.save(Teacher.builder().name("Juanita Perez").build());
        Teacher director6A = teacherServices.save(Teacher.builder().name("Pepito Jr. Perez").build());

        Subject math = subjectServices.save(Subject.builder().name("Matemáticas").build());
        Subject lang = subjectServices.save(Subject.builder().name("Lenguaje").build());
        Subject history = subjectServices.save(Subject.builder().name("Historia").build());
        Subject geometry = subjectServices.save(Subject.builder().name("Geometría").build());
        Subject ethic = subjectServices.save(Subject.builder().name("Ética").build());

        Course course1 = coursesServices.save(Course.builder().name("2A").director(director2A).build());
        Course course2 = coursesServices.save(Course.builder().name("3A").director(director3A).build());
        Course course3 = coursesServices.save(Course.builder().name("4A").director(director4A).build());
        Course course4 = coursesServices.save(Course.builder().name("5A").director(director5A).build());
        Course course5 = coursesServices.save(Course.builder().name("6A").director(director6A).build());

        Student student1 = studentServices.save(Student.builder().dni("dni1").name("Hugo").lastname("Fulano").bloodGroup("A-").address("Calle 1").courseId(course1.getId()).build());
        Student student2 = studentServices.save(Student.builder().dni("dni2").name("Paco").lastname("Perez").bloodGroup("O-").address("Calle 2").fatherName("Pepito").motherName("Perez").courseId(course1.getId()).build());
        Student student3 = studentServices.save(Student.builder().dni("dni3").name("Luis").lastname("Mengano").bloodGroup("O+").address("Calle 3").courseId(course1.getId()).build());
        Student student4 = studentServices.save(Student.builder().dni("dni4").name("Paco").lastname("Mengano").bloodGroup("O+").address("Calle 4").build());

        Schedule schedule1 = scheduleServices.save(Schedule.builder().start(new Date()).end(new Date()).subjectId(math.getId()).courseId(course1.getId()).title(math.getName()).build());
        Schedule schedule2 = scheduleServices.save(Schedule.builder().start(new Date()).end(new Date()).subjectId(history.getId()).courseId(course1.getId()).title(history.getName()).build());

        ScoreReference scoreReference1 = iScoreReferenceDao.save(ScoreReference.builder().name("Test 1").courseId(course1.getId()).subjectId(math.getId()).build());
    }
}
