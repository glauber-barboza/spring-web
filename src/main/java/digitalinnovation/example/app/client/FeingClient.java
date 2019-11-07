package digitalinnovation.example.app.client;

import digitalinnovation.example.app.dto.MessageSend;
import digitalinnovation.example.app.dto.ResultBotTelegram;
import digitalinnovation.example.app.dto.ResultBotTelegramList;
import feign.Headers;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(url = "${telegram.api}${telegram.token}", name = "telegram")
public interface FeingClient {

    @GetMapping("/getUpdates")
    ResponseEntity<ResultBotTelegramList> buscaratualizacao();

    @Headers("MEU_HEADER: {meu_header}")
    @GetMapping("/getUpdates")
    ResponseEntity<ResultBotTelegramList> buscaratualizacao1(@Param("meu_header") String header);

    //retorno com Response Entity
    @PostMapping("/sendMessage")
    ResponseEntity<ResultBotTelegram> enviarMensagem(@RequestBody MessageSend msg);

    //retorno response Object
    @PostMapping("/sendMessage")
    @ResponseBody
    ResultBotTelegram enviarMensagem1(@RequestBody MessageSend msg);

    //set header RequestHeader
    @PostMapping(value = "/sendMessage")
    ResultBotTelegram enviarMensagem3(@RequestBody MessageSend msg, @RequestHeader("MEU_HEADER") String header);

    //RequestMapping informando o tipo de metodo
    @RequestMapping(method = RequestMethod.POST, value = "/sendMessage")
    ResultBotTelegram enviarMensagem5(@RequestBody MessageSend msg);

    //Exemplo de path variable
    @GetMapping("/getUpdates/{meuTeste}")
    ResultBotTelegram examplePathVariable(@PathVariable("meuTeste") String meuTeste);

    //Exemplo de request param
    //www.minhaUrl.com.br/getUpdates?nome=nomeInformado
    @GetMapping("/getUpdates")
    ResultBotTelegram exampleRequestParam(@RequestParam("nome") String nome);

}
