package harjoitustyo.Turnaus.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface OtteluRepository extends CrudRepository<Ottelu, Long>{
	
	Optional<Ottelu> findById (Long ottelu_id);
	
	List<Ottelu> findByKotijoukkue(Joukkue joukkue);
	List<Ottelu> findByVierasjoukkue(Joukkue joukkue);
	

}
