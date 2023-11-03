package minim.controller.table.fantasy;

import java.util.List;

import minim.controller.table.MetaTable.SimpleMetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

/**
 * Based on the Dungeons and dragons third edition's system reference document
 * (open game license).
 * 
 * @author alex
 */
public class FantasyCharacter extends Table{
  public static class Kit extends SimpleMetaTable{
    public Kit(String title,List<Table> tables){
      super(title,tables);
    }

    String roll(boolean swap){
      var r=super.roll();
      return swap?swap(r):r;
    }

    @Override
    public String roll(){
      return roll(true);
    }
  }

  public static final Table MAGICAL=new SimpleTable("Class (by type, magical)",
      List.of("Cleric","Wizard","Druid"));
  public static final Table HYBRID=new SimpleTable("Class (by type, hybrid)",
      List.of("Paladin","Ranger","Bard"));
  public static final Table MARTIAL=new SimpleTable("Class (by type, martial)",
      List.of("Monk","Fighter","Rogue"));
  public static final List<Table> TYPES=List.of(MAGICAL,HYBRID,MARTIAL);
  public static final Table LAWFUL=new SimpleTable("Class (by ethics, lawful)",
      TYPES.stream().map(t -> t.lines.get(0)).toList());
  public static final Table NEUTRAL=new SimpleTable(
      "Class (by ethics, neutral)",
      TYPES.stream().map(t -> t.lines.get(1)).toList());
  public static final Table CHAOTIC=new SimpleTable(
      "Class (by ethics, chaotic)",
      TYPES.stream().map(t -> t.lines.get(2)).toList());
  public static final SimpleTable ETHICS=new SimpleTable("Alignment (ethics)",
      List.of("Lawful","Neutral","Chaotic"));
  public static final SimpleTable MORALS=new SimpleTable("Alignment (morals)",
      List.of("Good","Neutral","Evil"));
  public static final Table ALIGNMENT=new Table("Alignment"){
    @Override
    public void build(){
      // don't
    }

    @Override
    public String roll(){
      var e=ETHICS.roll();
      var m=MORALS.roll();
      return describe(e,m);
    }
  };
  public static final Table FIGHTER=new SimpleTable("Class (kit, fighter)",
      List.of(MARTIAL.lines.get(1),"Barbarian"));
  public static final Table WIZARD=new SimpleTable("Class (kit, wizard)",
      List.of(MAGICAL.lines.get(1),"Sorcerer","Abjurer","Conjurer","Diviner",
          "Enchanter","Evoker","Illusionist","Necromancer","Transmuter"));
  public static final Table CLERIC=new SimpleTable("Class (kit, cleric)",
      List.of(MAGICAL.lines.get(0),"Air cleric","Animal cleric","Chaos cleric",
          "Death cleric","Destruction cleric","Earth cleric","Evil cleric",
          "Fire cleric","Good cleric","Healing cleric","Knowledge cleric",
          "Law cleric","Luck cleric","Magic cleric","Plant cleric",
          "Protection cleric","Strength cleric","Sun cleric","Travel cleric",
          "Trickery cleric","War cleric","Water cleric"));
  public static final List<Table> KITS=List.of(FIGHTER,WIZARD,CLERIC);
  public static final Kit KIT=new Kit("Class",TYPES);
  public static final Table RACE=new SimpleTable("Race",
      List.of("Human","Dwarf","Elf","Gnome","Half-elf","Half-orc","Halfling"));
  public static final Table LEVEL=new Table("Level"){
    @Override
    public void build(){
      add(100,"Low-level");
      add(30,"Mid-level");
      add(6,"High-level");
      add(1,"Epic-level");
    }
  };

  public FantasyCharacter(){
    super("Character");
  }

  @Override
  public void build(){
    // don't
  }

  static String describe(String ethic,String moral){
    if(ETHICS.lines.get(1).equals(ethic)&&MORALS.lines.get(1).equals(moral))
      return "Neutral";
    return "%s-%s".formatted(ethic,moral.toLowerCase());
  }

  boolean validate(String kit,String ethic,Table ethics,String forrbidden){
    return !(ethics.lines.contains(kit)&&ethic==forrbidden);
  }

  static String swap(String kit){
    var k=KITS.stream().filter(kits -> kits.lines.contains(kit)).findAny()
        .orElse(null);
    return k==null?kit:k.roll();
  }

  @Override
  public String roll(){
    var r=KIT.roll(false);
    var e=ETHICS.roll();
    while (!validate(r,e,LAWFUL,ETHICS.lines.get(2))
        ||!validate(r,e,CHAOTIC,ETHICS.lines.get(0)))
      e=ETHICS.roll();
    var l=LEVEL.roll();
    var alignment=describe(e,MORALS.roll()).toLowerCase();
    var race=RACE.roll().toLowerCase();
    r=swap(r).toLowerCase();
    return "%s %s %s %s".formatted(l,alignment,race,r);
  }
}
