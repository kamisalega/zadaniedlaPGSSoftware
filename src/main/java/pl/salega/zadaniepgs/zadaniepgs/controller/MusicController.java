package pl.salega.zadaniepgs.zadaniepgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.salega.zadaniepgs.zadaniepgs.domain.Music;
import pl.salega.zadaniepgs.zadaniepgs.service.MusicService;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addMusic(Model model) {
        Music music = new Music();
        model.addAttribute("music", music);
        return "addMusic";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addMusicPost(@ModelAttribute("music") Music music, HttpServletRequest request) {
        
        musicService.save(music);
        MultipartFile musicImage = music.getMusicImage();
        try {
            byte[] bytes = musicImage.getBytes();
            String nameImg = music.getId() + ".png";
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                    new File("src/main/resources/static/image/music/" + nameImg)));
            stream.write(bytes);
            stream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:musicList";
    }

    @RequestMapping("/musicInfo")
    public String musicInfo(@RequestParam("id") Long id, Model model) {
        Music music = musicService.findOne(id);
        model.addAttribute("music", music);
        return "musicInfo";

    }

    @RequestMapping("/updateMusic")
    public String updatemusic(@RequestParam("id") Long id, Model model) {
        Music music = musicService.findOne(id);
        model.addAttribute("music", music);
        return "updateMusic";
    }

    @RequestMapping(value = "/updateMusic", method = RequestMethod.POST)
    public String updateMusicPost(@ModelAttribute("music") Music music, HttpServletRequest request) {
        musicService.save(music);

        MultipartFile musicImage = music.getMusicImage();


        if (!musicImage.isEmpty()) {
            try {
                byte[] bytes = musicImage.getBytes();
                String nameImg = music.getId() + ".png";
                Files.delete(Paths.get("src/main/resources/static/image/music/" + nameImg));
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                        new File("src/main/resources/static/image/music/" + nameImg)));
                stream.write(bytes);
                stream.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return "redirect:/music/musicInfo?id=" + music.getId();


    }


    @RequestMapping("/musicList")
    public String musicList(Model model) {
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musicList", musicList);

        return "musicList";
    }

}
