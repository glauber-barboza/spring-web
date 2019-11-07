package digitalinnovation.example.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetUpdates {
    @JsonProperty("update_id")
    private Long updateId;
    private Message message;

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
