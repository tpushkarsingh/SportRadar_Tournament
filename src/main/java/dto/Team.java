package dto;

public class Team {
    public String teamName;
    public Integer teamScore;

    public Team(String teamName, Integer teamScore) {
        this.teamName = teamName;
        this.teamScore = 0;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(Integer teamScore) {
        this.teamScore = teamScore;
    }
}
