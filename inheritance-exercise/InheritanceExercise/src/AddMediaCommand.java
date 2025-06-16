import java.util.Scanner;

public class AddMediaCommand {
    private final MediaService mediaService;
    private final TerminalUtils terminalUtils;

    public AddMediaCommand(MediaService mediaService, TerminalUtils terminalUtils) {
        this.mediaService = mediaService;
        this.terminalUtils = terminalUtils;
    }

    public void showMediaOptions() {
        terminalUtils.displayMessage("Select media type to add: ");
        System.out.println("1. Video");
        System.out.println("2. Audio");
        System.out.println("3. Image");
        System.out.println("4. Book");

        int choice = terminalUtils.getInt("Choose type: ");

        Media newMedia = null;

        switch (choice) {
            case 1:
                String videoName = terminalUtils.getString("Enter video name: ");
                int videoDuration = terminalUtils.getInt("Enter duration (minutes): ");
                String resolution = terminalUtils.getString("Enter resolution (e.g., 1080p, 4K): ");
                newMedia = new Video(videoName, videoDuration, resolution);
                break;

            case 2:
                String audioName = terminalUtils.getString("Enter audio name: ");
                int audioDuration = terminalUtils.getInt("Enter duration (minutes): ");
                String artist = terminalUtils.getString("Enter artist name: ");
                newMedia = new Audio(audioName, audioDuration, artist);
                break;

            case 3:
                String imageName = terminalUtils.getString("Enter image name: ");
                String dimensions = terminalUtils.getString("Enter dimensions (e.g., 1920x1080): ");
                String format = terminalUtils.getString("Enter file format (e.g., JPEG, PNG): ");
                newMedia = new Image(imageName, dimensions, format);
                break;

            case 4:
                String bookName = terminalUtils.getString("Enter book name: ");
                String author = terminalUtils.getString("Enter author name: ");
                int pages = terminalUtils.getInt("Enter page count: ");
                newMedia = new Book(bookName, author, pages);
                break;

            default:
                terminalUtils.displayMessage("Invalid media type selection. Please re-enter correct media type.");
                return;
        }
        mediaService.addMedia(newMedia);
        terminalUtils.displayMessage("Media added successfully!");
    }
}





