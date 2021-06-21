import java.util.ArrayList;
import java.util.HashMap;
// import org.json.simple.JSONObject;
import java.util.Scanner;

public class mvp {

    public static void main(String[] args) {

        // Scanner is used for the purpose of this project to read lines
        Scanner in = new Scanner(System.in);
        ArrayList<String> secondLine = new ArrayList<String>();

        // System input first line to define game type, second line will be a loop to
        // enter game data
        String firstLine = in.nextLine();
        secondLine.add(in.nextLine());

        // loop over input to reach end of file
        while (!secondLine.toString().toLowerCase().equals("endfile")) {
            secondLine.add(in.nextLine());
        }

        // First line we should enter the type of the game either (BASKETBALL) or
        // (HANDBALL)
        if (firstLine.toString().toUpperCase().equals("BASKETBALL")) {
            calculateBasketballMVP(secondLine);
        } else if (firstLine.toString().toUpperCase().equals("HANDBALL")) {
            caculateHandballMVP(secondLine);
        }

        else {
            System.out.println("The game type you have entered doesn't match our current games.");
        }

        in.close();
    }

    static void calculateBasketballMVP(ArrayList<String> gameData) {
        HashMap<String, String> playersScore = new HashMap<String, String>();
        HashMap<String, Integer> allTeamsScore = new HashMap<String, Integer>();

        int score = 0;
        for (int i = 0; i < gameData.size(); i++) {
            String[] playerData = gameData.get(i).split(";");
            // check for data validity
            if (playerData.length < 9) {
                failedToCalculateMVP();
            }

            String playerName = playerData[0];
            String playerNickName = playerData[1];
            String playerNumber = playerData[2];
            String playerTeam = playerData[3];
            String playerPosition = playerData[4];
            String playerScore = playerData[5];
            String playerRebound = playerData[6];
            String playerAssists = playerData[7];

            // Add team score to see who is the winner
            if (allTeamsScore.containsKey(playerTeam)) {
                int previousScore = allTeamsScore.get(playerTeam) + Integer.parseInt(playerScore);
                allTeamsScore.put(playerTeam, previousScore);
            } else {
                allTeamsScore.put(playerTeam, Integer.parseInt(playerScore));
            }

            // Calculate player total score
            switch (playerPosition) {
                case "G":
                    score = Integer.parseInt(playerScore) * 2 + Integer.parseInt(playerRebound) * 3
                            + Integer.parseInt(playerAssists);
                    break;
                case "F":
                    score = Integer.parseInt(playerScore) * 2 + Integer.parseInt(playerRebound) * 2
                            + Integer.parseInt(playerAssists) * 2;
                    break;
                case "C":
                    score = Integer.parseInt(playerScore) * 2 + Integer.parseInt(playerRebound) * 1
                            + Integer.parseInt(playerAssists) * 3;
                    break;
            }

            // Set score and team for each player

        }

    }

    static void caculateHandballMVP(ArrayList<String> gameData) {

    }

    // game calculation failed, inform user
    static void failedToCalculateMVP() {
        System.out.println("Failed to calculate mvp due to file errors");
        return;
    }
}
