package minim.controller.action.base;

import minim.model.Character;
import minim.model.Group;
import minim.model.Unit;

/**
 * Not a really a game action, doesn't have to delegate from {@link Group}s to
 * {@link Character}s.
 * 
 * @author alex
 */
public abstract class SimpleAction extends Action {

	public SimpleAction(Unit u) {
		super(u);
	}

	@Override
	abstract public void run();

	@Override
	public int run(Character character) {
		// never called
		throw new RuntimeException("Should not be called #simpleaction");
	}
}
