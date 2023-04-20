import java.awt.*;
import java.util.*;


public class Tiger extends Critter {
    private int moves;
    Color tigerColor;
    Random rand = new Random();
    public Tiger(){
        moves = 0;
        getColor();
    }
    public Action getMove(CritterInfo info) {
        moves++;

        if (info.getFront() == Neighbor.OTHER){
            return Action.INFECT; //always infect if an enemy is in front,
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL){
            return Action.LEFT; //otherwise if a wall is in front or to the right, then turn left
        } else if (info.getFront() == Neighbor.SAME){
            return Action.RIGHT; //otherwise if a fellow Tiger is in front, then turn right
        } else {
            return Action.HOP; //otherwise hop
        }
    }
    public Color getColor() {
        //Randomly picks one of three colors (Color.RED, Color.GREEN, Color.BLUE) and uses that color for three moves,
        //then randomly picks one of those colors again for the next three moves,
        //then randomly picks another one of those colors for the next three moves, and so on.
        if (moves % 3 == 0){ // set new color
            int m = 0;
            while (m == 0){
                int c = rand.nextInt(3); //0.Red 1.Green 2.Blue
                if (c == 0 && this.tigerColor != Color.RED){
                    this.tigerColor = Color.RED;
                    m++;
                } if (c == 1 && tigerColor != Color.GREEN){
                    this.tigerColor = Color.GREEN;
                    m++;
                } if (c==2 && tigerColor != Color.BLUE){
                    this.tigerColor = Color.BLUE;
                    m++;
                }
            }
        }
        return tigerColor;
    }
    public String toString() { return "TGR"; }
}