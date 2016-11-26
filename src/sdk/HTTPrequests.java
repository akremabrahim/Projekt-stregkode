package sdk;

import com.sun.jersey.api.client.*;

/**
 * Created by akrem_95 on 24/11/2016.
 */
public class HTTPrequests {

    static Client client = Client.create();

    public static ClientResponse get (String path) { //????????? HVAD ER DET HER?????????
        ClientResponse clientResponse = null;
        try{
            WebResource webResource = client
                    .resource("http://localhost:8080/server2_0_war_exploded/")
                    .path(path);
            clientResponse = webResource.accept("application/json").get(ClientResponse.class);
        }
        catch
            (UniformInterfaceException | ClientHandlerException e) {
                e.printStackTrace();
            }
            return clientResponse;
        }

        public static ClientResponse post (String token, String path, String json) {
            ClientResponse clientResponse = null;
            try {
                WebResource webResource = client.resource("http://localhost:8080/server2_0_war_exploded/").path(path);
                clientResponse = webResource.accept("application/json").post(ClientResponse.class, json);

            } catch (UniformInterfaceException | ClientHandlerException e) {
                e.printStackTrace();
            }
            return clientResponse;
        }

    }


