module com.calculator.app.calculatorjfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.calculator.app.calculatorjfx to javafx.fxml;
    exports com.calculator.app.calculatorjfx;
}