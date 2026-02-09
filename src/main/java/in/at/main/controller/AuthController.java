package in.at.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.at.main.dto.LoginRequest;
import in.at.main.dto.LoginResponse;
import in.at.main.entity.User;
import in.at.main.repository.UserRepository;
import lombok.RequiredArgsConstructor;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthController {

    private final UserRepository userRepo;
    
    public AuthController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {

        User user = userRepo.findByUsername(req.getUsername()).orElse(null);

        if(user == null) {
            return ResponseEntity.status(401).body("Invalid Username or Password");
        }

        if(!user.getPassword().equals(req.getPassword())) {
            return ResponseEntity.status(401).body("Invalid Username or Password");
        }

        LoginResponse res = new LoginResponse(
                user.getUsername(),
                user.getRole().name(),
                user.getRollNo(),
                user.getFacultyId()
        );

        return ResponseEntity.ok(res);
    }

}
