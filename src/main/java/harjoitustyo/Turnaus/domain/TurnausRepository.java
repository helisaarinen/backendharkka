package harjoitustyo.Turnaus.domain;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TurnausRepository extends CrudRepository<Turnaus, Long> {
	
	List<Turnaus> findByNimi(String nimi);
	List<Turnaus> findByAlkupva(LocalDate alkupva);


}
