package harjoitustyo.Turnaus.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KuntaRepository extends CrudRepository<Kunta, Long>{
	
	List<Kunta> findByKunnannimi(String kunnannimi);

}
