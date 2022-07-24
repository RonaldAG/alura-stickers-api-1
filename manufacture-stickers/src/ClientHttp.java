import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClientHttp {

    private URI address;
    private HttpClient client;
    private HttpRequest request;
    private HttpResponse<String> response;

    private void makeConnection(String url){
        address = URI.create(url);
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder(address).GET().build();
    }

    public String requestInformation(String url){
        try{
           makeConnection(url);
            response = client.send(request, BodyHandlers.ofString());
            String body = response.body();
            return body;
        }
        catch(IOException | InterruptedException e ){
            throw new RuntimeException(e);
        }
    }
    
}
