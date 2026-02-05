package in.at.main.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import in.at.main.entity.EventAttendance;
import in.at.main.entity.NormalAttendance;
import in.at.main.entity.Status;
import in.at.main.repository.EventAttendanceRepository;
import in.at.main.repository.NormalAttendanceRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final NormalAttendanceRepository normalRepo;
    private final EventAttendanceRepository eventRepo;
    
    public AttendanceService(NormalAttendanceRepository normalRepo,
            EventAttendanceRepository eventRepo) {
this.normalRepo = normalRepo;
this.eventRepo = eventRepo;
}
  

    // Teacher marks normal attendance
    public void markNormalAttendance(List<NormalAttendance> list) {
        if (list == null || list.isEmpty()) {
            throw new RuntimeException("Attendance list is empty");
        }
        normalRepo.saveAll(list);
    }

    // Event coordinator marks event attendance
    public void markEventAttendance(List<EventAttendance> list) {

        if (list == null || list.isEmpty()) {
            throw new RuntimeException("Event Attendance list is empty");
        }

        eventRepo.saveAll(list);

        // after event attendance, update normal attendance
        updateNormalAttendanceFromEvent(list);
    }

    private void updateNormalAttendanceFromEvent(List<EventAttendance> list) {

        for (EventAttendance ea : list) {

            if (ea != null && ea.getStatus() == Status.PRESENT) {

                String rollNo = ea.getId().getRollNo();
                Integer slotId = ea.getId().getSlotId();
                LocalDate date = ea.getId().getAttendanceDate();

                // find normal attendance of same slot/date
                List<NormalAttendance> normalList = normalRepo.findAll();

                for (NormalAttendance na : normalList) {

                    if (na != null
                            && na.getId().getRollNo().equals(rollNo)
                            && na.getId().getSlotId().equals(slotId)
                            && na.getId().getAttendanceDate().equals(date)) {

                        na.setStatus(Status.PRESENT);
                        normalRepo.save(na);
                    }
                }
            }
        }
    }
}
