package in.at.main.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.at.main.EventAttendenceSystemApplication;
import in.at.main.entity.EventAttendance;
import in.at.main.entity.NormalAttendance;
import in.at.main.repository.EventAttendanceRepository;
import in.at.main.repository.NormalAttendanceRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/faculty")
@RequiredArgsConstructor
public class FacultyController {

    private final EventAttendenceSystemApplication eventAttendenceSystemApplication;

    private final NormalAttendanceRepository normalRepo;
    private final EventAttendanceRepository eventRepo;

    public FacultyController(NormalAttendanceRepository normalRepo, EventAttendanceRepository eventRepo) {
        this.eventAttendenceSystemApplication = new EventAttendenceSystemApplication();
		this.normalRepo = normalRepo;
        this.eventRepo = eventRepo;
    }

    @GetMapping("/normal/all")
    public List<NormalAttendance> getAllNormalAttendance() {
        return normalRepo.findAll();
    }

    @GetMapping("/event/all")
    public List<EventAttendance> getAllEventAttendance() {
        return eventRepo.findAll();
    }
}
