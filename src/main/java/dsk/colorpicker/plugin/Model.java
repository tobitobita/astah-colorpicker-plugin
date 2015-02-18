package dsk.colorpicker.plugin;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Model {

    private final IntegerProperty red = new SimpleIntegerProperty(this, "red", 255);

    public int getRed() {
        return this.red.get();
    }

    public void setRed(int value) {
        System.out.println(value);
        this.red.set(value);
    }

    public IntegerProperty redProperty() {
        return this.red;
    }
}
