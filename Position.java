import java.util.Comparator;
public class Position {
    private int x;
    private int y;


    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "("+this.x+", "+this.y+")";
    }
}
class XComp implements Comparator<Position>{

    @Override
    public int compare(Position o1, Position o2) {
        return Integer.compare(o1.getX(),o2.getX());
    }
}
class YComp implements Comparator<Position>{

    @Override
    public int compare(Position o1, Position o2) {
        return Integer.compare(o1.getY(),o2.getY());
    }
}
