package assignment2.assignment2.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment2.assignment2.Models.Student;
import assignment2.assignment2.Models.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Long id, Student updatedStudent) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            // Update attributes as needed
            student.setName(updatedStudent.getName());
            student.setWeight(updatedStudent.getWeight());
            student.setHeight(updatedStudent.getHeight());
            student.setHairColor(updatedStudent.getHairColor());
            student.setGpa(updatedStudent.getGpa());
            studentRepository.save(student);
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

