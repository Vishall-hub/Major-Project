package in.at.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.at.main.entity.EventAttendance;
import in.at.main.entity.EventAttendanceId;

@Repository
public interface EventAttendanceRepository extends JpaRepository<EventAttendance, EventAttendanceId> {

    List<EventAttendance> findByIdRollNo(String rollNo);
}

