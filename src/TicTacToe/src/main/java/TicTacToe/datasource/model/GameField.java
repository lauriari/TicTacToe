package TicTacToe.datasource.model;

public class GameField {
    private int[] data;
    public GameField() {
        data = new int[9];
        for (int i : data){
            i = 0;
        }
    }

    public int getData(int n) {
        return data[n];
    }

    public void setData(int n, int d) {
        this.data[n] = d;
    }
}
