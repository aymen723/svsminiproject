package svsminiproject;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
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

		Set<Marking> markingGraph = MarkingGraphGenerator.generateMarkingGraph(petriNet);

		int markingCount = 1;
		for (Marking marking : markingGraph) {
			System.out.println("Marking " + markingCount + ":");
			for (Place place : petriNet.places) {
				System.out.println(" " + place.name + ": " + marking.getTokens(place));
			}
			markingCount++;
		}

		String nuSMVCode = MarkingGraphGenerator.generateNuSMVCode(petriNet, markingGraph);

		System.out.println(nuSMVCode);
	}

}
