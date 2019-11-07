package digitalinnovation.example.app.dto;

import java.util.List;

public class ResultBotTelegramList {
    private boolean ok;
    private List<GetUpdates> result;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<GetUpdates> getResult() {
        return result;
    }

    public void setResult(List<GetUpdates> result) {
        this.result = result;
    }
}
