package assignment2.assignment2.Models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>  {
    // you can add delete and do other sql basic opperations now that the id and everything has been connected
    List<User> findBySize(int size);
    List<User> findByPassword(String password);
}
