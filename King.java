
public class King extends ConcretePiece {

    public King(String type, ConcretePlayer owner, Position position, String id) {
        super("♔", owner, position, id);
    }

    @Override
    void addKill() {

    }

    @Override
    int getKills() {
        return -1;
    }

}