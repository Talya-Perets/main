import java.util.ArrayList;
import java.util.Comparator;
public abstract class ConcretePiece implements Piece{
    private String type;
    private ConcretePlayer owner;
    private Position position;
    private String id;

    //Saves every position that pice through every game
    private ArrayList<Position> positions=new ArrayList<Position>();

    //A reserved variable for calculating the distance each piece has traveled
    private int distance =0;

    //constructor
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
    //Adds a position to the ArryList if it's empty then only inserts if it's not empty then completes and sends to the function that calculates the distance
    public void addPos(Position position){
        if(positions.size()==0){this.positions.add(position);}
      else {
          Position lastPos = positions.get(positions.size() - 1);
          checkDistance(lastPos,position);
            this.positions.add(position);
        }

    }
    public ArrayList<Position> getPositions(){
        return this.positions;
    }
   
    
    //The function receives a String which is the id and outputs only the number. It will be useful in comparisons
    public int getIdNum(){
        String onlyNum = this.id.replaceAll("[^0-9]","");
        return Integer.parseInt(onlyNum);
    }

//The function receives two positions, calculates the distance and adds the distance to the already accumulated distance    
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





