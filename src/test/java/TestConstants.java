public class TestConstants {
    public static final String SCORE_RESPONSE = "{\"game\": [\n" +
            "  {\n" +
            "    \"date\": \"21 Nov 12:45\",\n" +
            "    \"homeTeam\": {\n" +
            "      \"teamName\": \"Germany\",\n" +
            "      \"teamScore\": \"0\"\n" +
            "    },\n" +
            "    \"awayTeam\": {\n" +
            "      \"teamName\": \"France\",\n" +
            "      \"teamScore\": \"0\"\n" +
            "    },\n" +
            "    \"currentEvent\": [\n" +
            "      {\n" +
            "        \"eventType\": \"goal\",\n" +
            "        \"fromTeam\": \"home\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"gameEnded\": false\n" +
            "  }]}";
    public static final String SCORE_OFFSIDE_RESPONSE = "{\"game\": [\n" +
            "  {\n" +
            "    \"date\": \"21 Nov 12:45\",\n" +
            "    \"homeTeam\": {\n" +
            "      \"teamName\": \"Germany\",\n" +
            "      \"teamScore\": \"0\"\n" +
            "    },\n" +
            "    \"awayTeam\": {\n" +
            "      \"teamName\": \"France\",\n" +
            "      \"teamScore\": \"0\"\n" +
            "    },\n" +
            "    \"currentEvent\": [\n" +
            "      {\n" +
            "        \"eventType\": \"outside\",\n" +
            "        \"fromTeam\": \"home\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"gameEnded\": false\n" +
            "  }]}";
    public static final String SCORE_VALID_GOAL_AND_ENDED_RESPONSE = "{\"game\": [\n" +
            "  {\n" +
            "    \"date\": \"21 Nov 12:45\",\n" +
            "    \"homeTeam\": {\n" +
            "      \"teamName\": \"Germany\",\n" +
            "      \"teamScore\": \"1\"\n" +
            "    },\n" +
            "    \"awayTeam\": {\n" +
            "      \"teamName\": \"France\",\n" +
            "      \"teamScore\": \"1\"\n" +
            "    },\n" +
            "    \"currentEvent\": [\n" +
            "      {\n" +
            "        \"eventType\": \"goal\",\n" +
            "        \"fromTeam\": \"home\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"gameEnded\": false\n" +
            "  }," +
            "  {\n" +
            "    \"date\": \"21 Nov 12:45\",\n" +
            "    \"homeTeam\": {\n" +
            "      \"teamName\": \"Germany\",\n" +
            "      \"teamScore\": \"1\"\n" +
            "    },\n" +
            "    \"awayTeam\": {\n" +
            "      \"teamName\": \"France\",\n" +
            "      \"teamScore\": \"1\"\n" +
            "    },\n" +
            "    \"currentEvent\": [\n" +
            "      {\n" +
            "        \"eventType\": \"goal\",\n" +
            "        \"fromTeam\": \"home\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"gameEnded\": true\n" +
            "  }"+
            "]}";
}
