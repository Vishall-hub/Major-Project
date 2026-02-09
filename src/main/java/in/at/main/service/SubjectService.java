package in.at.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import in.at.main.entity.Subject;
import in.at.main.repository.SubjectRepository;

public class SubjectService {

	  @Autowired
	    private SubjectRepository subjectRepository;

	    public List<Subject> getAllSubjects() {
	        return subjectRepository.findAll();
	    }
}
