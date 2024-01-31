import java.util.ArrayList;

public class ConcretePlayer implements Player {

    private boolean isPlayerOne;
    private int wins=0;

    public ConcretePlayer(boolean bool){
        this.isPlayerOne=bool;
    }

    @Override
    public boolean isPlayerOne() {
        return isPlayerOne;
    }

    @Override
    public int getWins() {
        return this.wins;
    }


    public boolean playerWin(){
        this.wins++;
        return true;
    }
    public boolean incWin(){
        this.wins =+1;
        return true;
    }

}
