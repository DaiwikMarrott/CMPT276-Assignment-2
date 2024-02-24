package assignment2.assignment2.Controlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import assignment2.assignment2.Models.UserRepository;


@Controller //thids says that this class is a controller and it will take feedback from the client and the user
public class UsersController {

    @Autowired
    private UserRepository userRepo;
    
    @GetMapping("user/view")
    public String getAllUser(Model model) 
    {
        System.out.println("Getting all users");
        //  get all users from database
        List<User> users = userRepo.findAll();
        //end of database call
        model.addAttribute("us", users);
        return "user/DataBase";
    }
    
}
