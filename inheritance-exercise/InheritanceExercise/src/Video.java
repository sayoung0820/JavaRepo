public class Video extends Media {
    private int duration;
    private String videoResolution;

    public Video(String name, int duration, String videoResolution) {
        super(name);
        this.duration = duration;
        this.videoResolution = videoResolution;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getVideoResolution() {
        return videoResolution;
    }

    public void setVideoResolution(String videoResolution) {
        this.videoResolution = videoResolution;

    }

        @Override
        public void play() {
            System.out.println("Playing video: " + getName() + " ,using video player software. ");
        }

        @Override
        public String getDescription() {
            return "Audio Name: " + getName() + "\nDuration" + getDuration() + "\nVideo Resolution: " + getVideoResolution();
        }

    }

