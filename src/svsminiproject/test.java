package svsminiproject;

// import java.util.ArrayList;
// import java.util.List;

class Place {
    String name;
    int tokens;

    public Place(String name, int tokens) {
        this.name = name;
        this.tokens = tokens;
    }
}

// class Transition {
// String name;
// List<Place> inputPlaces;
// List<Place> outputPlaces;

// public Transition(String name) {
// this.name = name;
// this.inputPlaces = new ArrayList<>();
// this.outputPlaces = new ArrayList<>();
// }

// public void addInputPlace(Place place) {
// inputPlaces.add(place);
// }

// public void addOutputPlace(Place place) {
// outputPlaces.add(place);
// }
// }

// class PetriNet {
// List<Place> places;
// List<Transition> transitions;

// public PetriNet() {
// places = new ArrayList<>();
// transitions = new ArrayList<>();
// }

// public void addPlace(Place place) {
// places.add(place);
// }

// public void addTransition(Transition transition) {
// transitions.add(transition);
// }
// }

// public class RdPToNuSMV {

// public static String generateNuSMVCode(PetriNet petriNet) {
// StringBuilder nuSMVCode = new StringBuilder();

// // MODULE section
// nuSMVCode.append("MODULE main\n\n");

// // VAR section
// nuSMVCode.append("VAR\n");
// for (Place place : petriNet.places) {
// nuSMVCode.append(" ").append(place.name).append(" :
// 0..").append(place.tokens).append(";\n");
// }
// nuSMVCode.append("\n");

// // ASSIGN section
// nuSMVCode.append("ASSIGN\n");
// for (Place place : petriNet.places) {
// nuSMVCode.append(" init(").append(place.name).append(") :=
// ").append(place.tokens).append(";\n");
// }
// nuSMVCode.append("\n");

// // TRANS section
// nuSMVCode.append("TRANS\n");
// for (Transition transition : petriNet.transitions) {
// nuSMVCode.append(" (");
// for (Place inputPlace : transition.inputPlaces) {
// nuSMVCode.append(inputPlace.name).append(" > 0");
// if (transition.inputPlaces.indexOf(inputPlace) <
// transition.inputPlaces.size() - 1) {
// nuSMVCode.append(" & ");
// }
// }
// nuSMVCode.append(") -> (");
// for (Place outputPlace : transition.outputPlaces) {
// nuSMVCode.append("next(").append(outputPlace.name).append(") =
// ").append(outputPlace.name)
// .append(" + 1");
// if (transition.outputPlaces.indexOf(outputPlace) <
// transition.outputPlaces.size() - 1) {
// nuSMVCode.append(" & ");
// }
// }
// nuSMVCode.append(");\n");
// }

// return nuSMVCode.toString();
// }

// }

public class test {
    // public static void main(String[] args) {
    // // Create a Petri net and its graph of marking
    // PetriNet petriNet = new PetriNet();

    // Place p1 = new Place("p1", 1);
    // Place p2 = new Place("p2", 0);
    // petriNet.addPlace(p1);
    // petriNet.addPlace(p2);

    // Transition t1 = new Transition("t1");
    // t1.addInputPlace(p1);
    // t1.addOutputPlace(p2);
    // petriNet.addTransition(t1);

    // // Generate the NuSMV code
    // String nuSMVCode = generateNuSMVCode(petriNet);

    // // Print the NuSMV code
    // System.out.println(nuSMVCode);
    // }
}