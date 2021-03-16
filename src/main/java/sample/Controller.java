package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.Models.Monomial;
import sample.Models.Operations;
import sample.Models.Polynomial;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private boolean firstTextBoxIsClicked = true;
    private boolean secondTextBoxIsClicked = false;
    @FXML
    private Label titleLabel;
    @FXML
    private Label poly1Label;
    @FXML
    private Label poly2Label;
    @FXML
    private TextField poly1TextField;
    @FXML
    private TextField poly2TextField;
    @FXML
    private TextField resultTextField;
    @FXML
    private Label resultLabel;
    @FXML
    private Button addButton;
    @FXML
    private Button subtractButton;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button button0;
    @FXML
    private Button buttonPlus;
    @FXML
    private Button buttonMinus;
    @FXML
    private Button buttonTimes;
    @FXML
    private Button buttonDiv;
    @FXML
    private Button buttonPower;
    @FXML
    private Button clearButton;
    @FXML
    private Button buttonVariableX;
    @FXML
    private Button buttonDelete;
    @FXML
    private Label error1Label;
    @FXML
    private Label error2Label;
    @FXML
    private Button multiplyButton;
    @FXML
    private Button divideButton;
    @FXML
    private Label templateLabel;
    @FXML
    private Label incorrectLabel1;
    @FXML
    private Label incorrectLabel2;
    @FXML
    void click0(ActionEvent event) {
        appendText("0");
    }
    @FXML
    void click1(ActionEvent event) {
        appendText("1");
    }
    @FXML
    void click2(ActionEvent event) {
        appendText("2");
    }
    @FXML
    void click3(ActionEvent event) {
        appendText("3");
    }
    @FXML
    void click4(ActionEvent event) {
        appendText("4");
    }
    @FXML
    void click5(ActionEvent event) {
        appendText("5");
    }
    @FXML
    void click6(ActionEvent event) {
        appendText("6");
    }
    @FXML
    void click7(ActionEvent event) {
        appendText("7");
    }
    @FXML
    void click8(ActionEvent event) {
        appendText("8");
    }
    @FXML
    void click9(ActionEvent event) {
        appendText("9");
    }
    @FXML
    private Button derivativeButton;
    @FXML
    private Button integrationButton;
    @FXML
    void clickTextBox1(MouseEvent event) {
        firstTextBoxIsClicked = true;
        secondTextBoxIsClicked = false;
    }
    @FXML
    void clickTextBox2(MouseEvent event) {
        firstTextBoxIsClicked = false;
        secondTextBoxIsClicked = true;
    }
    @FXML
    void clickDelete(ActionEvent event) {
        if (firstTextBoxIsClicked) {
            if (!poly1TextField.getText().isEmpty())
                poly1TextField.setText(poly1TextField.getText().substring(0, poly1TextField.getText().length() - 1));
        }
        if (secondTextBoxIsClicked) {
            if (!poly2TextField.getText().isEmpty())
                poly2TextField.setText(poly2TextField.getText().substring(0, poly2TextField.getText().length() - 1));
        }
    }
    @FXML
    void clickDiv(ActionEvent event) {
        appendText("/");
    }
    @FXML
    void clickMinus(ActionEvent event) {
        appendText("-");
    }
    @FXML
    void clickPlus(ActionEvent event) {
        appendText("+");
    }
    @FXML
    void clickPower(ActionEvent event) {
        appendText("^");
    }
    @FXML
    void clickTimes(ActionEvent event) {
        appendText("*");
    }
    @FXML
    void clickX(ActionEvent event) {
        appendText("x");
    }
    @FXML
    void clickAdd(ActionEvent event) {
        if (poly1TextField.getText().isEmpty() || poly2TextField.getText().isEmpty()) {
            displayErrorMessages();
            resultTextField.clear();
        } else {
            resultTextField.clear();
            displayErrorMessages();
            if (Polynomial.validatePolynomial(poly1TextField) && Polynomial.validatePolynomial(poly2TextField)) {
                displayIncorrectLabels();
                Polynomial polynomial1 = Polynomial.getPolynomial(poly1TextField.getText());
                Polynomial polynomial2 = Polynomial.getPolynomial(poly2TextField.getText());
                Operations operations = new Operations(polynomial1, polynomial2);
                Polynomial result = operations.add();
                result.simplify();
                displayResult(result);
            } else {
                displayIncorrectLabels();
            }
        }
    }
    @FXML
    void clickSubtract(ActionEvent event) {
        if (poly1TextField.getText().isEmpty() || poly2TextField.getText().isEmpty()) {
            displayErrorMessages();
            resultTextField.clear();
        } else {
            resultTextField.clear();
            displayErrorMessages();
            if (Polynomial.validatePolynomial(poly1TextField) && Polynomial.validatePolynomial(poly2TextField)) {
                displayIncorrectLabels();
                Polynomial polynomial1 = Polynomial.getPolynomial(poly1TextField.getText());
                Polynomial polynomial2 = Polynomial.getPolynomial(poly2TextField.getText());
                Operations operations = new Operations(polynomial1, polynomial2);
                Polynomial result = operations.subtract();
                result.simplify();
                displayResult(result);
            }else{
                displayIncorrectLabels();
            }
        }
    }
    @FXML
    void clickClear(ActionEvent event) {
        resultTextField.clear();
        poly1TextField.clear();
        poly2TextField.clear();
        error1Label.setVisible(false);
        error2Label.setVisible(false);
        incorrectLabel1.setVisible(false);
        incorrectLabel2.setVisible(false);
    }
    @FXML
    void clickMultiply(ActionEvent event) {
        if (poly1TextField.getText().isEmpty() || poly2TextField.getText().isEmpty()) {
            displayErrorMessages();
            resultTextField.clear();
        } else {
            resultTextField.clear();
            displayErrorMessages();
            if (Polynomial.validatePolynomial(poly1TextField) && Polynomial.validatePolynomial(poly2TextField)) {
                displayIncorrectLabels();
                Polynomial polynomial1 = Polynomial.getPolynomial(poly1TextField.getText());
                Polynomial polynomial2 = Polynomial.getPolynomial(poly2TextField.getText());
                Operations operations = new Operations(polynomial1, polynomial2);
                Polynomial result = operations.multiply();
                result.simplify();
                displayResult(result);
            }else{
                displayIncorrectLabels();
            }
        }
    }
    @FXML
    void clickDerivative(ActionEvent event) {
        if (poly1TextField.getText().isEmpty()) {
            error1Label.setVisible(true);
            resultTextField.clear();
        } else {
            resultTextField.clear();
            if (Polynomial.validatePolynomial(poly1TextField) ) {
                incorrectLabel1.setVisible(!Polynomial.validatePolynomial(poly1TextField));
                Polynomial polynomial1 = Polynomial.getPolynomial(poly1TextField.getText());
                Operations operations = new Operations(polynomial1, null);
                Polynomial result = operations.derivative();
                result.simplify();
                displayResult(result);
            }else{
                displayIncorrectLabels();
            }
        }
    }
    @FXML
    void clickIntegration(ActionEvent event) {
        if (poly1TextField.getText().isEmpty()) {
            error1Label.setVisible(true);
            resultTextField.clear();
        } else {
            resultTextField.clear();
            if (Polynomial.validatePolynomial(poly1TextField)) {
                incorrectLabel1.setVisible(!Polynomial.validatePolynomial(poly1TextField));
                Polynomial polynomial1 = Polynomial.getPolynomial(poly1TextField.getText());
                Operations operations = new Operations(polynomial1, null);
                Polynomial result = operations.integration();
                result.simplify();
                displayResult(result);
            }else{
                displayIncorrectLabels();
            }
        }
    }
    @FXML
    void clickDivide(ActionEvent event) {
        if (poly1TextField.getText().isEmpty() || poly2TextField.getText().isEmpty()) {
            displayErrorMessages();
            resultTextField.clear();
        } else {
            resultTextField.clear();
            displayErrorMessages();
            if (Polynomial.validatePolynomial(poly1TextField) && Polynomial.validatePolynomial(poly2TextField)) {
                displayIncorrectLabels();
                Polynomial polynomial1 = Polynomial.getPolynomial(poly1TextField.getText());
                Polynomial polynomial2 = Polynomial.getPolynomial(poly2TextField.getText());
                if(polynomial1.checkIfZero() || polynomial2.checkIfZero()) {
                    resultTextField.appendText("Operand cannot be zero!");
                }
                else {
                    Operations operations = new Operations(polynomial1, polynomial2);
                    ArrayList<Polynomial> result = operations.division();
                    resultTextField.appendText("Quotient:");
                    displayResult(result.get(0));
                    resultTextField.appendText(" | Remainder: ");
                    displayResult(result.get(1));
                }
            }else{
                displayIncorrectLabels();
            }
        }
    }
    public void appendText(String string) {
        if (firstTextBoxIsClicked) {
            poly1TextField.appendText(string);
        }
        if (secondTextBoxIsClicked) {
            poly2TextField.appendText(string);
        }
    }
    public void displayErrorMessages() {
        error1Label.setVisible(poly1TextField.getText().isEmpty());
        error2Label.setVisible(poly2TextField.getText().isEmpty());
    }
    public void displayIncorrectLabels(){
        incorrectLabel1.setVisible(!Polynomial.validatePolynomial(poly1TextField));
        incorrectLabel2.setVisible(!Polynomial.validatePolynomial(poly2TextField));
    }

    public void displayResult(Polynomial polynomial)
    {
        DecimalFormat f = new DecimalFormat("#.##");
        if(polynomial.getMonomials().isEmpty()) {
            resultTextField.appendText("0");
        }
        for(Monomial monomial: polynomial.getMonomials())
        {
                switch(monomial.getPower()) {
                    case 0:
                        if (monomial.getCoefficient() == 1) {
                            resultTextField.appendText("+1");
                        } else if (monomial.getCoefficient() == -1) {
                            resultTextField.appendText("-1");
                        }else{
                                if (monomial.getCoefficient() > 0)
                                         resultTextField.appendText("+" + f.format(monomial.getCoefficient()));
                                else
                                    resultTextField.appendText(f.format(monomial.getCoefficient()));
                        }
                        break;
                    case 1:
                        if(monomial.getCoefficient()==1) {
                            resultTextField.appendText("+x");
                        }else if(monomial.getCoefficient()==-1) {

                            resultTextField.appendText("-x");
                        }else{
                                if (monomial.getCoefficient() > 0)
                                    resultTextField.appendText("+" + f.format(monomial.getCoefficient()) + "*x");
                                else
                                    resultTextField.appendText(f.format(monomial.getCoefficient()) + "*x");
                                break;
                        }
                        break;
                    default:
                        if(monomial.getCoefficient()==1) {
                            resultTextField.appendText("+x^" + monomial.getPower());
                        }else if(monomial.getCoefficient()==-1) {
                            resultTextField.appendText("-x^" + monomial.getPower());
                        }else{
                                if (monomial.getCoefficient() > 0)
                                    resultTextField.appendText("+" +f.format(monomial.getCoefficient())+"*x^"+monomial.getPower());
                                else
                                    resultTextField.appendText( f.format(monomial.getCoefficient())+"*x^"+monomial.getPower());
                                break;
                        }
                        break;
                }
        }
    }
}
