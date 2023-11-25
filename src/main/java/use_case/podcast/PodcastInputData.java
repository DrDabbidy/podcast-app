package use_case.podcast;

import entities.MediaItem;
import entities.User;

import java.util.List;


public class PodcastInputData {
    final private String title;
    final private String description;
    final private User assignedTo;
    final private List<MediaItem> episodes;

    public PodcastInputData(String title, String description, User assignedTo, List<MediaItem> episodes) {
        this.title = title;
        this.description = description;
        this.assignedTo = assignedTo;
        this.episodes = episodes;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription(){
        return description;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public List<MediaItem> getEpisodes(){
        return episodes;
    }


}
