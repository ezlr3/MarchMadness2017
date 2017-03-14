package matt_farrington_bracket_2017;

import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Tournament {

	private String TEAM_FILE_PATH = ".//data//teams.csv";
	
	private LinkedList<Team> teams;
	private LinkedList<LinkedList<Team>> rounds = new LinkedList<LinkedList<Team>>();
	
	public static void main(String[] args) throws Exception{

		Tournament marchMadness2017 = new Tournament();
		marchMadness2017.printAllRounds();

	}
	
	private Tournament() throws Exception{
		
		//Generate teams
		teams = getTeams();
		
		//Generate first round
		rounds.add(teams);
		
		//Generate rounds, add to map
		LinkedList<Team> round = teams;
		for(int i=2; i<calcRounds(teams); i++){
			round = getNextRound(round);
			rounds.add(round);
		}
		
		//Determine Champion
		round = new LinkedList<Team>();
		round.add(new Game(rounds.getLast().get(0),rounds.getLast().get(1)).getWinner());
		rounds.add(round);
		
	}
	
	public LinkedList<Team> getNextRound(LinkedList<Team> teams) throws Exception{

		LinkedList<Team> nextRound = new LinkedList<Team>();
		Iterator<Team> itr = teams.iterator();
		
		while(itr.hasNext()){
			nextRound.add(new Game(itr.next(),itr.next()).getWinner());
		}
		return nextRound;
	}
		
		
	private void printAllRounds(){

		int roundNumber = 1;
		for(LinkedList<Team> teams : rounds){
			System.out.println("***Round " + roundNumber++ + "***");
			for(Team t : teams){
				System.out.println(t.getName());
			}
		}

	}
	
	private int calcRounds(LinkedList<Team> teams){
		return (int) (Math.log(64)/Math.log(2)) + 1;
	}

	public LinkedList<Team> getTeams() throws Exception{

		//Generate all of the teams from the file
		//File must order the teams by matched seed
		//(1,16,8,9,5,12,4,13,6,11,3,14,7,10,2,15) 
		//and by region (East-West-Midwest-South)
		Reader fileReader = new FileReader(TEAM_FILE_PATH);
		Iterable <CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(fileReader);

		String teamName;

		LinkedList<Team> teamList = new LinkedList<Team>();

		for(CSVRecord row : records){

			teamName = row.get("Team");

			//Check for play-in teams, if found, determine winner
			if(teamName.contains("/")){
				Team playInOne = new Team(teamName.split("/")[0]);
				Team playInTwo = new Team(teamName.split("/")[1]);
				teamList.add(new Game(playInOne,playInTwo).getWinner());
			} else {
				teamList.add(new Team(teamName));
			}
		}
		return teamList;
	}

}
