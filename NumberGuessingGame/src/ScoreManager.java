import java.util.ArrayList;

public class ScoreManager {

    private ArrayList<String> history;

    public ScoreManager() {
        history = new ArrayList<>();
    }

    public void addWin(int round, int attempts) {
        history.add("Round " + round + " - Guessed in " + attempts + " attempts");
    }

    public void addLoss(int round) {
        history.add("Round " + round + " - Lost");
    }

    public String getHistory() {

        if (history.isEmpty()) {
            return "No rounds played yet.";
        }

        StringBuilder sb = new StringBuilder();

        for (String result : history) {
            sb.append(result).append("\n");
        }

        return sb.toString();
    }
}
