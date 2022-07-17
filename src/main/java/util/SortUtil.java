package util;

import dto.ScoreBoardResponse;

import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class SortUtil {

    public void sortScoreBoard(Map<Integer,ScoreBoardResponse> responseMap){
        //Reverse the linkedHashMap to get the latest inserted record on top
        List<Integer> keyList = new LinkedList<>(responseMap.keySet());
        List<ScoreBoardResponse> responses  = new LinkedList<>();
        responseMap.entrySet().forEach(s->responses.add(s.getValue()));
        Collections.reverse(responses);
        responses.stream().forEach(s->s.setTotalMatchCount(s.getAwayTeamScore()+s.getHomeTeamScore()));
        Collections.sort(responses);
        System.out.println(responses);
    }
}
