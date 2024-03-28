package harjoitustyo.Turnaus.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface SeuraRepository extends CrudRepository<Seura, Long>{
	
	List<Seura> findByNimi(String nimi);
	Optional<Seura> findById (Long seura_id);

}
