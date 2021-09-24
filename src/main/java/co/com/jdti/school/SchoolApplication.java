package co.com.jdti.school;

import java.util.ArrayList;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.com.jdti.school.model.entities.Course;
import co.com.jdti.school.model.entities.Student;
import co.com.jdti.school.model.entities.Subject;
import co.com.jdti.school.model.entities.Teacher;
import co.com.jdti.school.services.ICourseServices;
import co.com.jdti.school.services.IStudentServices;
import co.com.jdti.school.services.ISubjectServices;
import co.com.jdti.school.services.ITeacherServices;

@RequiredArgsConstructor
@SpringBootApplication
public class SchoolApplication {
public class SchoolApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		Course course1 = iCourseServices
				.save(new Course("aka1", "2A", iTeacherServices.save(new Teacher("id1", "Laracrisa Euclidiana")),
						new ArrayList<>(), new ArrayList<>()));
		iCourseServices.save(new Course("aka1", "3A", iTeacherServices.save(new Teacher("id1", "Pepito Perez")),
				new ArrayList<>(), new ArrayList<>()));
		iCourseServices.save(new Course("aka2", "4A", iTeacherServices.save(new Teacher("id2", "Fulanito de Tal")),
				new ArrayList<>(), new ArrayList<>()));
		iCourseServices.save(new Course("aka3", "5A", iTeacherServices.save(new Teacher("id3", "Juanita Perez")),
				new ArrayList<>(), new ArrayList<>()));
		iCourseServices.save(new Course("aka4", "6A", iTeacherServices.save(new Teacher("id4", "Pepito Jr. Perez")),
				new ArrayList<>(), new ArrayList<>()));
		iStudentServices.save(new Student("aka1", "dni1", "Hugo", "Fulano", "A-", null, null, "Calle 1", course1));
		iStudentServices
				.save(new Student("aka2", "dni2", "Paco", "Perez", "O-", "Pepito", "Perez", "Calle 2", course1));
		iStudentServices.save(new Student("aka3", "dni3", "Luis", "Mengano", "O+", "", "", "Calle 3", null));
		iStudentServices.save(new Student("aka4", "dni4", "Paco", "Mengano", "O+", "", "", "Calle 4", null));
		iSubjectServices.save(new Subject(1, "Matemáticas", null));
		iSubjectServices.save(new Subject(2, "Lenguaje", null));
		iSubjectServices.save(new Subject(3, "Historia", null));
	}
}
