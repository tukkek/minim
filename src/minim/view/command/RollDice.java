
package minim.view.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.eclipse.e4.core.di.annotations.Execute;

import minim.view.Output;
import minim.view.UnitList;

public class RollDice {
	@Execute
	public void execute() {
		try {
			var raw = UnitList.getname("Enter roll:", "1d2+3");
			var input = Arrays.stream(raw.split("[d+-]")).map(i -> Integer.parseInt(i)).collect(Collectors.toList());
			var dice = input.get(0);
			var sides = input.get(1);
			var roll = new ArrayList<Integer>(dice);
			for (var i = 0; i < dice; i++) {
				roll.add(minim.model.Character.roll(sides));
			}
			Output.print(
					"Rolls: " + roll.stream().map(r -> Integer.toString(r)).collect(Collectors.joining(", ")) + ".");
			var bonus = 0;
			if (input.size() > 2) {
				bonus = input.get(2);
				if (raw.contains("-"))
					bonus = -bonus;
			}
			if (dice > 1 || bonus != 0) {
				var total = roll.stream().reduce(Integer::sum).orElseThrow() + bonus;
				Output.print("Total: " + total + ".");
			}
			Output.print("");
		} catch (Exception e) {
			return;
		}
	}
}
