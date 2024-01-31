import java.util.ArrayList;
import java.util.Comparator;
public abstract class ConcretePiece implements Piece{
    private String type;
    private ConcretePlayer owner;
    private Position position;
    private String id;
    private ArrayList<Position> positions=new ArrayList<Position>();
    private int distance =0;

    public ConcretePiece(String type , ConcretePlayer owner , Position position,String id){
        this.type=type;
        this.owner =owner;
        this.position=position;
        this.id=id;
        addPos(position);

    }
    @Override
    public Player getOwner() {return this.owner;}
    @Override
    public String getType() {return this.type;}
    public String getId() {
        return id;
    }
    public void addPos(Position position){
        if(positions.size()==0){this.positions.add(position);}
      else {
           Position lastPos = positions.getLast();
           checkDistance(lastPos,position);
            this.positions.add(position);
        }

    }
    public ArrayList<Position> getPositions(){
        return this.positions;
    }
    public int getIdNum(){
        String onlyNum = this.id.replaceAll("[^0-9]","");
        return Integer.parseInt(onlyNum);
    }

    public void checkDistance(Position lastPos , Position newPos)
    {
        if(lastPos.getX()==newPos.getX()){
            distance +=Math.abs(lastPos.getY()-newPos.getY());
        }
        else {
            distance +=Math.abs(lastPos.getX()-newPos.getX());
        }

    }
    public int getDistance(){
        return this.distance;
    }
    abstract void addKill();
    abstract int getKills();



}
 class StepsAmountComp implements Comparator<ConcretePiece>{
    @Override
    public int compare(ConcretePiece o1, ConcretePiece o2) {
        return Integer.compare(o1.getPositions().size(),o2.getPositions().size());
    }
}
class IdComp implements Comparator<ConcretePiece>{

    @Override
    public int compare(ConcretePiece o1, ConcretePiece o2) {
        return Integer.compare(o1.getIdNum(), o2.getIdNum());
    }
}
class DistanceCompare implements Comparator<ConcretePiece>{

    @Override
    public int compare(ConcretePiece o1, ConcretePiece o2) {
        return Integer.compare(o2.getDistance(), o1.getDistance());
    }
}





