package com.validation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;

@Test
public class APITeamRCB {

    /**
    this method fetches JSON file stored
     **/
    public JSONObject fetchJsonFile() throws IOException, ParseException {
        JSONObject jsonObject= null;
        try{
            jsonObject= (JSONObject) new JSONParser().parse(new FileReader("src/main/resources/Royal Challengers Bangalore.json"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * this method sorts all the players country and validates the Foreign players count
     * @throws IOException
     * @throws ParseException
     */
    public void validateForeignPlayers() throws IOException, ParseException {
            JSONObject obj=fetchJsonFile();
            JSONArray players = (JSONArray) obj.get("player");
            int ForeignCount=0;
            int RoleCount=0;
            for(int i=0;i<players.size();i++){
                JSONObject player= (JSONObject) players.get(i);
                if(!player.get("country").toString().equalsIgnoreCase("India")) {
                    ForeignCount++;
                }
            }
            Assert.assertEquals(ForeignCount,4,"There are 4 foreign players");
            Reporter.log("There are 4 foreign players",true);

    }
    /**
     * this method sorts all the players role and validates the Wicket Keeper count
     * @throws IOException
     * @throws ParseException
     */
    public void validateWicketKeeper() throws IOException, ParseException {
            JSONObject obj=fetchJsonFile();
            JSONArray players = (JSONArray) obj.get("player");
            int ForeignCount=0;
            int RoleCount=0;
            for(int i=0;i<players.size();i++){
                JSONObject player= (JSONObject) players.get(i);
                if(player.get("role").toString().equalsIgnoreCase("Wicket-keeper")){
                    RoleCount++;
                }
            }
            Assert.assertTrue(RoleCount>=1,"There is atleast 1 wicket keeper");
            Reporter.log("There is atleast 1 wicket keeper",true);
    }
}
