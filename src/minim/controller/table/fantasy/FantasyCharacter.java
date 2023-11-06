package minim.controller.table.fantasy;

import java.util.List;

import minim.controller.table.MetaTable.SimpleMetaTable;
import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

/**
 * Based on the Dungeons and dragons third edition's system reference document
 * (open game license).
 * 
 * TODO the kits here would make great NPC templates, starting at
 * average-attributes 2 (weak) and then +1 to everything forh eac of: average,
 * strong, epic.
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
  public static final Table MONK=new SimpleTable("Class (kit, monk)",
      List.of(MARTIAL.lines.get(0),"Ninja","Acrobat","Drunken master","Dervish",
          "Brawler","Samurai","Tattooist","Kinetic psionic","Metabolic psionic",
          "Teleporting psionic"));
  public static final Table FIGHTER=new SimpleTable("Class (kit, fighter)",
      List.of(MARTIAL.lines.get(1),"Barbarian","Duelist","Gladiator",
          "Field commander","Dragoon","Viking","Knight","Breaker","Defender",
          "Dual-wielder"));
  public static final Table ROGUE=new SimpleTable("Class (kit, rogue)",
      List.of(MARTIAL.lines.get(2),"Assassin","Infiltrator","Swashbuckler",
          "Dungeoneer","Poison-master","Cutpurse","Saboteur","Thug"));
  public static final Table PALADIN=new SimpleTable("Class (kit, paladin)",
      List.of(HYBRID.lines.get(0),"Demon-hunter","Witch-hunter","Exorcist",
          "Evangelist","Guardian","Justicar","Unholy knight"));
  public static final Table RANGER=new SimpleTable("Class (kit, ranger)",
      List.of(HYBRID.lines.get(1),"Warden","Archer","Hunter","Trapper",
          "Pathfinder","Rider","Mageblade"));
  public static final Table BARD=new SimpleTable("Class (kit, bard)",
      List.of(HYBRID.lines.get(2),"Loremaster","Diplomat","Navigator","Spy",
          "Orator","Gambler","Trickster","Jester","Juggler","Mime","Dancer",
          "Ministrel","Troubadour","Artificer","Gadgeteer","Apothecary",
          "Runesmith"));
  public static final Table CLERIC=new SimpleTable("Class (kit, cleric)",
      List.of(MAGICAL.lines.get(0),"Chaos cleric","Curses cleric",
          "Dream cleric","Glory cleric","Control cleric","Healing cleric",
          "Law cleric","Luck cleric","Madness cleric","Manipulation cleric",
          "Sacrifice cleric","Sun cleric","Wealth cleric"));
  public static final Table WIZARD=new SimpleTable("Class (kit, wizard)",
      List.of(MAGICAL.lines.get(1),"Air mage","Cold mage","Dimensional mage",
          "Earth mage","Electricity mage","Fire mage","Magma mage","Metal mage",
          "Mud mage","Shadow mage","Smoke mage","Steam mage","Time mage",
          "Water mage","Celestial warlock","Draconic warlock","Fey warlock",
          "Infernal warlock","Vampiric warlock","Shapeshifter warlock",
          "Animist wizard","Banishment wizard","Counter-spell wizard",
          "Demonologist wizard","Divination wizard","Illusionist wizard",
          "Necromancer wizard","Transmutation wizard"));
  public static final Table DRUID=new SimpleTable("Class (kit, druid)",
      List.of(MAGICAL.lines.get(2),"Weathermancer","Floramancer","Cultist",
          "Werewolf","Werebear","Wereboar","Werebat","Apiarist","Beastmaster",
          "Vermin-lord","Shaman"));
  public static final List<Table> KITS=List.of(FIGHTER,WIZARD,CLERIC,ROGUE,
      DRUID,PALADIN,RANGER,BARD,MONK);
  public static final Kit KIT=new Kit("Class (kit)",TYPES);
  public static final Table RACE=new SimpleTable("Race",
      List.of("Human","Dwarf","Elf","Gnome","Half-elf","Half-orc","Halfling"));
  public static List<String> TIERS=List.of("Low-level","Mid-level","High-level",
      "Epic-level");
  public static final Table LEVEL=new Table("Level"){
    @Override
    public void build(){
      add(100,TIERS.get(0));
      add(30,TIERS.get(1));
      add(6,TIERS.get(2));
      add(1,TIERS.get(3));
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
