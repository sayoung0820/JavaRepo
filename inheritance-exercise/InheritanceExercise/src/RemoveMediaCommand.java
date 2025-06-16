
public class RemoveMediaCommand {
    private final MediaService mediaService;
    private final TerminalUtils terminalUtils;

    public RemoveMediaCommand(MediaService mediaService, TerminalUtils terminalUtils) {
        this.mediaService = mediaService;
        this.terminalUtils = terminalUtils;
    }

    public void executeRemoval() {
        terminalUtils.displayMediaList(mediaService.getAllMedia());
        if (mediaService.isEmpty()) {
            terminalUtils.displayMessage("No media to remove.");
            return;
        }

        String mediaToRemove = terminalUtils.getString("Please enter the name of the media to remove: ");

        boolean successfullyRemoved = mediaService.removeMedia(mediaToRemove);

        if (successfullyRemoved) {
            terminalUtils.displayMessage("Media: " + mediaToRemove + " removed successfully. ");
        } else {
            terminalUtils.displayMessage("Media: " + mediaToRemove + " not found.");
        }
    }
}
