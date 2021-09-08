package minim.controller.table.kult.character;

import java.util.List;

import minim.controller.table.SimpleTable;

public class Profession extends SimpleTable {
	public static final Profession INSTANCE = new Profession();
	public static final String UNEMPLOYED = "Unemployed";
	public static final String CRIMINAL = "Criminal";
	public static final String WORKER = "General worker";
	public static final String LANDLORD = "Landlord";
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
	public static final String ROLLINGSTONE = "Constantly changing jobs";
	public static final String TECHNICIAN = "Technician";
	public static final String PROGRAMMER = "Programmer";
	public static final String HOUSEWIFE = "Housewife";
	public static final String RADICAL = "Member of a radical group";
	public static final String DIPLOMAT = "Diplomat";
	public static final String TRAINER = "Personal trainer";
	public static final String COACH = "Coach";
	public static final String ATHLETE = "Athlete";
	public static final String NURSE = "Nurse";
	public static final String PARENT = "Parent";
	public static final String GOVERNESS = "Governess";
	public static final String NANNY = "Nanny";
	public static final String SOCIAL = "Social worker";
	public static final String TV = "TV personality";
	public static final String MODEL = "Model";
	public static final String TEACHER = "Teacher";
	public static final String MONK = "Monk or nun";
	public static final String CLERGY = "Minister, priest, rabbi...";
	public static final String PSYCHIATRIST = "Psychiatrist";
	public static final String PHYSICIAN = "Physician";
	public static final String SECRETARY = "Secretary";
	public static final String GAMEDEV = "Game designer";
	public static final String BARTENDER = "Baretender";
	public static final String PROSTITUTE = "Prostitute";
	public static final String ODDJOBS = "Odd jobs";
	public static final String CURATOR = "Curator";
	public static final String LIBRARIAN = "Librarian";

	Profession() {
		super("Character (profession)",
				List.of(UNEMPLOYED, CRIMINAL, WORKER, LANDLORD, PI, JOURNALIST, ARTIST, SECURITY, SPECOPS, INTELLIGENCE,
						BUSINESSMAN, ECONOMIST, ENGINEER, CONSULTANT, LAWYER, STUDENT, SCIENTIST, BODYGUARD, DETECTIVE,
						WRITER, MUSICIAN, BOUNCER, ROLLINGSTONE, TECHNICIAN, PROGRAMMER, HOUSEWIFE, RADICAL, DIPLOMAT,
						TRAINER, COACH, ATHLETE, NURSE, PARENT, GOVERNESS, NANNY, SOCIAL, TV, MODEL, TEACHER, MONK,
						CLERGY, PSYCHIATRIST, PHYSICIAN, SECRETARY, GAMEDEV, BARTENDER, PROSTITUTE, ODDJOBS, CURATOR,
						LIBRARIAN));
	}
}
