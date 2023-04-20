import java.awt.*;

public class Bear extends Critter {
    private boolean polar;
    private int moves;
    public Bear(boolean polar){
        this.polar = polar;
        moves = 0;
        getColor();
    }
    public Action getMove(CritterInfo info){
        moves++;

        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT; //always infect if an enemy is in front
        } else if (info.getFront() == Neighbor.EMPTY){
            return Action.HOP; //otherwise hop if possible
        } else {
            return Action.LEFT; //otherwise turn left.
        }
    }

    public Color getColor() {
        if (this.polar){
            return Color.WHITE; //Color.WHITE for a polar bear (when polar is true)
        } else {
            return Color.BLACK; //Color.BLACK otherwise (when polar is false)
        }
    }

    public String toString(){
        if (moves % 2 == 0){
            return "/"; //Should alternate on each different move between a slash character (/)
        } else {
            return "\\"; // and a backslash character (\) starting with a slash
        }
    }
}