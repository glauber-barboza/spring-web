package digitalinnovation.example.app.dto;

public class ResultBotTelegram {
    private boolean ok;
    private ResponseMessage result;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public ResponseMessage getResult() {
        return result;
    }

    public void setResult(ResponseMessage result) {
        this.result = result;
    }
}
