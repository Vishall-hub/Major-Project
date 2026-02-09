package in.at.main.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import in.at.main.entity.Event;

public interface EventFetchRepository extends JpaRepository<Event, Integer> {

}
