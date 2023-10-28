
package minim.view.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.eclipse.e4.core.di.annotations.Execute;

import minim.view.Output;
import minim.view.UnitList;

public class RollDice {
	String previous = "1d2+3";

	void roll() {
		var raw = UnitList.getname("Enter roll:", previous);
		if (raw == null) return;
		previous = raw;
		var input = Arrays.stream(raw.split("[d+-]")).map(i -> Integer.parseInt(i)).toList();
		var dice = input.get(0);
		var sides = input.get(1);
		var rolls = new ArrayList<Integer>(dice);
		for (var i = 0; i < dice; i++) rolls.add(minim.model.Character.roll(sides));
		String rolled = rolls.stream().map(r -> Integer.toString(r)).collect(Collectors.joining(", "));
		Output.print("Rolls: " + rolled + ".");
		var bonus = 0;
		if (input.size() > 2) {
			bonus = input.get(2);
			if (raw.contains("-")) bonus = -bonus;
		}
		var total = rolls.stream().reduce(Integer::sum).orElseThrow() + bonus;
		Output.print("Total: " + total + ".");
		var high = -1;
		var low = Integer.MAX_VALUE;
		for (var r : rolls) {
			if (r > high) high = r;
			if (r < low) low = r;
		}
		Output.print("High: " + high + ".");
		Output.print("Low: " + low + ".");
		Output.print("");
	}

	@Execute
	public void execute() {
		try {
			roll();
		} catch (Exception e) {
			return;
		}
	}
}
