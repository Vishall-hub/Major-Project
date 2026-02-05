package in.at.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.at.main.entity.NormalAttendance;
import in.at.main.entity.NormalAttendanceId;

@Repository
public interface NormalAttendanceRepository extends JpaRepository<NormalAttendance, NormalAttendanceId> {

    List<NormalAttendance> findByIdRollNo(String rollNo);
}


