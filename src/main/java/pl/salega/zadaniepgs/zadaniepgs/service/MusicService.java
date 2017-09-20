package pl.salega.zadaniepgs.zadaniepgs.service;

import pl.salega.zadaniepgs.zadaniepgs.domain.Music;

import java.util.List;

public interface MusicService {

    Music save(Music music);

    List<Music> findAll();

    Music findOne(Long id);

}
