package designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.geom.transform.Affine2D;
import com.sun.javafx.geom.transform.BaseTransform;

import designpatterns.prototype.toolbar.PrototypeToolbar;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application implements Redrawable, ToolbarTarget{
	
	List<DrawablePrototype> dpsList = new ArrayList<DrawablePrototype>();
	Canvas mainCanvas;
	Canvas previewCanvas;
	PrototypeToolbar prototypeToolbar;
	RectControls rectControls;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		createPrototypeAndCursor();
		
		primaryStage.setTitle("Prototype Example");
		
		GridPane rootGrid = new GridPane();
		rootGrid.setPadding(new Insets(10,10,10,10));
		rootGrid.setVgap(20);
		rootGrid.setHgap(20);
		
		previewCanvas = new Canvas(205,205);
		mainCanvas = new Canvas(800,600);
		setupMainCanvasMouseListener();

		GridPane previewGrid = new GridPane();
		
		previewGrid.add(new Label("Preview"),0,0);
		previewGrid.add(previewCanvas,0,1);
		
		prototypeToolbar = new PrototypeToolbar(this);
		
		previewGrid.add(getRectSaver(),0,3);
		
		previewGrid.add(getRectControls(), 0, 4);
				
		previewGrid.add(prototypeToolbar, 0, 5);
		
		rootGrid.add(previewGrid, 0, 0);
		
		GridPane mainGrid = new GridPane();
		
		mainGrid.add(new Label("Main"),0,0);
		mainGrid.add(mainCanvas,0,1);
		
		rootGrid.add(mainGrid,1,0);
			
		saveRectPrototype();
		
		Group root = new Group();
		
		root.getChildren().add(rootGrid);
		
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		
	}

	private void setupMainCanvasMouseListener() {
		mainCanvas.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				getCursor()
				.setX((int)e.getX())
				.setY((int)e.getY());
				reDraw();
			}});
		
		mainCanvas.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
				dpsList.add(getCursor().clone());
				reDraw();
			}});
	}

	private Node getRectSaver() {
		Button saveRect = new Button("Clone Prototype");
		saveRect.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				saveRectPrototype();
			}
		});
		return saveRect;
	}

	private void saveRectPrototype()
	{
		Image preview = previewCanvas.snapshot(null, null);
		prototypeToolbar.savePrototype(preview, dpsList.get(0).clone());
	}
	
	private Node getRectControls() {
		rectControls = new RectControls(this,(Rectangle)dpsList.get(0));
		return rectControls;
	}

	private DrawablePrototype getPrototype()
	{
		return dpsList.get(0);
	}
	
	private DrawablePrototype getCursor()
	{
		return dpsList.get(1);
	}
	
	private void createPrototypeAndCursor()
	{
		dpsList.add(new Rectangle());
		dpsList.add(getPrototype().clone());
	}
	
	@Override
	public void toolbarSelection(DrawablePrototype dp) {
		dpsList.set(0, dp.clone());
		dpsList.set(1, dp.clone());
		rectControls.setRect((Rectangle)getPrototype());
		reDraw();
	}
	
	@Override
	public void reDraw() {
		// draw prototype canvas + border
		GraphicsContext gc = previewCanvas.getGraphicsContext2D();
		gc.clearRect(0, 0, previewCanvas.getWidth(), previewCanvas.getHeight());
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(1);
		gc.strokeRect(0, 0, previewCanvas.getWidth(), previewCanvas.getHeight());
		gc.save();
		gc.translate(previewCanvas.getWidth()/2, previewCanvas.getHeight()/2);
		dpsList.get(0).draw(gc);
		gc.restore();
		
		// draw main canvas + border
		gc = mainCanvas.getGraphicsContext2D();
		gc.clearRect(0, 0, mainCanvas.getWidth(), mainCanvas.getHeight());
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(1);
		gc.strokeRect(0, 0, mainCanvas.getWidth(), mainCanvas.getHeight());
		
		for(int i = 2; i < dpsList.size(); i++)
		{
			gc.save();
			dpsList.get(i).draw(gc);
			gc.restore();
		}
		
		gc.save();
		getCursor().draw(gc);
		gc.restore();
		
		
    }

	
}
