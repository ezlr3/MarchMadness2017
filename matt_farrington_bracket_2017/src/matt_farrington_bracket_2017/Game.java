package matt_farrington_bracket_2017;

public class Game {

	private Team winner;
	
	public Game(Team team1, Team team2) throws Exception{
		
		int team1_score = pointsScored(team1, team2);
		int team2_score = pointsScored(team2, team1);
		
		if(team1_score > team2_score){
			winner = team1;
							
		} else if(team2_score > team1_score) {
			winner = team2;
		} else {
			
			//Overtime: team w/ higher overall shooting % will win
			//If still the same, team2 will be the winner
			if(team1.getOverallShootingPct()>team2.getOverallShootingPct()){
				winner=team1;
			} else {
				winner=team2;
			}
		}
		
	}
	
	public Team getWinner(){
		return winner;
	}
	
	private int pointsScored(Team team1, Team team2) throws Exception{
		int ft_made = (int) (calcShotsTaken(1, team1, team2) * calcShootingPct(1, team1, team2));
		int two_pointers_made = (int) (calcShotsTaken(2, team1, team2) * calcShootingPct(2, team1, team2));
		int three_pointers_made = (int) (calcShotsTaken(3, team1, team2) * calcShootingPct(3, team1, team2));
		
		return ft_made + two_pointers_made + three_pointers_made;
	}
	
	private double calcShootingPct(int shotValue, Team team1, Team team2) throws Exception{
		double shootingPct;

		switch(shotValue){
			case 1: shootingPct = (team1.getOne_pt_shooting_pct() + team2.getOne_pt_allowed_pct())/2; break;
			case 2: shootingPct = (team1.getTwo_pt_shooting_pct() + team2.getTwo_pt_allowed_pct())/2; break;
			case 3: shootingPct = (team1.getThree_pt_shooting_pct() + team2.getThree_pt_allowed_pct())/2; break;
			default: throw new Exception("Invalid shot value");
		}

		return shootingPct;
	}
	
	private int calcShotsTaken(int shotValue, Team team1, Team team2) throws Exception{
		int shotsTaken;

		switch(shotValue){
			case 1: shotsTaken = (int) Math.round((team1.getOne_pt_shots_attempted() + team2.getOne_pt_shots_allowed())/2); break;
			case 2: shotsTaken = (int) Math.round((team1.getTwo_pt_shots_attempted() + team2.getTwo_pt_shots_allowed())/2); break;
			case 3: shotsTaken = (int) Math.round((team1.getThree_pt_shots_attempted() + team2.getThree_pt_shots_allowed())/2); break;
			default: throw new Exception("Invalid shot value");
		}

		return shotsTaken;
		
		
	}
	
}
