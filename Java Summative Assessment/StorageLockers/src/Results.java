// Results.java
// Stores test results or logs (placeholder for future development)

public class Results {
    private int successes;
    private String[] messages;
    private int messageIndex;

    public Results() {
        messages = new String[100];
        messageIndex = 0;
        successes = 0;
    }

    public void logSuccess(String message) {
        messages[messageIndex++] = "SUCCESS: " + message;
        successes++;
    }

    public void logError(String message) {
        messages[messageIndex++] = "ERROR: " + message;
    }

    public void printSummary() {
        System.out.println("Total Successes: " + successes);
        for (int i = 0; i < messageIndex; i++) {
            System.out.println(messages[i]);
        }
    }
}