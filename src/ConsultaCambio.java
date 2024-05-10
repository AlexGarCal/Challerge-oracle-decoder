import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCambio {
    public Cambio buscaCambio(String basa, String target){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/6ec35fbf1a3c7fd383d67861/pair/"+basa+"/"+target );

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Cambio.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa película.");
        }

    }
}
