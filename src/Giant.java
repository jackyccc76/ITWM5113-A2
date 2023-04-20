import java.awt.*;

public class Giant extends Critter{
    private int moves;
    public Giant(){
        moves = 0;
        getColor();
    }
    public Action getMove(CritterInfo info) {
        //track moves
        if (moves == 24) {
            moves = 1;
        } else {
            moves++;
        }

        if (info.getFront() == Neighbor.OTHER){
            return Action.INFECT; //always infect if an enemy is in front
        } else if(info.getFront() == Neighbor.EMPTY){
            return Action.HOP; //otherwise hop if possible
        } else {
            return Action.RIGHT; //otherwise turn right
        }
    }

    public Color getColor() { return Color.GRAY; }

    public String toString() {
        if (moves <= 6){
            return "fee"; //"fee" for 6 moves
        } else if (moves <= 12){
            return "fie"; //then "fie" for 6 moves
        } else if (moves <= 18){
            return "foe"; //then "foe" for 6 moves
        } else {
            return "fum"; //then "fum" for 6 moves, then repeat.
        }
    }
}