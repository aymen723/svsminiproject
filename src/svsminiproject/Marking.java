package svsminiproject;

import java.util.HashMap;
import java.util.Map;


public class Marking {
	    Map<Place, Integer> tokens ;
	    public Marking() {
	        tokens = new HashMap<>();
	    }

	    // Constructor, getters and setters for tokens
	    public void setToken(Place place, int tokenCount) {
	        tokens.put(place, tokenCount);
	    }

	    public Map<Place, Integer> getTokens() {
	        return tokens;
	    }
	    public void update(Place p, int n) {
	        int currentTokens = tokens.getOrDefault(p, 0);
	        tokens.put(p, currentTokens + n);
	    }

	    public boolean canFire(Transition t) {
	        for (Arc arc : t.getIncomingArcs()) {
	            if (tokens.getOrDefault(arc.getPlace(), 0) < arc.getWeight()) {
	                return false;
	            }
	        }
	        return true;
	    }

	    public Marking clone() {
	        Marking newMarking = new Marking();
	        newMarking.tokens = new HashMap<>(tokens);
	        return newMarking;
	    }
}


