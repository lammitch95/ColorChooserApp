package chooser.colorchooserapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.text.NumberFormat;

public class ColorChooserController {

    @FXML
    private Slider alphaSlider;

    @FXML
    private TextField alphaTextField;

    @FXML
    private Slider blueSlider;

    @FXML
    private TextField blueTextField;

    @FXML
    private Rectangle colorRectangle;

    @FXML
    private Slider greenSlider;

    @FXML
    private TextField greenTextField;

    @FXML
    private Slider redSlider;

    @FXML
    private TextField redTextField;

    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;

    public void initialize(){
        /*
        redTextField.textProperty().bind(redSlider.valueProperty().asString("%.0f"));
        greenTextField.textProperty().bind(greenSlider.valueProperty().asString("%.0f"));
        blueTextField.textProperty().bind(blueSlider.valueProperty().asString("%.0f"));
        alphaTextField.textProperty().bind(alphaSlider.valueProperty().asString("%.2f"));
        */
        redTextField.textProperty().bindBidirectional(redSlider.valueProperty(), NumberFormat.getIntegerInstance());
        greenTextField.textProperty().bindBidirectional(greenSlider.valueProperty(), NumberFormat.getIntegerInstance());
        blueTextField.textProperty().bindBidirectional(blueSlider.valueProperty(), NumberFormat.getIntegerInstance());
        alphaTextField.textProperty().bindBidirectional(alphaSlider.valueProperty(), NumberFormat.getNumberInstance());

        redSlider.valueProperty().addListener((observableValue, number, t1) -> {
            red = t1.intValue();
            setRectangleColor();
        });

        greenSlider.valueProperty().addListener((observableValue, number, t1) -> {
           green = t1.intValue();
           setRectangleColor();
        });

        blueSlider.valueProperty().addListener((observableValue, number, t1) -> {
           blue = t1.intValue();
           setRectangleColor();
        });

        alphaSlider.valueProperty().addListener((observableValue, number, t1) -> {
            alpha = t1.doubleValue();
            setRectangleColor();
        });

    }

    public void setRectangleColor(){
        colorRectangle.setFill(Color.rgb(red,green,blue,alpha));
    }

}
