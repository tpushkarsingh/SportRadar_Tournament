package constants;

public enum EventTypes {
    OUTSIDE("outside"),CORNER("corner"),GOAL("goal"),FREEKICK("FreeKick"),OFFSIDE("Offside"),SUBSTITUTION("Substitution")
    ,HAND_BALL("Hand ball"),EXTRA_TIME("Extra Time");

    private final String eventName;

    EventTypes(final String eventName) {
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return "EventTypes{" +
                "eventName='" + eventName + '\'' +
                '}';
    }
}
