package FootballDashboard;

import java.util.TreeMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DashboardRecord {
	
	public static String team1, team2;
	public static int score1, score2;
	public static Map<Integer, String> goalTeam1, goalTeam2;
	public static int gameState;
	
	public DashboardRecord(){
		
		team1 = "";
		team2 = "";
		score1 = 0;
		score2 = 0;
		goalTeam1 = new TreeMap<Integer, String>();
		goalTeam2 = new TreeMap<Integer, String>();
		gameState = -1; // -1: no game in progress, 0: game is in progress,  1: game is end
	}
	
	public String run(String input) {
			
			// Case 1: game starts
			if (gameState != 0 && Pattern.matches("^Start: '(.+)' vs. '(.+)'$", input)) {

				Pattern r = Pattern.compile("Start: '(.+)' vs. '(.+)'$"); 
				
				Matcher m = r.matcher(input);
				while (m.find()) {
					team1 = m.group(1);
					team2 = m.group(2);
				}
				gameState = 0; // game starts

				return String.format("%s %d vs. %s %d\n", team1, score1, team2, score2);

			}
			
			// Case 2: goals
			else if (Pattern.matches("^(\\d+) '(.+)' (.+)$", input)) {
				
				if (gameState != 0) {
					return "No game currently in progress";
				}
				
				Pattern pattern = Pattern.compile("(\\d+) '(.+)' (.+)");
				Matcher matcher = pattern.matcher(input);
				String scoreTeam = " ";
				int scoreTime = 0;
				String scorePlayer = "";
				while (matcher.find()) {
					scoreTime = Integer.parseInt(matcher.group(1));
					scoreTeam = matcher.group(2);
					scorePlayer = matcher.group(3);
				}

				if (scoreTeam.equals(team1)) {
					score1++;
					goalTeam1.put(scoreTime, scorePlayer);
				}
				if (scoreTeam.equals(team2)) {
					score2++;
					goalTeam2.put(scoreTime, scorePlayer);
				}
				
				return "Goal!!!\n" + currentStatistics();

			}
			
			// Case 3
			else if (input.equals("print")) {
				
				if (gameState != 0) {
					return "No game currently in progress";
				}
				
				
				return currentStatistics();
			}
			
			// Case 4
			else if (input.equals("End")) {
				
				if (gameState != 0) {
					return "No game currently in progress";
				}
				
				gameState = 1;
				return "The game has ended!\n" + currentStatistics();

			}
			

			
			// Case 5b
			else if (gameState == 0) {
				return "input error - please type 'print' for game details";
			}
			
			// Case 5c
			return " 'input error - please start a game through typing 'Start:'<Name of Home Team>' vs. '<Name of Away Team>''.";

	}
	
	// get current aggregated scoring statistics
	private String currentStatistics(){
		
		String result = team1 + " " + score1 + " ";
		
		if (!goalTeam1.isEmpty()){
			result += "(";
			for (Map.Entry<Integer, String> entry : goalTeam1.entrySet()) {
				result += entry.getValue() + " " + entry.getKey() + "' ";
			}
			result = result.substring(0, result.length() -1); //remove the extra " "
			result += ")";
		}
		
		result += " vs. " + team2 + " " + score2 + " ";
		
		if (!goalTeam2.isEmpty()){
			result += "(";
			for (Map.Entry<Integer, String> entry : goalTeam2.entrySet()) {
				result += entry.getValue() + " " + entry.getKey() + "' ";
			}
			result = result.substring(0, result.length() -1); //remove the extra " "
			result += ")";
		}
		
		return result;
	}
}