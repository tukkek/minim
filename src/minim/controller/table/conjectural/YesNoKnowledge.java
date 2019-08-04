package minim.controller.table.conjectural;

public class YesNoKnowledge extends YesNoLoom {
	public YesNoKnowledge() {
		super("Yes/no (knowledge)");
	}

	@Override
	public void build() {
		add(1, 5, NO_AND_UNEXPECTEDLY);
		add(6, 15, NO_BUT);
		add(16, 20, NO_AND);
		add(21, 50, NO);
		add(51, 80, YES);
		add(81, 85, YES_AND);
		add(86, 95, YES_BUT);
		add(96, 100, YES_AND_UNEXPECTEDLY);
	}
}
