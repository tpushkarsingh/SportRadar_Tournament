package worldCup.impl;

import constants.EventTypes;
import dto.Event;
import dto.Game;
import dto.ScoreBoardResponse;
import dto.Tournament;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.DataFeedUtil;
import util.SortUtil;
import worldCup.PlayGame;

import java.util.*;

public class PlayFootBall implements PlayGame {
    Logger logger = LoggerFactory.getLogger(PlayFootBall.class);

    Map<Integer,ScoreBoardResponse> responseMap = new LinkedHashMap<>();
    DataFeedUtil util = new DataFeedUtil();
    @Override
    public Map<Integer,ScoreBoardResponse> beginGame(Integer feedSource) {
        Tournament t = util.fetchTournamentFeed(feedSource);
        try {
            t.getGame().stream()
                    .filter(s -> {
                        List<Event> event = s.getCurrentEvent();
                        event.stream()
                                .filter(s1 -> s1.getEventType().equalsIgnoreCase(String.valueOf(EventTypes.GOAL)));
                        return true;
                    })
                    .filter(s2 -> s2.getGameEnded())
                    .forEach(s3 -> fetchScoreBoardResponse(s3));
            (new SortUtil()).sortScoreBoard(responseMap);
        }
        catch (Exception e){
            logger.error("Exception occurred while parsing game data");
        }
        return responseMap;
    }

    public Integer getUniqueHashCodeForTeam(String homeTeamName, String awayTeamName) {
        return new StringBuilder(homeTeamName.trim().toLowerCase(Locale.ROOT)).append(awayTeamName.trim().toLowerCase(Locale.ROOT)).hashCode();
    }

    public void fetchScoreBoardResponse(Game game){
        String homeTeamName = game.getHomeTeam().getTeamName();
        String awayTeamName = game.getAwayTeam().getTeamName();
        Integer homeTeamScore = game.getHomeTeam().getTeamScore();
        Integer awayTeamScore = game.getAwayTeam().getTeamScore();
        Integer teamHash = getUniqueHashCodeForTeam(homeTeamName,awayTeamName);
        ScoreBoardResponse response = responseMap.get(teamHash);
        if(response !=null ){
            response.setAwayTeamScore(response.getAwayTeamScore()+awayTeamScore);
            response.setHomeTeamScore(response.getHomeTeamScore()+homeTeamScore);
        }
        else {
            response = new ScoreBoardResponse();
            response.setHomeTeamName(homeTeamName);
            response.setHomeTeamScore(homeTeamScore);
            response.setAwayTeamName(awayTeamName);
            response.setAwayTeamScore(awayTeamScore);

        }
        responseMap.put(teamHash,response);

    }


    public static void main(String[] args) {
        PlayGame play = new PlayFootBall();
        play.beginGame(1);
    }
}
