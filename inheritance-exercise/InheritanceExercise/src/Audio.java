public class Audio extends Media{
    private int duration;
    private String artist;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Audio(String name, int duration, String artist) {
        super(name);
        this.duration = duration;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println("Playing audio " + getName() + " using audio player software");

    }

    @Override
    public String getDescription() {
        return "Audio Name: " + getName() + "\nDuration: " + getDuration() + "\nArtist: " + getArtist();
    }
}



