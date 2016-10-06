
import java.awt.Color;
import java.awt.Graphics2D;
/**
 * A GraphicShape interface describes the operations of the graphic shape, and allow user to use. 
 * 
 * @author Karl Nicholas
 * @author Calvin 
 */
public abstract class GraphicShape {

	//use protected final to keep instance data for subclasses
	protected boolean colorChange;
	protected Color color;
	protected int radius, sides;
	protected double rotation;
	protected double recursionFactor; 
	protected int counter;
	
	/** A new GraphicShape method take those param for a new shape.
	    @param color	@return color.
	    @param sides, Point center		@return the side and point center of the new shape
	    @param radius	@return the radius of the new shape
	    @param rotation	@return the rotation of the new shape
	    @param recursionFactor	@return the recursionFactor of the new shape*/
	public GraphicShape(boolean change, Color color, int sides, Point center, int radius, double rotation, double recursionFactor, int counter){
		this.colorChange = change;
		this.radius = radius;
		this.sides = sides;
		this.rotation = rotation;
		this.recursionFactor = recursionFactor;
		this.counter = counter;
	}

	/** Custom painting used in GraphicsPolygon class
	    @param g 
	    	The object to get the method in GraphicsPolygon class*/
	public abstract void paintComponent(Graphics2D g);
	
	/** To make the shape recursive
	    @param baseShape 
	    	The object take the base shape*/
	public abstract void recurseShape(GraphicShape baseShape);

	public abstract int[] getXPoints();

	public abstract int[] getYPoints();

	public abstract void setVertixShape(int index, GraphicShape graphicShape);

	public void newShape(){};
	
	/** Gets the shape's radius.
	    @return the integer of the shape's radius.*/
	public int getRadius() {
		return this.radius;
	}

	/** Gets the choice of whether or not to change colors
		@return a boolean value to change colors or not.*/
	public boolean getColorChange(){
		return this.colorChange;
	}
	
	/** Gets the colors.
	    @return the color which we invoke.*/
	public Color getColor(){
		return this.color;
	}
	
	/** Gets the sides of th shape.
	    @return the sides.*/
	public int getSides() {
		return this.sides;
	}
	
	/** Makes the  shape do rotation.
	    @return the rotation.*/
	public double getRotation() {
		return this.rotation;
	}
	
	/** Gets the recursion factor.
	    @return the recursion factor.*/
	public double getRecursionFactor() {
		return this.recursionFactor;
	}

	public abstract int getCounter();

	public abstract GraphicShape newShape(boolean change, Color color, int sides, Point center, int radius, double rotation, double recursionFactor, int counter);

}
