package svsminiproject;

import java.util.ArrayList;
import java.util.List;

class Transition {
    String name;
    List<Place> inputPlaces;
    List<Place> outputPlaces;

    public Transition(String name) {
        this.name = name;
        this.inputPlaces = new ArrayList<>();
        this.outputPlaces = new ArrayList<>();
    }

    public void addInputPlace(Place place) {
        inputPlaces.add(place);
    }

    public void addOutputPlace(Place place) {
        outputPlaces.add(place);
    }
}