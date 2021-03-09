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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private boolean firstTextBoxIsClicked=true;
    private boolean secondTextBoxIsClicked=false;
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
    private Button buttonVariableX;
    @FXML
    private Button buttonDelete;
    @FXML
    private Label error1Label;

    @FXML
    private Label error2Label;
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
    void clickTextBox1(MouseEvent event) {
        firstTextBoxIsClicked=true;
        secondTextBoxIsClicked=false;
    }
    @FXML
    void clickTextBox2(MouseEvent event) {
        firstTextBoxIsClicked=false;
        secondTextBoxIsClicked=true;
    }
    @FXML
    void clickDelete(ActionEvent event) {
        if(firstTextBoxIsClicked){
            if(!poly1TextField.getText().isEmpty())
                poly1TextField.setText(poly1TextField.getText().substring(0,poly1TextField.getText().length()-1));
        }
        if(secondTextBoxIsClicked){
            if(!poly2TextField.getText().isEmpty())
                poly2TextField.setText(poly2TextField.getText().substring(0,poly2TextField.getText().length()-1));
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
       displayErrorMessages();
       Polynomial polynomial1=getPolynomial(poly1TextField);
       Polynomial polynomial2=getPolynomial(poly2TextField);
       for(int i=0;i<polynomial1.getMonomials().size();i++)
       {
           System.out.println(polynomial1.getMonomials().get(i).getCoefficient()+" "+polynomial1.getMonomials().get(i).getPower());
       }
        for(int i=0;i<polynomial2.getMonomials().size();i++)
        {
            System.out.println(polynomial2.getMonomials().get(i).getCoefficient()+" "+polynomial2.getMonomials().get(i).getPower());
        }
        Operations operations=new Operations(polynomial1,polynomial2);
        Polynomial result=operations.add();
        displayResult(result);

    }

    @FXML
    void clickSubtract(ActionEvent event) {
        displayErrorMessages();
    }
    public void appendText(String string)
    {
        if(firstTextBoxIsClicked){
            poly1TextField.appendText(string);
        }
        if(secondTextBoxIsClicked){
            poly2TextField.appendText(string);
        }
    }
    public void displayErrorMessages()
    {
        error1Label.setVisible(poly1TextField.getText().isEmpty());
        error2Label.setVisible(poly2TextField.getText().isEmpty());
    }
    public Polynomial getPolynomial(TextField textField)
    {
        Polynomial polynomial1 = new Polynomial();
        String polyPattern="([+-]?[0-9]*)[*]?([x])?[\\^]?([0-9]*)";
        String p1=textField.getText();
        Pattern pattern =Pattern.compile(polyPattern);
        Matcher matcher=pattern.matcher(p1);
        while(matcher.find()) {
            int coeff=0 ;
            if(!matcher.group(1).equals("")) {
                if (matcher.group(1).equals("+"))
                    coeff = 1;
                else if (matcher.group(1).equals("-"))
                    coeff = -1;
                else
                    coeff = Integer.parseInt(matcher.group(1));
            }else{
                coeff=1;
            }
            int power =0;
            if (matcher.group(3).equals("")) {
                if(matcher.group(2)==null)
                    power=0;
                else
                    power=1;
            } else {
                power = Integer.parseInt(matcher.group(3));
            }

            if(!(matcher.group(1).equals("") && matcher.group(2)==null &&matcher.group(3).equals(""))) {
                Monomial monomial = new Monomial(coeff, power);
                polynomial1.getMonomials().add(monomial);
            }
        }
       return polynomial1;
    }
    public void displayResult(Polynomial polynomial)
    {
        for(Monomial monomial: polynomial.getMonomials())
        {
                switch(monomial.getPower()) {
                    case 0:
                        switch(monomial.getCoefficient()) {
                            case 1:
                                resultTextField.appendText("+1" );
                                break;
                            case -1:
                                resultTextField.appendText("-1" );
                                break;
                            default:
                                if (monomial.getCoefficient() > 0)
                                    resultTextField.appendText("+" + Integer.toString(monomial.getCoefficient()));
                                else
                                    resultTextField.appendText(Integer.toString(monomial.getCoefficient()));
                        }
                        break;
                    case 1:
                        switch(monomial.getCoefficient()) {
                            case 1:
                                resultTextField.appendText("+x");
                                break;
                            case -1:
                                resultTextField.appendText("-x");
                                break;
                            default:
                                if (monomial.getCoefficient() > 0)
                                    resultTextField.appendText("+" + Integer.toString(monomial.getCoefficient()) + "*x");
                                else
                                    resultTextField.appendText(Integer.toString(monomial.getCoefficient()) + "*x");
                                break;
                        }
                        break;
                    default:
                        switch(monomial.getCoefficient()) {
                            case 1:
                                resultTextField.appendText("+x^"+monomial.getPower());
                                break;
                            case -1:
                                resultTextField.appendText("-x^"+monomial.getPower());
                                break;
                            default:
                                if (monomial.getCoefficient() > 0)
                                    resultTextField.appendText("+" + Integer.toString(monomial.getCoefficient())+"*x^"+monomial.getPower());
                                else
                                    resultTextField.appendText( Integer.toString(monomial.getCoefficient())+"*x^"+monomial.getPower());
                                break;
                        }

                        break;
                }

        }
    }
}
