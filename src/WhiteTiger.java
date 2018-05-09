import java.awt.*;

public class WhiteTiger extends Critter {
    public Color CurrentColor;
    private boolean HasInfected; //true if has infected another
    private static String str1 = "tgr";
    private static String str2 = "TGR";
    private static Color col = Color.WHITE;




    public WhiteTiger() {
        //constructor, makes a WhiteTiger
        super();
        this.HasInfected = false;
    }

    public Color getColor() {
        return col;
    }

    public String toString(){
        // returns "tgr" unless this WhiteTiger has infected, then returns "TGR"
        if (HasInfected){
            return str2;
        } else {
            return str1;

        }
    }

    public Action getMove(CritterInfo info){
        // always infect if an enemy is in front, otherwise if a wall is in front or to the right, then turn left,
        // otherwise if a fellow Tiger is in front, then turn right, otherwise hop.
        if (info.frontThreat()){
            this.HasInfected = true;
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
