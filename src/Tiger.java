import java.awt.*;

public class Tiger extends Critter {
    // Makes a Tiger
    private int count;
    private static Color[] Col = {Color.RED,Color.GREEN,Color.BLUE};
    private int CurrentColorIndex;


    public Tiger() {
        //constructor
        super();
        count = 0;
    }

    public Color getColor() {
        // Changes color returned every 3 moves, randomly picks red, green, or blue
        if (count % 3 == 0) {
            double num = Math.random()*3;
            if (num<1){
                CurrentColorIndex=0;
            } else if (num<2) {
                CurrentColorIndex=1;
            } else {
                CurrentColorIndex=2;
            }
        }
        return Col[CurrentColorIndex];
    }

    public String toString(){
        return "TGR";
    }

    public Action getMove(CritterInfo info){
        // always infect if an enemy is in front, otherwise if a wall is in front or to the right, then turn left,
        // otherwise if a fellow Tiger is in front, then turn right, otherwise hop.
        count++;
        if (info.frontThreat()){
            return Action.INFECT;
        } else if (info.getFront()==Neighbor.WALL||info.getRight()==Neighbor.WALL){
            return Action.LEFT;
        } else if (info.getFront()==Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }

    }
}
