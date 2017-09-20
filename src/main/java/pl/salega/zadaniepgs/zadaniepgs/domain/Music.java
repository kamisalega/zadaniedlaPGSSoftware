package pl.salega.zadaniepgs.zadaniepgs.domain;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private String genre;
    private String format;
    private boolean active = true;

    @Transient
    private MultipartFile musicImage;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public MultipartFile getMusicImage() {
        return musicImage;
    }

    public void setMusicImage(MultipartFile musicImage) {
        this.musicImage = musicImage;
    }
}
