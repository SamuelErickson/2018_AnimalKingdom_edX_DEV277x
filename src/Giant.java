import java.awt.*;

public class Giant extends Critter {
    private int count;
    private static String[] DisplayNames = {"fee","fie","foo","fum"};
    private static Color col = Color.GRAY;
    private String CurrentDisplayName;
    private int NameIndex;



    public Giant(){
        // constructor
        super();
        this.count = 0;
        NameIndex = 0;
        CurrentDisplayName = DisplayNames[0];
    }

    public Color getColor(){
        return col;
    }

    public String toString(){
        // Switch displayed text every six moves
        if (count%6==0&&count!=0) {
            NameIndex++;
            CurrentDisplayName = DisplayNames[NameIndex%4];
        }
        return CurrentDisplayName;
    }

    public Action getMove(CritterInfo info) {
        // Returns action. Infect if threat to front, hop if front is empty, otherwise turn right.
        count++;
        if (info.frontThreat()) {
            return Action.INFECT;
        } else if (info.getFront()==Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }




}
