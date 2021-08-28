package minim.controller.table.conjectural.loom;

public class YesNoConflict extends YesNoLoom {
	public YesNoConflict() {
		super("Yes/no (conflict)");
	}

	@Override
	public void build() {
		add(1, NO_AND_UNEXPECTEDLY);
		add(2, NO_BUT);
		add(3, 20, NO_AND);
		add(21, 50, NO);
		add(51, 80, YES);
		add(81, 98, YES_AND);
		add(99, YES_BUT);
		add(100, YES_AND_UNEXPECTEDLY);
	}
}
