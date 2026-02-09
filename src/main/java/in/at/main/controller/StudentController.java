package in.at.main.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.at.main.dto.AttendanceSummaryDTO;
import in.at.main.dto.StudentDTO;
import in.at.main.entity.Branch;
import in.at.main.entity.EventAttendance;
import in.at.main.entity.NormalAttendance;
import in.at.main.entity.Student;
import in.at.main.repository.EventAttendanceRepository;
import in.at.main.repository.NormalAttendanceRepository;
import in.at.main.repository.StudentRepository;
import in.at.main.service.AttendanceService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final NormalAttendanceRepository normalRepo;
    private final EventAttendanceRepository eventRepo;
    private final AttendanceService attendanceService;
    private final StudentRepository studentRepository;

    public StudentController(NormalAttendanceRepository normalRepo, EventAttendanceRepository eventRepo
    		,AttendanceService attendanceService, StudentRepository studentRepository) {
        this.normalRepo = normalRepo;
        this.eventRepo = eventRepo;
        this.attendanceService = attendanceService;
		this.studentRepository = studentRepository;
    }
    
    //in this both method do same work with diff way
    @GetMapping("/{rollNo}/normal")
    public List<NormalAttendance> getNormal(@PathVariable String rollNo) {
        return normalRepo.findByIdRollNo(rollNo);
    }

    @GetMapping("/{rollNo}/event")
    public List<EventAttendance> getEventAttendance(@PathVariable String rollNo) {
        return eventRepo.findAll()
                .stream()
                .filter(a -> a.getId().getRollNo().equals(rollNo))
                .toList();
    }
    
    
    // Subject wise attendance
    @GetMapping("/{rollNo}/summary/{subjectId}")
    public AttendanceSummaryDTO getSubjectWise(
            @PathVariable String rollNo, 
            @PathVariable Integer subjectId) {

        return attendanceService.getOverallSummaryBySubject(rollNo, subjectId);
    }

    
    // ✅ API-1: Get Departments (branches)
    @GetMapping("/department")
    public List<String> getDepartments() {
        return studentRepository.findAllBranches();
    }

    // ✅ API-2: Get Students by Department(branch)
    @GetMapping("/department/{branch}")
    public List<Student> getStudentsByDepartment(@PathVariable String branch) {

        try {
            Branch b = Branch.valueOf(branch.toUpperCase());
            return studentRepository.findByBranch(b);
        } catch (Exception e) {
            throw new RuntimeException("Invalid branch: " + branch);
        }
    }

    
    

    


}
