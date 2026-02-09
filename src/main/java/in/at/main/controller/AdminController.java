package in.at.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.at.main.entity.Role;

import in.at.main.entity.User;
import in.at.main.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

	
    private final UserRepository userRepo;

    public AdminController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    
    @PostMapping("/createUser")
    public String createUser(@RequestBody CreateUserRequest req) {

        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(req.getPassword());
        user.setRole(req.getRole());

        if(req.getRole() == Role.STUDENT) {
            user.setRollNo(req.getRollNo());
        }
        
        if(req.getRole() == Role.FACULTY) {
            user.setFacultyId(req.getFacultyId());
        }

        userRepo.save(user);

        return "User Created Successfully";
    }
}
