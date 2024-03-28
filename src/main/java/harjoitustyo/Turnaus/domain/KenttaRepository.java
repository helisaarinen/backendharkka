package harjoitustyo.Turnaus.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KenttaRepository extends CrudRepository<Kentta, Long>{
	
	List<Kentta> findByNimi (String nimi);
	
}
