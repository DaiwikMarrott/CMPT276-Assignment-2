package assignment2.assignment2.Models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Find all students
    List<Student> findAll();

    // Find student by name
    Student findByName(String name);

    // Find students by hair color
    List<Student> findByHairColor(String hairColor);

    // Find students with GPA greater than a given value
    List<Student> findByGpaGreaterThan(double gpa);

    // Find students with GPA less than a given value
    List<Student> findByGpaLessThan(double gpa);

    // Find students with GPA between two values
    List<Student> findByGpaBetween(double minGpa, double maxGpa);

    // Find students with a specific weight
    Student findByWeight(int weight);

    // Find students with a specific height
    Student findByHeight(int height);

    // Find students with a specific weight and height
    Student findByWeightAndHeight(int weight, int height);

    // Find students with a specific weight or height
    List<Student> findByWeightOrHeight(int weight, int height);

    // Find students with a specific hair color and GPA greater than a given value
    List<Student> findByHairColorAndGpaGreaterThan(String hairColor, double gpa);

    // Custom query to find students with a specific hair color or GPA less than a given value
    @Query("SELECT s FROM Student s WHERE s.hairColor = :hairColor OR s.gpa < :gpa")
    List<Student> findCustomQuery(String hairColor, double gpa);

    // Add any additional queries if needed

}

