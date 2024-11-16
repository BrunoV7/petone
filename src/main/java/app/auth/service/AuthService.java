package app.auth.service;
import app.auth.models.AuxToken;
import app.auth.models.Login;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.MediaType;
import okhttp3.Response;
import org.keycloak.Token;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthService {

    public String login(Login login) {
        OkHttpClient client = new OkHttpClient.Builder().build();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        String formattedBody = String.format(
                "grant_type=password&client_id=petone&client_secret=YU1ySSxRqKYyK1ni1yraZogW3UfglG4I&username=%s&password=%s",
                login.getUsername(),
                login.getPassword()
        );
        RequestBody body = RequestBody.create(mediaType, formattedBody);
        Request request = new Request.Builder()
                .url("http://192.168.56.19:8080/realms/petone/protocol/openid-connect/token")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string(); // Lê o corpo apenas uma vez
                System.out.println("Response: " + responseBody);
                return responseBody;
            } else {
                String errorMessage = response.message();
                System.out.println("Request failed: " + errorMessage);
                return errorMessage;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    public AuxToken Test(){
        AuxToken token = new AuxToken();
        token.setToken("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJNYm54N1IyMUdYUEFnN0NxbjVvUktnQ3RuamRqVGM5QlpQZFdhVW5LLXM4In0.eyJleHAiOjE3MzE3MDkzMzgsImlhdCI6MTczMTcwOTAzOCwianRpIjoiNDJiNDViMjAtNDRiZC00ZDUyLWI3YWUtOGMyZDBjMDM3OTg2IiwiaXNzIjoiaHR0cDovLzE5Mi4xNjguNTYuMTk6ODA4MC9yZWFsbXMvcGV0b25lIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjMxZmE3YjgyLTdiZjctNDAzZS1hYWJjLWEwN2Y1NzE3YTE4MCIsInR5cCI6IkJlYXJlciIsImF6cCI6InBldG9uZSIsInNpZCI6ImYzYjA4MDU3LWExODctNGI5Mi1hYWM3LTY4ZGZiNDg3NjM4MCIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cHM6Ly93d3cucGV0b25lLmNvbS8iLCJodHRwOi8vbG9jYWxob3N0OjQyMDAvIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLXBldG9uZSIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6InByb2ZpbGUgZW1haWwiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwibmFtZSI6IkJydW5vIFZpZWlyYSBOb2JyZSIsInByZWZlcnJlZF91c2VybmFtZSI6ImJhY2t1cG5vYnJlNjJAZ21haWwuY29tIiwiZ2l2ZW5fbmFtZSI6IkJydW5vIiwiZmFtaWx5X25hbWUiOiJWaWVpcmEgTm9icmUiLCJlbWFpbCI6ImJhY2t1cG5vYnJlNjJAZ21haWwuY29tIn0.QS-YuAvS2ayFggROWUrB4SRTIYqYWDTLb_UY9jfgeYhLoparPzKrbjINZ2zycvqQIiyZ7bUcz33RTBa1wjqJS35HrlqftJFWPVgIyotDOUrAYrn9r4AD8g7Sclqa5PqmcC-8yYtUYaI845xvreoeAEIAyFm2XhuQtEDp8jlCBFKv2ojk6TjGx9y4dQZGyWBSd6GZTDKfoimHzSMUthFProycKg6CyF9YazeoW8pGhNVsXxIzmz9LLOxLyvWyblBG6OXiO7yZc5Bm2uQkTtC2-bugFBChIiXgQYdGcj1pDPiJlFjAXDofdOSxpTRSfDOZkTDx8iA49T-uM6s6jKOvIg");
        return token;
    }
}