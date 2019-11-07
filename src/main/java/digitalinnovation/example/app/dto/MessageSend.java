package digitalinnovation.example.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageSend {
    @JsonProperty("chat_id")
    private String chatId;
    private String text;

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
