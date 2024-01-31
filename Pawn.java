import java.security.PublicKey;
import java.util.Comparator;

public class Pawn extends ConcretePiece {
private int kills=0;
    public Pawn(String type, ConcretePlayer owner, Position position, String id) {
        super("♟", owner, position, id);

    }

    @Override
    void addKill() {
        kills++;

    }

    @Override
    int getKills() {
        return this.kills;
    }


}
class  KillsCompare implements Comparator<Pawn>{

    @Override
    public int compare(Pawn o1, Pawn o2) {
        return Integer.compare(o2.getKills(),o1.getKills());
    }
}


