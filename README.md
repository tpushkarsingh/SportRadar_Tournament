# SportRadar_Tournament
Steps to run the project:
1. git clone and checkout the project from master branch
2. perform maven clean install (mvn clean install).
3. A dummy data set of football data feed is placed under resources.
4. Navigate to PlayFootBall.java and execute the main method.

Assumptions:
1. A live data feed is imitated in resources/dummy_match_data.json
2. The feed send Event and Teams Data.
3. Events are classified specific to a game ,for football (GOAL, OUTSIDE, CORNER) etc.  All assumed values can be found under ENUM (EventTypes).
4. For this problem statement only GOAL Event Type is considered for computation. Hence, the sorting is based on
   </br>a) No. of goals secured in a Game.
   </br>b) The latest Goal Event received by the team. In case of matching goal counts, match having the latest goal secured will be placed above.
5. The lastest feed for goals as per Json is:
![img.png](img.png)
   
6. Based on the sorting as mentioned in step4. output should be 
![img_1.png](img_1.png)
   
