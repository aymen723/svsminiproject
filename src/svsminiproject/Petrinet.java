package svsminiproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Petrinet {
	   List<Place> places ;
	    List<Transition> transitions;
	    List<Arc> arcs;
	    
	    public Petrinet() {
	        places = new ArrayList<>();
	        transitions = new ArrayList<>();
	        arcs = new ArrayList<>();
	    }
	    
	    public void addPlace(Place place) {
	        places.add(place);
	    }

	    public void addTransition(Transition transition) {
	        transitions.add(transition);
	    }

	    public void addArc(Arc arc) {
	        arcs.add(arc);
	    }

	    // Constructor, getters and setters for places, transitions and arcs

	    public void fire(Transition t, Marking m) {
	        for (Arc arc : arcs) {
	            if (arc.getTransition() == t) {
	                int tokens = arc.getDirection() == ArcDirection.IN ? -arc.getWeight() : arc.getWeight();
	                m.update(arc.getPlace(), tokens);
	            }
	        }
	    }

	    public Set<Marking> generateMarkingGraph(Marking m, Set<Marking> visited) {
	        visited.add(m);

	        for (Transition t : transitions) {
	            if (m.canFire(t)) {
	                Marking newMarking = m.clone();
	                fire(t, newMarking);
	                if (!visited.contains(newMarking)) {
	                    generateMarkingGraph(newMarking, visited);
	                }
	            }
	        }

	        return visited;
	    }
	}

	