import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Main {
    public static void main(String args[])
    {

        //key
        // HOPz20CTACy6MDAB/3kEtw==nx8NQlyFx9BT0MV3

        URL url = null;
        try {
            url = new URL("https://api.api-ninjas.com/v1/city?name=San Francisco");
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("accept", "application/json");
                //connection.se("X-Api-Key"). "HOPz20CTACy6MDAB/3kEtw==nx8NQlyFx9BT0MV3")
                connection.setRequestMethod("post");
                //connection.setRequestProperty("X-Api-Key", "HOPz20CTACy6MDAB/3kEtw==nx8NQlyFx9BT0MV3");
                InputStream responseStream = connection.getInputStream();
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(responseStream);
                System.out.println(root.path("fact").asText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
