package designpatterns.creational.prototype;

import javafx.scene.canvas.GraphicsContext;

public interface DrawablePrototype extends Cloneable {
	DrawablePrototype clone();
	public void draw(GraphicsContext gc);
	DrawablePrototype setX(int x);
	DrawablePrototype setY(int y);
}
