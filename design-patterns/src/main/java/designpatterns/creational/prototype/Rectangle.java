package designpatterns.creational.prototype;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle implements DrawablePrototype{

	private int x = 0;
	private int y = 0;
	private int w = 100;
	private int h = 100;
	private int arcWidth = 50;
	private int arcHeight = 50;
	private double borderWidth = 1;
	private Color borderColor = Color.BLACK;
	private Color fillColor = Color.WHITE;
	
	private boolean isRounded = false;
	private boolean hasBorder = true;
	private boolean centered = true;
	
	@Override
	public Rectangle clone() {
		Rectangle clone = null;
		try {
			clone = (Rectangle)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return clone;
	}

	@Override
	public void draw(GraphicsContext gc) {
        
		int x = this.x;
		int y = this.y;
		
		if(centered)
		{
			x = x - w / 2;
			y = y - h / 2;
		}
		
		gc.setFill(fillColor);
        gc.setStroke(borderColor);
        gc.setLineWidth(borderWidth);
        
        if(isRounded)
        {
        	gc.fillRoundRect(x, y, w, h, arcWidth, arcHeight);
        	if(hasBorder)
        	{
                gc.strokeRoundRect(x, y, w, h, arcWidth, arcHeight);
        	}
        }
        else
        {
        	gc.fillRect(x, y, w, h);
        	if(hasBorder)
        	{
                gc.strokeRect(x, y, w, h);
        	}
        }
	}
	
	
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public int getArcWidth() {
		return arcWidth;
	}

	public int getArcHeight() {
		return arcHeight;
	}

	public double getBorderWidth() {
		return borderWidth;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public boolean isRounded() {
		return isRounded;
	}

	public boolean hasBorder() {
		return hasBorder;
	}

	@Override
	public Rectangle setX(int x)
	{
		this.x = x;
		return this;
	}
	
	@Override
	public Rectangle setY(int y)
	{
		this.y = y;
		return this;
	}
	
	public Rectangle setW(int w)
	{
		this.w = w;
		return this;
	}
	
	public Rectangle setH(int h)
	{
		this.h = h;
		return this;
	}
	
	public Rectangle setArcWidth(int arcWidth)
	{
		this.arcWidth = arcWidth;
		return this;
	}
	
	public Rectangle setArcHeight(int arcHeight)
	{
		this.arcHeight = arcHeight;
		return this;
	}
	
	public Rectangle setBorderWidth(double borderWidth)
	{
		this.borderWidth = borderWidth;
		return this;
	}
	
	public Rectangle setBorderColor(Color borderColor)
	{
		this.borderColor = borderColor;
		return this;
	}
	
	public Rectangle setFillColor(Color fillColor)
	{
		this.fillColor = fillColor;
		return this;
	}
	
	public Rectangle setIsRounded(boolean isRounded)
	{
		this.isRounded = isRounded;
		return this;
	}
	
	public Rectangle setHasBorder(boolean hasBorder)
	{
		this.hasBorder = hasBorder;
		return this;
	}

	public boolean isCentered() {
		return centered;
	}

	public void setCentered(boolean centered) {
		this.centered = centered;
	}
	


}
