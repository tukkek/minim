package minim.controller;

import minim.view.dialog.LazyInputDialog;

/**
 * Exception raised whenever an user cancel an action midway through, which can
 * happen at any point during a {@link LazyInputDialog}. The usual handling is
 * just abort the current action as most effects are only processed after every
 * input is received.
 * 
 * @author alex
 */
public class Cancel extends Exception {

}
