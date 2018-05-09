import java.awt.*;

public class Bear extends Critter {
    // Use to make Bears.
    private boolean polar;
    private int count;

    public Bear(boolean polar) {
        //constructor
        super();
        this.polar = polar;
        count = 0;
    }

    public Color getColor(){
        // returns color of Bear.
        if (polar){
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    public String toString(){
        // alternate between a slash and backslash, starting with a slash
        if (count%2==0){ // need to fix criteria later
            return "/";
        } else {
            return "\\";
        }
    }

    public Action getMove(CritterInfo info){
        // - always infect if an enemy is in front, otherwise hop if possible, otherwise turn left.
        count++;
        if (info.frontThreat()) {
            return Action.INFECT;
        } else if (info.getFront()==Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }

    }







}
