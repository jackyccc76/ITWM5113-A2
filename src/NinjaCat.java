import java.awt.*;

public class NinjaCat extends WhiteTiger {
    public boolean hasInfected;
    public NinjaCat (){
        hasInfected = false;
    }
    public Action getMove(CritterInfo info) {
        //same as White Tiger, but changes color when has infected
        if (info.getFront() == Neighbor.OTHER){
            hasInfected = true;
        }
        return super.getMove(info);
    }

    public Color getColor() {
        if (hasInfected){
            return Color.PINK; //PINK color if it has infected
        } else {
            return Color.YELLOW; //YELLOW color if it hasn’t infected another Critter yet
        }
    }

    public String toString() { return "NC"; }
}