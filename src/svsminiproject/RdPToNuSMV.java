// package svsminiproject;

// public class RdPToNuSMV {

// public static String generateNuSMVCode(Petrinet petriNet) {
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
