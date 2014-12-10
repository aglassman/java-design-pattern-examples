package designpatterns.prototype;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class RectControls extends GridPane{
	
	final Slider width;
	final Label widthOut;
	
	final Slider height;
	final Label heightOut;
	
	final ColorPicker fillPicker;
	
	final ColorPicker borderPicker;
	
	final Slider borderWidth;
	final Label borderWidthOut;
	
	final CheckBox hasBorder;
	
	final CheckBox isRounded;
	
	final Redrawable redrawable;
	
	Rectangle rectangle;
	
	public RectControls(Redrawable redrawable, Rectangle rect)
	{
		super();
		
		this.rectangle = rect;
		
		this.redrawable = redrawable;
		
		setPadding(new Insets(10,10,10,10));
		
		setVgap(5);
		
		int line = 0;
		
		//W
		add(new Label("Width"),0,line);
		width = new Slider(1, 200, rect.getW());
		add(width,1,line);
		widthOut = new Label(Integer.toString(rect.getW()));
		widthOut.setMinWidth(40);
		add(widthOut,2,line);
		width.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> ov,
					Number oldVal, Number newVal) {
				widthOut.setText(String.format("%3d",newVal.intValue()));
				rectangle.setW(newVal.intValue());
				redrawable.reDraw();
			}
		});
		line++;		
		
		//H
		add(new Label("Height"),0,line);
		height = new Slider(1, 200, rect.getH());
		add(height,1,line);
		heightOut = new Label(Integer.toString(rect.getH()));
		heightOut.setMinWidth(40);
		add(heightOut,2,line);
		height.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> ov,
					Number oldVal, Number newVal) {
				heightOut.setText(String.format("%3d",newVal.intValue()));
				rectangle.setH(newVal.intValue());
				redrawable.reDraw();
			}
		});
		line++;
		
		//Fill
		fillPicker = new ColorPicker(rect.getFillColor());
		fillPicker.valueProperty().addListener(new ChangeListener<Color>() {

			@Override
			public void changed(ObservableValue<? extends Color> oc,
					Color oldColor, Color newColor) {
				rectangle.setFillColor(newColor);
				redrawable.reDraw();
			}
		});
		add(new Label("Fill"),0,line);
		add(fillPicker,1,line);
		line++;
		
		//Border Color
		borderPicker = new ColorPicker(rect.getBorderColor());
		borderPicker.valueProperty().addListener(new ChangeListener<Color>() {

			@Override
			public void changed(ObservableValue<? extends Color> oc,
					Color oldColor, Color newColor) {
				rectangle.setBorderColor(newColor);
				redrawable.reDraw();
			}
		});
		add(new Label("Border"),0,line);
		add(borderPicker,1,line);
		line++;
		
		//Stroke Width
		add(new Label("Border Width"),0,line);
		borderWidth = new Slider(1, 50, rect.getBorderWidth());
		add(borderWidth,1,line);
		borderWidthOut = new Label(Double.toString(rect.getBorderWidth()));
		borderWidthOut.setMinWidth(40);
		add(borderWidthOut,2,line);
		borderWidth.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> ov,
					Number oldVal, Number newVal) {
				borderWidthOut.setText(String.format("%3.2f",newVal.doubleValue()));
				rectangle.setBorderWidth(newVal.doubleValue());
				redrawable.reDraw();
			}
		});
		line++;	
		
		//hasBorder
		add(new Label("Enable Border"),0,line);
		hasBorder = new CheckBox();
		hasBorder.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> ov,
					Boolean oldBool, Boolean newBool) {
				rectangle.setHasBorder(newBool);
				redrawable.reDraw();
			}
		});
		hasBorder.setSelected(rect.hasBorder());
		add(hasBorder,1,line);
		line++;
		
		//isRounded
		add(new Label("Rounded Corners"),0,line);
		isRounded = new CheckBox();
		isRounded.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> ov,
					Boolean oldBool, Boolean newBool) {
				rectangle.setIsRounded(newBool);
				redrawable.reDraw();
			}
		});
		isRounded.setSelected(rect.isRounded());
		add(isRounded,1,line);
		line++;
		
	}

	public void setRect(Rectangle rect) {
		this.rectangle = rect;
	}
}
