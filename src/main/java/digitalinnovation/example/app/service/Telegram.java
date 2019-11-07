package digitalinnovation.example.app.service;

import digitalinnovation.example.app.client.FeingClient;
import digitalinnovation.example.app.client.JavaHttpClient;
import digitalinnovation.example.app.client.RestTemplateClient;
import digitalinnovation.example.app.dto.MessageSend;
import digitalinnovation.example.app.dto.ResultBotTelegram;
import digitalinnovation.example.app.dto.ResultBotTelegramList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Telegram {
    private RestTemplateClient restTemplateClient;
    private FeingClient feingClient;
    private JavaHttpClient javaHttpClient;

    public Telegram(RestTemplateClient restTemplateClient, FeingClient feingClient, JavaHttpClient javaHttpClient) {
        this.restTemplateClient = restTemplateClient;
        this.feingClient = feingClient;
        this.javaHttpClient = javaHttpClient;
    }

    public void enviarMensagem(MessageSend mensagem) {
        //FeingClient
        ResultBotTelegram resultBotTelegramResponseEntity = feingClient.enviarMensagem1(mensagem);
        ResultBotTelegram resultBotTelegram = feingClient.enviarMensagem1(mensagem);
    }

    public ResultBotTelegramList buscarAtualizacao() {
        //FeingClient
        ResponseEntity<ResultBotTelegramList> resultBotTelegramList = feingClient.buscaratualizacao();
        return resultBotTelegramList.getBody();
    }
}
