package digitalinnovation.example.app.client;

import digitalinnovation.example.app.dto.MessageSend;
import digitalinnovation.example.app.dto.ResultBotTelegram;
import digitalinnovation.example.app.dto.ResultBotTelegramList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class RestTemplateClient {
    @Value("${telegram.api}")
    private String BASE_PATH;
    @Value("${telegram.token}")
    private String TOKEN;

    private RestTemplate restTemplate;

    public RestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void enviarMensagem(MessageSend msg) {
        //postForLocation retornando a uri, Pega informação do header
        URI uri = restTemplate.postForLocation(BASE_PATH + TOKEN + "/sendMessage", msg);

        //postForLocation retornando o objeto que eu definir de retorno
        ResultBotTelegram retorno = restTemplate.postForObject(BASE_PATH + TOKEN + "/sendMessage",
                msg, ResultBotTelegram.class);

        //postForLocation retornando o objeto que eu definir de retorno com dados da requisição, Headers,HTTP status...
        ResponseEntity<ResultBotTelegram> retorno2 = restTemplate.postForEntity(BASE_PATH + TOKEN + "/sendMessage",
                msg, ResultBotTelegram.class);

        //postForLocation retornando o objeto que eu definir de retorno com dados da requisição, Headers,HTTP status...
        //Enviando Headers
        HttpHeaders headers = headers();
        HttpEntity<MessageSend> request = new HttpEntity<>(msg, headers);
        ResponseEntity<ResultBotTelegram> retorno3 = restTemplate.postForEntity(BASE_PATH + TOKEN + "/sendMessage",
                request, ResultBotTelegram.class);

        //exchange
        HttpHeaders headers1 = headers();
        HttpEntity<MessageSend> request1 = new HttpEntity<>(msg, headers);
        ResponseEntity<ResultBotTelegram> retorno4 = restTemplate.exchange(BASE_PATH + TOKEN + "/sendMessage",
                HttpMethod.POST, request1, ResultBotTelegram.class);

    }

    public ResultBotTelegramList buscarAtualizacao() {
        ResultBotTelegramList forObject = restTemplate.getForObject(BASE_PATH + TOKEN + "/getUpdates", ResultBotTelegramList.class);
        return forObject;
    }

    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("MEU_HEADER","MEU_VALOR");
        return headers;
    }
}
