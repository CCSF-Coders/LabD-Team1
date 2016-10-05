import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class GraphicsCircles extends GraphicsBaseclass {
	private final GraphicShape[] vertixCircles;

	private final Ellipse2D.Float ellipse;
	private int[] xVertices;
	private int[] yVertices;

	public GraphicsCircles(boolean change, Color color,int sides, Point center, int radius, double rotation, double recursionFactor, int counter) {
		super(change, color, sides, center, radius, rotation, recursionFactor, counter);
		vertixCircles = new GraphicsCircles[sides]; 

		double slice = (2*Math.PI)/((double)sides);
		xVertices = new int[sides];
		yVertices = new int[sides];
		
		for ( int s=0; s < sides; ++s ) {
			xVertices[s] = (int)(center.getX()-(Math.cos((double)s*slice+rotation)*radius));
			yVertices[s] = (int)(center.getY()-(Math.sin((double)s*slice+rotation)*radius));
		}
		ellipse = new Ellipse2D.Float(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
	}

	@Override
	public void paintComponent(Graphics2D g) {
		g.setColor(Color.GRAY);
		g.draw(ellipse);
		g.setColor(this.color);
		g.fill(ellipse);
		for ( GraphicShape vertixCircle: vertixCircles ) {
			if ( vertixCircle != null ) vertixCircle.paintComponent(g);
		}
	}
	@Override
	public boolean getColorChange(){
		return colorChange;
	}
	@Override
	public Color getColor(){
		return color;
	}
	@Override
	public int getRadius() {
		return radius;
	}
	@Override
	public int getSides() {
		return sides;
	}
	@Override
	public double getRotation() {
		return rotation;
	}
	@Override
	public double getRecursionFactor() {
		return recursionFactor;
	}
	@Override
	public void setVertixShape(int index, GraphicShape graphicShape) {
		vertixCircles[index] = graphicShape;
	}
	@Override
	public int[] getXPoints() {
		return xVertices;
	}
	@Override
	public int[] getYPoints() {
		return yVertices;
	}

	@Override
	public GraphicShape newShape(boolean change, Color color, int sides, Point center, int radius, double rotation, double recursionFactor, int counter) {
		return new GraphicsCircles(colorChange, color, sides, center, radius, rotation, recursionFactor, counter);
	}

}
