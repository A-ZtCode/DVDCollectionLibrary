package model;
import java.time.LocalDate;

// This class represents the DVD object with its properties
public class DVDPojo {
    private int dvdId;
    private String title;
    private LocalDate releaseDate;
    private String mpaaRating;
    private String directorName;
    private String studio;
    private String note;

    // Constructor for creating a new DVD
    public DVDPojo(int dvdId, String title, LocalDate releaseDate, String mpaaRating, String directorName, String studio, String note) {
        this.dvdId = dvdId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.mpaaRating = mpaaRating;
        this.directorName = directorName;
        this.studio = studio;
        this.note = note;
    }

    // Getters and Setters for the DVD properties
    public int getDvdId() { return dvdId; }
    public void setDvdId(int dvdId) { this.dvdId = dvdId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }
    public String getMpaaRating() { return mpaaRating; }
    public void setMpaaRating(String mpaaRating) { this.mpaaRating = mpaaRating; }
    public String getDirectorName() { return directorName; }
    public void setDirectorName(String directorName) { this.directorName = directorName; }
    public String getStudio() { return studio; }
    public void setStudio(String studio) { this.studio = studio; }
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    // toString method for displaying DVD information
    @Override
    public String toString() {
        return "DVDId=" + dvdId + ":Title=" + title + ":ReleaseDate=" + releaseDate + ":MPAARating=" + mpaaRating + ":DirectorName=" + directorName + ":Studio=" + studio + ":Note=" + note;
    }
}
