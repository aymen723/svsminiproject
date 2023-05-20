package svsminiproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Petrinet {
	List<Place> places;
	List<Transition> transitions;

	public Petrinet() {
		places = new ArrayList<>();
		transitions = new ArrayList<>();
	}

	public void addPlace(Place place) {
		places.add(place);
	}

	public void addTransition(Transition transition) {
		transitions.add(transition);
	}
}