package minim.controller.table.tarot;

import java.util.List;

import minim.controller.table.SimpleTable;
import minim.controller.table.Table;

/**
 * Based on
 * http://www.random-generator.com/index.php?title=Tarot_Card&action=edit
 * 
 * @author alex
 */
public class TarotCard extends Table {
	public static final Table MAJOR = new SimpleTable("Tarot card (major arcana)", List.of(
			"The Fool -  Folly, mania, extravagance, intoxication, delirium, frenzy, bewrayment.",
			"The Magician -  kill, diplomacy, address, subtlety; sickness, pain, loss, disaster, snares of enemies; self-confidence, will; the Querent, if male.",
			"The High Priestess -  Secrets, mystery, the future as yet unrevealed; the woman who interests the Querent, if male; the Querent herself, if female; silence, tenacity; mystery, wisdom, science.",
			"The Empress -  Fruitfulness, action, initiative, length of days; the unknown, clandestine; also difficulty, doubt, ignorance.",
			"The Emperor -  Stability, power, protection, realization; a great person; aid, reason, conviction; also authority and will.",
			"The Heirophant -  Marriage, alliance, captivity, servitude; by another account, mercy and goodness; inspiration; the man to whom the Querent has recourse.",
			"The Lovers -  Attraction, love, beauty, trials overcome.",
			"The Chariot -  Succor, providence also war, triumph, presumption, vengeance, trouble.",
			"Fortitude -  Power, energy, action, courage, magnanimity; also complete success and honors.",
			"The Hermit -  Prudence, circumspection; also and especially treason, dissimulation, roguery, corruption.",
			"Wheel Of Fortune -  Destiny, fortune, success, elevation, luck, felicity.",
			"Justice -  Equity, rightness, probity, executive; triumph of the deserving side in law.",
			"The Hanged Man -  Wisdom, circumspection, discernment, trials, sacrifice, intuition, divination, prophecy.",
			"Death -  End, mortality, destruction, corruption also, for a man, the loss of a benefactor for a woman, many contrarieties; for a maid, failure of marriage projects.",
			"Temperance -  Economy, moderation, frugality, management, accommodation.",
			"The Devil -  Ravage, violence, vehemence, extraordinary efforts, force, fatality; that which is predestined but is not for this reason evil.",
			"The Tower -  Misery, distress, indigence, adversity, calamity, disgrace, deception, ruin. It is a card in particular of unforeseen catastrophe.",
			"The Star -  Loss, theft, privation, abandonment; another reading says-hope and bright prospects.",
			"The Moon -  Hidden enemies, danger, calumny, darkness, terror, deception, occult forces, error.",
			"The Sun -  Material happiness, fortunate marriage, contentment.",
			"The Last Judgment -  Change of position, renewal, outcome. Another account specifies total loss though lawsuit.",
			"The World -  Assured success, recompense, voyage, route, emigration, flight, change of place."));
	public static final Table WANDS = new SimpleTable("Tarot card (♣)", List.of(
			"King ♣ -  Generally favorable may signify a good marriage.",
			"Queen ♣ -  A good harvest, which may be taken in several senses.",
			"Knight ♣ -  A bad card; according to some readings, alienation.",
			"Page ♣ -  Young man of family in search of young lady.",
			"Ten ♣ -  Difficulties and contradictions, if near a good card.",
			"Nine ♣ -  Generally speaking, a bad card.", "Eight ♣ -  Domestic disputes for a married person.",
			"Seven ♣ -  A dark child.",
			"Six ♣ -  Servants may lose the confidence of their masters; a young lady may be betrayed by a friend.",
			"Five ♣ -  Success in financial speculation.", "Four ♣ -  Unexpected good fortune.",
			"Three ♣ -  A very good card; collaboration will favor enterprise.",
			"Two ♣ -  A young lady may expect trivial disappointments.", "Ace ♣ -  Calamities of all kinds."));
	public static final Table CUPS = new SimpleTable("Tarot card (♥)", List.of(
			"King ♥ -  Beware of ill-will on the part of a man of position, and of hypocrisy pretending to help.",
			"Queen ♥ -  Sometimes denotes a woman of equivocal character.",
			"Knight ♥ -  A visit from a friend, who will bring unexpected money to the Querent.",
			"Page ♥ -  Good augury; also a young man who is unfortunate in love.",
			"Ten ♥ -  For a male Querent, a good marriage and one beyond his expectations.",
			"Nine ♥ -  Of good augury for military men.", "Eight ♥ -  Marriage with a fair woman.",
			"Seven ♥ -  Fair child; idea, design, resolve, movement.", "Six ♥ -  Pleasant memories.",
			"Five ♥ -  Generally favorable; a happy marriage; also patrimony, legacies, gifts, success in enterprise.",
			"Four ♥ -  Contrarieties.", "Three ♥ -  Unexpected advancement for a military man.",
			"Two ♥ -  Favorable in things of pleasure and business, as well as love; also wealth and honor.",
			"Ace ♥ -  Inflexible will, unalterable law."));
	public static final Table SWORDS = new SimpleTable("Tarot card (♠)", List.of("King ♠ -  A lawyer, senator, doctor.",
			"Queen ♠ -  A widow.",
			"Knight ♠ -  A soldier, man of arms, satellite, stipendiary; heroic action predicted for soldier.",
			"Page ♠ -  An indiscreet person will pry into the Querent's secrets.",
			"Ten ♠ -  Followed by Ace and King, imprisonment; for girl or wife, treason on the part of friends.",
			"Nine ♠ -  An ecclesiastic, a priest; generally, a card of bad omen.",
			"Eight ♠ -  For a woman, scandal spread in her respect.",
			"Seven ♠ -  Dark girl; a good card; it promises a country life after a competence has been secured.",
			"Six ♠ -  The voyage will be pleasant.", "Five ♠ -  An attack on the fortune of the Querent.",
			"Four ♠ -  A bad card, but if reversed a qualified success may be expected by wise administration of affairs.",
			"Three ♠ -  For a woman, the flight of her lover.",
			"Two ♠ -  Gifts for a lady, influential protection for a man in search of help.",
			"Ace ♠ -  Great prosperity or great misery."));
	public static final Table PENTACLES = new SimpleTable("Tarot card (♦)",
			List.of("King ♦ -  A rather dark man, a merchant, master, professor.",
					"Queen ♦ -  Dark woman; presents from a rich relative; rich and happy marriage for a young man.",
					"Knight ♦ -  An useful man; useful discoveries.",
					"Page ♦ -  A dark youth; a young officer or soldier; a child.",
					"Ten ♦ -  Represents house or dwelling, and derives its value from other cards.",
					"Nine ♦ -  Prompt fulfillment of what is presaged by neighboring cards.",
					"Eight ♦ -  A young man in business who has relations with the Querent; a dark girl.",
					"Seven ♦ -  Improved position for a lady's future husband.",
					"Six ♦ -  The present must not be relied on.", "Five ♦ -  Conquest of fortune by reason.",
					"Four ♦ -  For a bachelor, pleasant news from a lady.",
					"Three ♦ -  If for a man, celebrity for his eldest son.",
					"Two ♦ -  Troubles are more imaginary than real.", "Ace ♦ -  The most favorable of all cards."));
	public static final TarotCard SINGLETON = new TarotCard();

	TarotCard() {
		super("Tarot card");
		rebuild = true;
	}

	@Override
	public void build() {
		add(MAJOR.roll());
		add(CUPS.roll());
		add(PENTACLES.roll());
		add(SWORDS.roll());
		add(WANDS.roll());
	}
}
