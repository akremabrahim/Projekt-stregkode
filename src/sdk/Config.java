package sdk;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;

/**
 * Created by akrem_95 on 24/11/2016.
 */
public class Config {

    private static String serverUrl;

    private static JsonObject initConfig(){
        JsonObject json = new JsonObject();

        try {
        JsonParser parserJ = new JsonParser();
        json = (JsonObject) parserJ.parse(new FileReader("src/sdk/config.json"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    public static String getServerUrl() {return serverUrl;}
    public static void setServerUrl(String serverUrl) {Config.serverUrl = serverUrl;}


}
