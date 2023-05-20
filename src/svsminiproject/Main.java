package svsminiproject;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// Create a Petri net and its graph of marking
		Petrinet petriNet = new Petrinet();

		Place p0 = new Place("p0", 1);
		Place p1 = new Place("p1", 2);
		Place p2 = new Place("p2", 0);

		petriNet.addPlace(p0);
		petriNet.addPlace(p1);
		petriNet.addPlace(p2);
		Transition t0 = new Transition("t1");

		t0.addInputPlace(p0);
		t0.addOutputPlace(p0);
		t0.addInputPlace(p1);
		t0.addOutputPlace(p2);
		Transition t1 = new Transition("t1");
		t1.addInputPlace(p1);
		t1.addInputPlace(p2);

		petriNet.addTransition(t0);
		petriNet.addTransition(t1);

		// Generate the NuSMV code
		String nuSMVCode = RdPToNuSMV.generateNuSMVCode(petriNet);

		// Print the NuSMV code
		System.out.println(nuSMVCode);
	}

}
