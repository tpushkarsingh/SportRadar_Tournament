package constants;

public enum TeamName {
    MEXICO("Mexico"),CANADA("Canada"),SPAIN("Spain"),BRAZIL("Brazil"),GERMANY("Germany"),FRANCE("France"),
    URUGUAY("Uruguay"),ITALY("Italy"),ARGENTINA("Argentina"),AUSTRALIA("Australia");

    private final String teamName;

    TeamName(final String name) {
        this.teamName =name;
    }

    @Override
    public String toString() {
        return "TeamName{" +
                "teamName='" + teamName + '\'' +
                '}';
    }
}
