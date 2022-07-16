package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Tournament;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class DataFeedUtil {
    Logger logger = LoggerFactory.getLogger(DataFeedUtil.class);


    public Tournament fetchTournamentFeed(Integer feedSource) {
        switch (feedSource) {
            case 1:
                return fetchDataFromResources();
            default:
                return null;
        }
    }

    private Tournament fetchDataFromResources() {
        logger.info("Inside fetchDataFromResources starting parsing");
        Tournament tournament = null;
        try(InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("dummy_match_data.json")){
            ObjectMapper mapper = new ObjectMapper();
            tournament = mapper.readValue(in,new TypeReference<Tournament>(){});
        }
        catch (Exception e) {
            logger.error("Error parsing Data inside fetchDataFromResources");
        }
        return tournament;
    }

}
