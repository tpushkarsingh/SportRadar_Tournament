import dto.Tournament;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import util.DataFeedUtil;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DataFeedUtilTest {
    @InjectMocks
    DataFeedUtil dataFeedUtil = new DataFeedUtil();

    @Test
    public void fetchTournamentFeedForSource1() {
        List<Tournament> tournamentList = dataFeedUtil.fetchTournamentFeed(1);
        Assert.assertEquals(tournamentList.size()>0,true);
    }

}
