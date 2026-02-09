package in.at.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.at.main.entity.Subject;
import in.at.main.repository.SubjectRepository;

@RestController
@RequestMapping("/subject")
@CrossOrigin("*")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping("/all")
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
}
