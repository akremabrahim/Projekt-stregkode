package sdk;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by akrem_95 on 24/11/2016.
 */
public class HTTPrequests {

    static Client client = Client.create();

    public static ClientResponse get(String path) { //????
        ClientResponse clientResponse = null;
        try{
            WebResource webResource = client.resource("http://localhost:8080/server2_0_war_exploded/").path(path);
            clientResponse = webResource.accept("application/json").get(ClientResponse.class);
        }
        catch {

        }
    }

}
