package util;

import dto.Tournament;

import java.util.ArrayList;
import java.util.List;

public class DataFeedUtil {
    public List<Tournament> fetchTournamentFeed(Integer feedSource) {
        List<Tournament> tournamentList;

        switch (feedSource) {
            case 1:
                tournamentList = fetchDataFromResources();
            default:
                tournamentList = new ArrayList<>();
                return tournamentList;
        }
    }

    private List<Tournament> fetchDataFromResources() {
        return null;
    }
}
