import java.util.ArrayList;


public class MediaService {
    private ArrayList<Media> mediaList;

    public MediaService() {
        mediaList = new ArrayList<>();
    }

    public void addMedia(Media media) {
        mediaList.add(media);
    }

    public boolean removeMedia(String name) {
        Media mediaToRemove = findMediaByName(name);
        if (mediaToRemove != null) {
            mediaList.remove(mediaToRemove);
            return true;
        }
        return false;
    }

    public Media findMediaByName(String name) {
        for (Media media : mediaList) {
            if (media.getName().equalsIgnoreCase(name)) {
                return media;
            }
        }
        return null;
    }
    public ArrayList<Media  > getAllMedia() {
        return new ArrayList<>(mediaList);
    }
    public int getMediaCount() {
        return mediaList.size();
    }
    public boolean isEmpty() {
        return mediaList.isEmpty();
    }

}


