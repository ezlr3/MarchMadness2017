package matt_farrington_bracket_2017;

import java.io.FileReader;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Team {
	
	private String ONE_PT_ALLOWED_PCT_FILE_PATH = ".//data//1_pt_%_allowed.csv";
	private String TWO_PT_ALLOWED_PCT_FILE_PATH = ".//data//2_pt_%_allowed.csv";
	private String THREE_PT_ALLOWED_PCT_FILE_PATH = ".//data//3_pt_%_allowed.csv";
	
	private String ONE_PT_SHOOTING_PCT_FILE_PATH = ".//data//1_pt_shooting_%.csv";
	private String TWO_PT_SHOOTING_PCT_FILE_PATH = ".//data//2_pt_shooting_%.csv";
	private String THREE_PT_SHOOTING_PCT_FILE_PATH = ".//data//3_pt_shooting_%.csv";
	
	private String ONE_PT_SHOTS_ALLOWED_FILE_PATH = ".//data//1_pt_shots_allowed.csv";
	private String TWO_PT_SHOTS_ALLOWED_FILE_PATH = ".//data//2_pt_shots_allowed.csv";
	private String THREE_PT_SHOTS_ALLOWED_FILE_PATH = ".//data//3_pt_shots_allowed.csv";
	
	private String ONE_PT_SHOTS_ATTEMPTED_FILE_PATH = ".//data//1_pt_shots_attempted.csv";
	private String TWO_PT_SHOTS_ATTEMPTED_FILE_PATH = ".//data//2_pt_shots_attempted.csv";
	private String THREE_PT_SHOTS_ATTEMPTED_FILE_PATH = ".//data//3_pt_shots_attempted.csv";

	private double one_pt_allowed_pct;
	private double two_pt_allowed_pct;
	private double three_pt_allowed_pct;
	
	private double one_pt_shooting_pct;
	private double two_pt_shooting_pct;
	private double three_pt_shooting_pct;
	
	private double one_pt_shots_allowed;
	private double two_pt_shots_allowed;
	private double three_pt_shots_allowed;
	
	private double one_pt_shots_attempted;
	private double two_pt_shots_attempted;
	private double three_pt_shots_attempted;
	
	private String name;
	
	public Team(String name) throws Exception{
		this.name = name;
		
		one_pt_allowed_pct = getStat(name, ONE_PT_ALLOWED_PCT_FILE_PATH);
		two_pt_allowed_pct = getStat(name, TWO_PT_ALLOWED_PCT_FILE_PATH);
		three_pt_allowed_pct = getStat(name, THREE_PT_ALLOWED_PCT_FILE_PATH);
		
		one_pt_shooting_pct = getStat(name, ONE_PT_SHOOTING_PCT_FILE_PATH);
		two_pt_shooting_pct = getStat(name, TWO_PT_SHOOTING_PCT_FILE_PATH);
		three_pt_shooting_pct = getStat(name, THREE_PT_SHOOTING_PCT_FILE_PATH);
		
		one_pt_shots_allowed = getStat(name, ONE_PT_SHOTS_ALLOWED_FILE_PATH);
		two_pt_shots_allowed = getStat(name, TWO_PT_SHOTS_ALLOWED_FILE_PATH);
		three_pt_shots_allowed = getStat(name, THREE_PT_SHOTS_ALLOWED_FILE_PATH);
		
		one_pt_shots_attempted = getStat(name, ONE_PT_SHOTS_ATTEMPTED_FILE_PATH);
		two_pt_shots_attempted = getStat(name, TWO_PT_SHOTS_ATTEMPTED_FILE_PATH);
		three_pt_shots_attempted = getStat(name, THREE_PT_SHOTS_ATTEMPTED_FILE_PATH);
	}
	
	private double getStat(String name, String filePath) throws Exception{
		
		Reader fileReader = new FileReader(filePath);
		Iterable <CSVRecord> records = CSVFormat.EXCEL.parse(fileReader);
		for(CSVRecord row : records){
			if(name.equals(row.get(0))){
				return Double.parseDouble(row.get(1));
			}
		}
		throw new Exception("Unable to find stat");
	}
	

	public double getOne_pt_allowed_pct() {
		return one_pt_allowed_pct;
	}


	public double getTwo_pt_allowed_pct() {
		return two_pt_allowed_pct;
	}


	public double getThree_pt_allowed_pct() {
		return three_pt_allowed_pct;
	}


	public double getOne_pt_shooting_pct() {
		return one_pt_shooting_pct;
	}


	public double getTwo_pt_shooting_pct() {
		return two_pt_shooting_pct;
	}


	public double getThree_pt_shooting_pct() {
		return three_pt_shooting_pct;
	}


	public double getOne_pt_shots_allowed() {
		return one_pt_shots_allowed;
	}


	public double getTwo_pt_shots_allowed() {
		return two_pt_shots_allowed;
	}


	public double getThree_pt_shots_allowed() {
		return three_pt_shots_allowed;
	}


	public double getOne_pt_shots_attempted() {
		return one_pt_shots_attempted;
	}


	public double getTwo_pt_shots_attempted() {
		return two_pt_shots_attempted;
	}


	public double getThree_pt_shots_attempted() {
		return three_pt_shots_attempted;
	}

	public String getName() {
		return name;
	}

	public double getOverallShootingPct(){
		return (one_pt_shooting_pct + two_pt_shooting_pct + three_pt_shooting_pct)/3;
	}
		
}
