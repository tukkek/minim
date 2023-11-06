package minim.controller.table.fantasy;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

public class SimpleCharacter extends FantasyCharacter{
  public static final Table LOW=new SimpleTable("Class (simple, low-level)",
      List.of("Adept","Aristocrat","Commoner","Expert","Warrior"));
  public static final Table MID=new SimpleTable("Class (simple, mid-level)",
      List.of("Sorcerer (Adept/Aristocrat)","Shaman (Adept/Commoner)",
          "Bard (Adept/Expert)","Cleric (Adept/Warrior)",
          "Explorer (Aristocrat/Commoner)","Spy (Aristocrat/Expert)",
          "Duelist (Aristocrat/Warrior)","Rogue (Commoner/Expert)",
          "Barbarian (Commoner/Warrior)","Thug (Expert/Warrior)"));
  public static final Table HIGH=new SimpleTable("Class (simple, high-level)",
      List.of("Druid (Adept/Aristocrat/Commoner)",
          "Wizard (Adept/Aristocrat/Expert)",
          "Paladin (Adept/Aristocrat/Warrior)","Dancer (Adept/Commoner/Expert)",
          "Ranger (Adept/Commoner/Warrior)","Ninja (Adept/Expert/Warrior)",
          "Emissary (Aristocrat/Commoner/Expert)",
          "Warden (Aristocrat/Commoner/Warrior)",
          "Assassin (Aristocrat/Expert/Warrior)",
          "Monk (Commoner/Expert/Warrior)"));
  public static final Table EPIC=new SimpleTable("Class (simple, epic-level)",
      List.of("Magi (Adept/Aristocrat/Commoner/Expert)",
          "Bishop (Adept/Aristocrat/Commoner/Warrior)",
          "Samurai (Adept/Aristocrat/Expert/Warrior)",
          "Dervish (Adept/Commoner/Expert/Warrior)",
          "Commander (Aristocrat/Commoner/Expert/Warrior)"));
  static final List<Table> CLASSES=List.of(LOW,MID,HIGH,EPIC);

  public SimpleCharacter(){
    super();
    title+=" (simple)";
  }

  @Override
  public String roll(){
    var alignment=describe(ETHICS.roll(),MORALS.roll()).toLowerCase();
    var race=RACE.roll().toLowerCase();
    var l=LEVEL.roll();
    var tier=CLASSES.get(TIERS.indexOf(l)+1);
    var kit=tier.roll().toLowerCase();
    return "%s %s %s %s".formatted(l,alignment,race,kit);
  }
}
