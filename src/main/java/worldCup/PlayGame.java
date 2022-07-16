package worldCup;

import dto.ScoreBoardResponse;
import java.util.Map;

public interface PlayGame {

    public Map<Integer, ScoreBoardResponse> beginGame(Integer feedSource);


}
