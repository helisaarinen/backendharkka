package harjoitustyo.Turnaus.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface JoukkueRepository extends CrudRepository<Joukkue, Long> {

	public Joukkue findBySeura(Seura seura);
	
	List<Joukkue> findByNimi (String nimi);
	Optional<Joukkue> findById (Long joukkue_id);

	List<Joukkue> findAllByOrderByNimiAsc(); // Nouseva järjestys
	List<Joukkue> findAllByOrderByNimiDesc(); // Laskeva järjestys
			
}
