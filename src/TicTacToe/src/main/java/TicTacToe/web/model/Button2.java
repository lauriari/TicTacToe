package TicTacToe.web.model;

public class Button2 {
    private String text;
    private boolean enabled;

    public Button2(String text, boolean f) {
        this.text = text;
        this.enabled = f;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public void setEnabled(boolean f){
        this.enabled = f;
    }
    public boolean isEnabled() {
        return enabled;
    }
}
