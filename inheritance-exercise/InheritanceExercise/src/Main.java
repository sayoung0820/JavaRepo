public class Main {


    public static void main(String[] arg) {
        MediaService mediaService = new MediaService();
        TerminalUtils terminalUtils = new TerminalUtils();

        boolean running = true;

        while (running) {
            terminalUtils.displayMenu();
            int choice = terminalUtils.getMenuChoice();

            switch (choice) {
                case 1:
                    AddMediaCommand addCommand = new AddMediaCommand(mediaService, terminalUtils);
                    addCommand.showMediaOptions();
                    break;
                case 2:
                    RemoveMediaCommand removeMediaCommand = new RemoveMediaCommand(mediaService, terminalUtils);
                    removeMediaCommand.executeRemoval();
                    break;
                case 3:
                    PlayMediaCommand playMediaCommand = new PlayMediaCommand(mediaService, terminalUtils);
                    playMediaCommand.executePlay();
                    break;
                case 4:
                    terminalUtils.displayMediaList(mediaService.getAllMedia());
                    break;
                case 5:
                    terminalUtils.displayMessage("Goodbye!");
                    running = false;
                    break;
                default:
                    terminalUtils.displayMessage("Invalid option. Please try again.");
            }
        }
    }
}

