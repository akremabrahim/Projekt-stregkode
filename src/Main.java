import controller.Controller;
import sdk.Config;

/**
 * Created by akrem_95 on 24/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        Config.initConfig();
        new Controller().menu();
    }
}
