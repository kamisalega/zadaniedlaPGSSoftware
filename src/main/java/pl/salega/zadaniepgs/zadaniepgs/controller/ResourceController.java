package pl.salega.zadaniepgs.zadaniepgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.salega.zadaniepgs.zadaniepgs.service.MusicService;

import java.util.ArrayList;

@RestController
public class ResourceController {

    @Autowired
    private MusicService musicService;

    @RequestMapping(value = "/music/removeList", method = RequestMethod.POST)
    public String removeList(@RequestBody ArrayList<String> musicIdList, Model model) {

        for (String id : musicIdList) {
            String bookId = id.substring(9);
            musicService.removeOne(Long.parseLong(bookId));
        }

        return "delete success";

    }


}
