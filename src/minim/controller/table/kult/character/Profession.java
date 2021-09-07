package minim.controller.table.kult.character;

import java.util.List;

import minim.controller.table.SimpleTable;

public class Profession extends SimpleTable {
	public static final Profession INSTANCE = new Profession();
	public static final String UNEMPLOYED = "Unemployed";
	public static final String CRIMINAL = "Criminal";
	public static final String WORKER = "General worker";
	public static final String RENTIER = "Landlord";
	public static final String PI = "Private investigator";
	public static final String JOURNALIST = "Journalist";
	public static final String ARTIST = "Artist";
	public static final String SECURITY = "Security consultant";
	public static final String SPECOPS = "Officer in military special forces";
	public static final String INTELLIGENCE = "Intelligence officer";
	public static final String BUSINESSMAN = "Business man";
	public static final String ECONOMIST = "Economist";
	public static final String ENGINEER = "Engineer";
	public static final String CONSULTANT = "Consultant";
	public static final String LAWYER = "Lawyer";
	public static final String STUDENT = "Student";
	public static final String SCIENTIST = "Scientist";
	public static final String BODYGUARD = "Bodyguard";
	public static final String DETECTIVE = "Police detective";
	public static final String WRITER = "Writer";
	public static final String MUSICIAN = "Musician";
	public static final String BOUNCER = "Bouncer";

	Profession() {
		super("Character (profession)",
				List.of(UNEMPLOYED, CRIMINAL, WORKER, RENTIER, PI, JOURNALIST, ARTIST, SECURITY, SPECOPS, INTELLIGENCE,
						BUSINESSMAN, ECONOMIST, ENGINEER, CONSULTANT, LAWYER, STUDENT, SCIENTIST, BODYGUARD, DETECTIVE,
						WRITER, MUSICIAN, BOUNCER));
	}
}
