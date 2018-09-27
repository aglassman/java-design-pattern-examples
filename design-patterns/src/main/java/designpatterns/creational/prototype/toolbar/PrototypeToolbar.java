package designpatterns.creational.prototype.toolbar;

import designpatterns.creational.prototype.DrawablePrototype;
import designpatterns.creational.prototype.ToolbarTarget;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class PrototypeToolbar extends GridPane{
	
	private int numberSaved = 0;
	final private ToolbarTarget target;
	
	
	public PrototypeToolbar(ToolbarTarget target)
	{
		super();
		this.target = target;
	}
	
	public void savePrototype(Image preview, DrawablePrototype drawablePrototype)
	{
		
		numberSaved++;
		
		ImageView imageView = new ImageView(preview);
		imageView.setFitWidth(60);
		imageView.setFitHeight(60);
		
		Button button = new Button();
		button.setGraphic(imageView);
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			private DrawablePrototype dp = drawablePrototype;
			
			@Override
			public void handle(ActionEvent arg0) {
				target.toolbarSelection(this.dp);
			}
		});
		add(button,(numberSaved-1)%4,(numberSaved-1)/4);
	}
}
