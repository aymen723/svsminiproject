package svsminiproject;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MarkingGraphGenerator {

    public static Set<Marking> generateMarkingGraph(Petrinet petriNet) {
        Set<Marking> markingGraph = new HashSet<>();
        Queue<Marking> queue = new LinkedList<>();

        // Create the initial marking
        Marking initialMarking = new Marking();
        for (Place place : petriNet.places) {
            initialMarking.setTokens(place, place.tokens);
        }

        queue.add(initialMarking);
        markingGraph.add(initialMarking);

        while (!queue.isEmpty()) {
            Marking currentMarking = queue.poll();

            for (Transition transition : petriNet.transitions) {
                if (currentMarking.isEnabled(transition)) {
                    Marking newMarking = currentMarking.fire(transition);

                    if (!markingGraph.contains(newMarking)) {
                        markingGraph.add(newMarking);
                        queue.add(newMarking);
                    }
                }
            }
        }

        return markingGraph;
    }

    public static String generateNuSMVCode(Petrinet petriNet, Set<Marking> markingGraph) {
        StringBuilder sb = new StringBuilder();

        // MODULE main
        sb.append("MODULE main\n\n");

        // VARIABLES
        sb.append("VAR\n");
        for (Place place : petriNet.places) {
            sb.append("  ").append(place.name).append(" : 0..").append(markingGraph.size()).append(";\n");
        }
        sb.append("\n");

        // ASSIGN
        sb.append("ASSIGN\n");
        for (Place place : petriNet.places) {
            sb.append("  init(").append(place.name).append(") := ").append(place.tokens).append(";\n");
        }
        sb.append("\n");

        // TRANSITIONS
        for (Transition transition : petriNet.transitions) {
            sb.append("  next(").append(transition.name).append(") := case\n");

            for (Marking marking : markingGraph) {
                if (marking.isEnabled(transition)) {
                    Marking newMarking = marking.fire(transition);

                    sb.append("    ");
                    for (Place place : petriNet.places) {
                        sb.append(place.name).append(" = ").append(marking.getTokens(place)).append(" & ");
                    }
                    sb.setLength(sb.length() - 3); // Remove the last " & "
                    sb.append(" : ");

                    boolean first = true;
                    for (Place place : petriNet.places) {
                        if (first) {
                            first = false;
                        } else {
                            sb.append(", ");
                        }
                        sb.append(newMarking.getTokens(place));
                    }
                    sb.append(";\n");
                }
            }

            sb.append("    TRUE : ");
            for (Place place : petriNet.places) {
                sb.append(place.name).append(", ");
            }
            sb.setLength(sb.length() - 2); // Remove the last ", "
            sb.append(";\n");
            sb.append("  esac;\n\n");
        }

        return sb.toString();
    }

}