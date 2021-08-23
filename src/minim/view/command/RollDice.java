
package minim.view.command;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.eclipse.e4.core.di.annotations.Execute;

import minim.view.Output;
import minim.view.UnitList;

public class RollDice {
	@Execute
	public void execute() {
		try {
			var dice = Integer.parseInt(UnitList.getname("Roll how many dice?", "1"));
			var sides = Integer.parseInt(UnitList.getname("How many sides per dice?", "6"));
			var roll = new ArrayList<Integer>(dice);
			var bonus = Integer.parseInt(UnitList.getname("Add bonus or penalty?", "+0"));
			for (var i = 0; i < dice; i++) {
				roll.add(minim.model.Character.roll(sides));
			}
			Output.print(
					"Rolls: " + roll.stream().map(r -> Integer.toString(r)).collect(Collectors.joining(" ")) + ".");
			var total = roll.stream().reduce(Integer::sum).orElseThrow() + bonus;
			Output.print("Total: " + total + ".");
			Output.print("");
		} catch (Exception e) {
			return;
		}
	}
}
