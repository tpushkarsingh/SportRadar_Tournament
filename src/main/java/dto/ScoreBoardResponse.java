package dto;

public class ScoreBoardResponse implements Comparable{
    private String homeTeamName;
    private String awayTeamName;
    private Integer homeTeamScore;
    private Integer awayTeamScore;
    private Integer totalMatchCount;

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(Integer homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public Integer getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(Integer awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public Integer getTotalMatchCount() {
        return totalMatchCount;
    }

    public void setTotalMatchCount(Integer totalMatchCount) {
        this.totalMatchCount = totalMatchCount;
    }

    @Override
    public String toString() {
        return "\n" + homeTeamName +
                " " + homeTeamScore +
                "- " + awayTeamName +
                " " + awayTeamScore;
    }

    @Override
    public int compareTo(Object o) {
        ScoreBoardResponse s = (ScoreBoardResponse)o;
        if(this.totalMatchCount == s.getTotalMatchCount())
            return 0;
        else if(this.totalMatchCount<s.totalMatchCount)
            return 1;
        else
            return -1;
    }
}
