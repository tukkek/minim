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

  public static final String NAME="Fantasy character (%s)";
  public static final Table MAGICAL=new SimpleTable(
      NAME.formatted("magic-user"),List.of("Cleric","Wizard","Druid"));
  public static final Table HYBRID=new SimpleTable(NAME.formatted("hybrid"),
      List.of("Paladin","Ranger","Bard"));
  public static final Table MARTIAL=new SimpleTable(NAME.formatted("martial"),
      List.of("Monk","Fighter","Rogue"));
  public static final List<Table> TYPES=List.of(MAGICAL,HYBRID,MARTIAL);
  public static final Table LAWFUL=new SimpleTable(NAME.formatted("lawful"),
      TYPES.stream().map(t -> t.lines.get(0)).toList());
  public static final Table NEUTRAL=new SimpleTable(NAME.formatted("neutral"),
      TYPES.stream().map(t -> t.lines.get(1)).toList());
  public static final Table CHAOTIC=new SimpleTable(NAME.formatted("chaotic"),
      TYPES.stream().map(t -> t.lines.get(2)).toList());
  public static final SimpleTable ETHICS=new SimpleTable(
      NAME.formatted("alignment, ethics"),
      List.of("Lawful","Neutral","Chaotic"));
  public static final SimpleTable MORALS=new SimpleTable(
      NAME.formatted("alignment, morals"),List.of("Good","Neutral","Evil"));
  public static final Table ALIGNMENT=new Table(NAME.formatted("alignment")){
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
  public static final Table FIGHTER=new SimpleTable(
      NAME.formatted("kit, fighter"),List.of(MARTIAL.lines.get(1),"Barbarian"));
  public static final Table WIZARD=new SimpleTable(
      NAME.formatted("kit, wizard"),
      List.of(MAGICAL.lines.get(1),"Sorcerer","Abjurer","Conjurer","Diviner",
          "Enchanter","Evoker","Illusionist","Necromancer","Transmuter"));
  public static final Table CLERIC=new SimpleTable(
      NAME.formatted("kit, cleric"),
      List.of(MAGICAL.lines.get(0),"Air-god cleric","Animal-god cleric",
          "Chaos-god cleric","Death-god cleric","Destruction-god cleric",
          "Earth-god cleric","Evil-god cleric","Fire-god cleric",
          "Good-god cleric","Healing-god cleric","Knowledge-god cleric",
          "Law-god cleric","Luck-god cleric","Magic-god cleric",
          "Plant-god cleric","Protection-god cleric","Strength-god cleric",
          "Sun-god cleric","Travel-god cleric","Trickery-god cleric",
          "War-god cleric","Water-god cleric"));
  public static final List<Table> KITS=List.of(FIGHTER,WIZARD,CLERIC);
  public static final Kit KIT=new Kit(NAME.formatted("kit"),TYPES);
  public static final Table RACE=new SimpleTable(NAME.formatted("race"),
      List.of("Human","Dwarf","Elf","Gnome","Half-elf","Half-orc","Halfling"));

  public FantasyCharacter(){
    super(NAME.substring(0,NAME.length()-5));
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
    r=swap(r);
    var race=RACE.roll();
    var m=MORALS.roll();
    var alignment=describe(e,m);
    return "%s %s %s".formatted(alignment,race.toLowerCase(),r.toLowerCase());
  }
}
