import java.awt.*;

public class WhiteTiger extends Tiger {
    boolean hasInfected;
    public WhiteTiger(){
        hasInfected = false;
    }
    public Action getMove(CritterInfo info) {
        //Same as a Tiger.
        // Note: you’ll have to override this method to figure out if it has infected another Critter.
        if (info.getFront() == Neighbor.OTHER){
            hasInfected = true;
        }
        return super.getMove(info);
    }

    public Color getColor() { return Color.WHITE; }

    public String toString() {
        if (!hasInfected){
            return "tgr"; //"tgr" if it hasn’t infected another Critter yet
        } else {
            return "TGR"; //“TGR” if it has infected.
        }
    }
}