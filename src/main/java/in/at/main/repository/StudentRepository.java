package in.at.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.at.main.entity.Branch;
import in.at.main.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

    @Query("SELECT DISTINCT s.branch FROM Student s")
    List<String> findAllBranches();

    List<Student> findByBranch(Branch b);
}
