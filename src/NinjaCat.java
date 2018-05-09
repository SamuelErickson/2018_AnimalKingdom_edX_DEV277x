import java.awt.*;

public class NinjaCat extends Critter {
    private boolean hiding;
    private boolean attacking;
    private boolean running;
    private int RunningCount; // limits time running away
    private static Color col1 = Color.RED;
    private static Color col2 = Color.BLACK;
    private static String[] DisplayNames = {"","MEOW!","NINJA!"};



    public NinjaCat(){
        // Constructor
        super();
        hiding = true;
        attacking = false;
        running = false;
    }

    public Color getColor() {
        // Turn red when infecting, otherwise black when visible.
        if (attacking) {
            return col1;
        } else {
            return col2;
        }
    }

    public String toString() {
        // Ninja cat stays invisible, displaying no text, until enemy present to attack
        if (hiding){
            return DisplayNames[0];
        } else if (attacking){
            // When attacking, turn to red MEOW!
            return DisplayNames[1];
        } else {
            // After attacking, running away, turn to black NINJA!
            return DisplayNames[2];
        }
    }

    public Action getMove(CritterInfo info){
        if (hiding && info.frontThreat()) {
            // When threat to front, infect, jump out of hiding
            attacking = true;
            hiding = false;
            return Action.INFECT;
        } else if (hiding && !info.frontThreat()) {
            // no threat ahead? Just spin in place.
            return Action.LEFT;
        } else if (attacking) {
            // just did an infect action? Time to run. Turn in random direction.
            attacking = false;
            running = true;
            if (Math.random()<0.5){
                return Action.LEFT;
            } else {
                return Action.RIGHT;
            }
        } else if (running && RunningCount < 7) {
            // After infect, turning, time to run away. Hop if possible or turn in random direction.
            // Continue until 7 hops completed
            if (info.getFront()==Neighbor.EMPTY) {
                RunningCount++;
                return Action.HOP;
            } else {
                if (Math.random()<0.5){
                    return Action.LEFT;
                } else {
                    return Action.RIGHT;
                }
            }
        } else {
            hiding = true;
            return Action.LEFT;
        }

    }

}


