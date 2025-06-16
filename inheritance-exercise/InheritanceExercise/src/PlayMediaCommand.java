public class PlayMediaCommand {
    private final MediaService mediaService;
    private final TerminalUtils terminalUtils;

    public PlayMediaCommand(MediaService mediaService, TerminalUtils terminalUtils) {
        this.mediaService = mediaService;
        this.terminalUtils = terminalUtils;
    }

    public void executePlay() {
        if (mediaService.isEmpty()) {
            terminalUtils.displayMessage("No media to play.");
            return;
        }

        String nameToPlay = terminalUtils.getString("Enter the name of the media you want to play.");

        Media mediaToPlay = mediaService.findMediaByName((nameToPlay));

        if (mediaToPlay != null) {
            terminalUtils.displayMessage("Now playing: " + mediaToPlay.getDescription());
        } else {
            terminalUtils.displayMessage("Media not found.");
        }

    }
}
