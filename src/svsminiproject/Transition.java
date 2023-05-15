package svsminiproject;

import java.util.ArrayList;
import java.util.List;

public class Transition {
	private int id;
    private String name;
    private List<Arc> incomingArcs;
    private List<Arc> outgoingArcs;

    public Transition(int id, String name) {
        this.id = id;
        this.name = name;
        incomingArcs = new ArrayList<>();
        outgoingArcs = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Arc> getIncomingArcs() {
        return incomingArcs;
    }

    public List<Arc> getOutgoingArcs() {
        return outgoingArcs;
    }

    public void addIncomingArc(Arc arc) {
        incomingArcs.add(arc);
    }

    public void addOutgoingArc(Arc arc) {
        outgoingArcs.add(arc);
    }
}
