package pl.salega.zadaniepgs.zadaniepgs.repository;

import org.springframework.data.repository.CrudRepository;
import pl.salega.zadaniepgs.zadaniepgs.domain.Music;

public interface MusicRepository extends CrudRepository<Music, Long> {
}
