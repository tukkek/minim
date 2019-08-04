package minim.controller.table.conjectural;

public class YesNoEnding extends YesNoLoom {
	public YesNoEnding() {
		super("Yes/no (ending)");
	}

	@Override
	public void build() {
		add(1, 2, NO_AND_UNEXPECTEDLY);
		add(3, 6, NO_BUT);
		add(7, 16, NO_AND);
		add(17, 50, NO);
		add(51, 84, YES);
		add(85, 94, YES_AND);
		add(95, 98, YES_BUT);
		add(99, 100, YES_AND_UNEXPECTEDLY);
	}
}
