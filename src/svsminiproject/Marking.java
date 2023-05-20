package svsminiproject;

import java.util.*;

class Marking {
    Map<Place, Integer> placeTokenMap;

    public Marking() {
        placeTokenMap = new HashMap<>();
    }

    public void setTokens(Place place, int tokens) {
        placeTokenMap.put(place, tokens);
    }

    public int getTokens(Place place) {
        return placeTokenMap.get(place);
    }

    public boolean isEnabled(Transition transition) {
        for (Place inputPlace : transition.inputPlaces) {
            if (getTokens(inputPlace) == 0) {
                return false;
            }
        }
        return true;
    }

    public Marking fire(Transition transition) {
        Marking newMarking = new Marking();
        for (Place place : placeTokenMap.keySet()) {
            int tokens = getTokens(place);
            if (transition.inputPlaces.contains(place)) {
                tokens--;
            }
            if (transition.outputPlaces.contains(place)) {
                tokens++;
            }
            newMarking.setTokens(place, tokens);
        }
        return newMarking;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Marking marking = (Marking) obj;
        return Objects.equals(placeTokenMap, marking.placeTokenMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeTokenMap);
    }
}
