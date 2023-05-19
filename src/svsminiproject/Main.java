package svsminiproject;

import java.util.HashSet;
import java.util.Set;

public class Main {

	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	// Place p1 = new Place(1, "P1");
	// Place p2 = new Place(2, "P2");

	// // Create transitions
	// Transition t1 = new Transition(1, "T1");

	// // Create arcs
	// Arc arc1 = new Arc(p1, t1, 1, ArcDirection.IN);
	// Arc arc2 = new Arc(p2, t1, 1, ArcDirection.OUT);

	// // Create a PetriNet
	// Petrinet petriNet = new Petrinet();
	// petriNet.addPlace(p1);
	// petriNet.addPlace(p2);
	// petriNet.addTransition(t1);

	// // Create an initial marking
	// Marking initialMarking = new Marking();
	// initialMarking.setToken(p1, 1);

	// // Generate the marking graph
	// Set<Marking> markingGraph = petriNet.generateMarkingGraph(initialMarking);

	// // Print the marking graph
	// for (Marking marking : markingGraph) {
	// System.out.println("Marking: " + marking.getTokens());
	// }
	// }
	public static void main(String[] args) {
		// Create a Petri net and its graph of marking
		Petrinet petriNet = new Petrinet();

		Place p1 = new Place("p1", 1);
		Place p2 = new Place("p2", 0);
		petriNet.addPlace(p1);
		petriNet.addPlace(p2);

		Transition t1 = new Transition("t1");
		t1.addInputPlace(p1);
		t1.addOutputPlace(p2);
		petriNet.addTransition(t1);

		// Generate the NuSMV code
		String nuSMVCode = RdPToNuSMV.generateNuSMVCode(petriNet);

		// Print the NuSMV code
		System.out.println(nuSMVCode);
	}

}
