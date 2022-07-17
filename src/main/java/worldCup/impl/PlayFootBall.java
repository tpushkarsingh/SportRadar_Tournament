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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

public class PlayFootBall implements PlayGame {
    Logger logger = LoggerFactory.getLogger(PlayFootBall.class);

    Map<Integer,ScoreBoardResponse> responseMap = new LinkedHashMap<>();
    DataFeedUtil util = new DataFeedUtil();


    @Override
    public Map<Integer,ScoreBoardResponse> beginGame(Integer feedSource) {
        logger.info("Starting the Game of Football !!");
        Tournament t = util.fetchTournamentFeed(feedSource);
        try {

            List<Game> currGame = t.getGame();
            //Logic to filter game feed data having only goal as event.
            //Predicate to check if its not a goal event
            Predicate<Event> isGoalEvent = data -> !data.getEventType().equalsIgnoreCase(EventTypes.GOAL.name());
            //Predicate for Game to look for goal events.
            Predicate<Game> isGoalHitInGame= data -> {
              data.getCurrentEvent().removeIf(isGoalEvent);
              return data.getCurrentEvent().isEmpty();
            };
            //remove all non goal events
            currGame.removeIf(isGoalHitInGame);
            currGame.forEach(s-> fetchScoreBoardResponse(s));
            //sort based on number of goals secured+ match which has the latest goal secured
            (new SortUtil()).sortScoreBoard(responseMap);
        }
        catch (Exception e){
            logger.error("Exception occurred while parsing game data");
        }
        return responseMap;
    }

    public Integer getUniqueHashCodeForTeam(String homeTeamName, String awayTeamName) {
        return (homeTeamName.trim().toLowerCase(Locale.ROOT)+awayTeamName.trim().toLowerCase(Locale.ROOT)).hashCode();
    }

    public void fetchScoreBoardResponse(Game game){
        String homeTeamName = game.getHomeTeam().getTeamName();
        String awayTeamName = game.getAwayTeam().getTeamName();
        Integer homeTeamScore = game.getHomeTeam().getTeamScore();
        Integer awayTeamScore = game.getAwayTeam().getTeamScore();
        //Hash using team names which is unique for a match used a key for map
        Integer teamHash = getUniqueHashCodeForTeam(homeTeamName,awayTeamName);
        ScoreBoardResponse response = responseMap.get(teamHash);
        //remove the last entry and do entry again in map to keep the latest record sequence updated.
        responseMap.remove(teamHash);
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
