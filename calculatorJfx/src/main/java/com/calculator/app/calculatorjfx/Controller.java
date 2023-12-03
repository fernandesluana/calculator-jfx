package com.calculator.app.calculatorjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Text output;

    private String operator = "";

    private long number1 = 0;

    private long number2 = 0;

    private boolean start = true;

    private Model model = new Model();

    @FXML
    private void processNumpad(ActionEvent event) {
        if(start){
            output.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    private void processOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if (!"=".equals(value)) {
            if (!operator.isEmpty())
                return;

            operator = value;
            number1 = Long.parseLong(output.getText());

            output.setText("");
        } else {
            if(operator.isEmpty())
                return;

            number2 = Long.parseLong(output.getText());

            long result =  model.calculate(number1, number2, operator);
            output.setText(String.valueOf(result));
            operator = "";
            start = true;
        }
    }

    @FXML
    private void processClear(){
        output.setText("");
        operator = "";
        start=true;
    }


}