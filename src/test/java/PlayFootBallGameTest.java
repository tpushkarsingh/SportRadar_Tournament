import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ScoreBoardResponse;
import dto.Tournament;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import util.DataFeedUtil;
import worldCup.impl.PlayFootBall;
import static org.mockito.Mockito.*;
import java.util.Map;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class PlayFootBallGameTest {

    @InjectMocks
    private PlayFootBall footBall  = new PlayFootBall();
    @Mock
    private DataFeedUtil util = new DataFeedUtil();


    @Test
    public void checkGameOffsideEventResponse() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Tournament tournament = mapper.readValue(TestConstants.SCORE_OFFSIDE_RESPONSE,new TypeReference<Tournament>(){});
        when(util.fetchTournamentFeed(any(Integer.class))).thenReturn(tournament);
        Assert.assertEquals(footBall.beginGame(1).size(),0);
    }

    @Test
    public void checkGameWithGoalsEventAndEndedResponse() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Tournament tournament = mapper.readValue(TestConstants.SCORE_VALID_GOAL_AND_ENDED_RESPONSE,new TypeReference<Tournament>(){});
        when(util.fetchTournamentFeed(any(Integer.class))).thenReturn(tournament);
        Map<Integer, ScoreBoardResponse> data = footBall.beginGame(1);
        Assert.assertEquals(data.size(),1);
        ScoreBoardResponse response = data.values().stream().findFirst().get();

        Assert.assertEquals(java.util.Optional.ofNullable(response.getTotalMatchCount()), Optional.of(2));
    }
    @Test
    public void checkGameCornerEventResponse() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Tournament tournament = mapper.readValue(TestConstants.SCORE_OFFSIDE_RESPONSE,new TypeReference<Tournament>(){});
        when(util.fetchTournamentFeed(any(Integer.class))).thenReturn(tournament);
        Assert.assertEquals(footBall.beginGame(1).size(),0);
    }
}
