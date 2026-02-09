package in.at.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.at.main.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
