public class ListAllMediaCommand {
    private final MediaService mediaService;
    private final TerminalUtils terminalUtils;

    public ListAllMediaCommand(MediaService mediaService, TerminalUtils terminalUtils) {
        this.mediaService = mediaService;
        this.terminalUtils = terminalUtils;
    }

    public void list () {
        terminalUtils.displayMediaList(mediaService.getAllMedia());
    }
}
