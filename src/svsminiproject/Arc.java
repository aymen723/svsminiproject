package svsminiproject;

public class Arc {
	private Place place;
    private Transition transition;
    private int weight;
    private ArcDirection direction;

    public Arc(Place place, Transition transition, int weight, ArcDirection direction) {
        this.place = place;
        this.transition = transition;
        this.weight = weight;
        this.direction = direction;

        if (direction == ArcDirection.IN) {
            transition.addIncomingArc(this);
        } else {
            transition.addOutgoingArc(this);
        }
    }

    public Place getPlace() {
        return place;
    }

    public Transition getTransition() {
        return transition;
    }

    public int getWeight() {
        return weight;
    }

    public ArcDirection getDirection() {
        return direction;
    }
}
