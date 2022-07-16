import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import worldCup.impl.PlayFootBall;

@RunWith(MockitoJUnitRunner.class)
public class PlayFootBallGameTest {

    @InjectMocks
    private PlayFootBall footBall  = new PlayFootBall();
    @Test
    public void checkValidGoalAndIncrement(){
        Assert.assertEquals(footBall.validateGoalAndIncrement(),true);
    }

}
