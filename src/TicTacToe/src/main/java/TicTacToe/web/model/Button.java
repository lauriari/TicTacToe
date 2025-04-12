package TicTacToe.web.model;

public class Button {
    private String text;
    private boolean enabled;

    public Button() {
    }

    public Button(String text) {
        this.text = text;
        this.enabled = text.equals(" ") ? true : false;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        this.enabled = text.equals(" ") ? true : false;
    }

    public boolean isEnabled() {
        return enabled;
    }

}
