package domain;

/**
 *
 * @author Marianella
 */
public class Circle {

    public String identification;
    public Point pointPosition;
    public String pointPosition1 = "" + pointPosition;
    public int size;

    public Circle() {
    }

    public Circle(String identification, int x, int y, int side) {
        this.identification = identification;
        pointPosition = new Point(x, y);
        this.size = side;
    }

//    public Circle(String identification, Point pointPosition, int side) {
//        this.identification = identification;
//        this.pointPosition = pointPosition;
//        this.size = side;
//    }
    public Circle(String identification, Point pointPosition, int side) {
        this.setIdentification(identification);
        this.setPointPosition(pointPosition);
        this.setSide(side);
    }

    public String getIdentification() {
        return identification;
    }

    /**
     * @return the pointPosition
     */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Point getPointPosition() {
        return pointPosition;
    }

    public String getPointPosition1() {
        return "" + pointPosition;
    }

    /**
     * @param pointPosition the pointPosition to set
     */
    public void setPointPosition(Point pointPosition) {
        this.pointPosition = pointPosition;
    }
public void setPointPosition1(Point pointPosition) {
        this.pointPosition = pointPosition;
    }
    /**
     * @return the side
     */
    public int getSide() {
        return size;
    }

    /**
     * @param side the side to set
     */
    public void setSide(int side) {
        this.size = side;
    }

    @Override
    public String toString() {
        return "Circle{" + "identification=" + identification + ", size=" + size + '}';
    }

    public Object get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
