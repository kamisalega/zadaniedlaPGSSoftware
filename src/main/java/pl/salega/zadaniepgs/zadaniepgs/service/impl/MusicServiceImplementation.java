package pl.salega.zadaniepgs.zadaniepgs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.salega.zadaniepgs.zadaniepgs.domain.Music;
import pl.salega.zadaniepgs.zadaniepgs.repository.MusicRepository;
import pl.salega.zadaniepgs.zadaniepgs.service.MusicService;

import java.util.List;
@Service
public class MusicServiceImplementation implements MusicService {

    @Autowired
    private MusicRepository musicRepository;

    @Override
    public Music save(Music music) {
        return musicRepository.save(music);
    }

    @Override
    public List<Music> findAll() {
        return (List<Music>) musicRepository.findAll();
    }

    @Override
    public Music findOne(Long id) {
        return musicRepository.findOne(id);
    }
}
