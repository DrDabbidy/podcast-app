package entities;

import java.net.URI;
import java.util.UUID;

public class Episode extends MediaItem {
    private final Transcript transcript;
    private final String summary;

    public Episode(UUID id, String title, String description, Transcript transcript, String summary) {
        super(id, title, description);
        this.transcript = transcript;
        this.summary = summary;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public String getSummary() {
        return summary;
    }
}
