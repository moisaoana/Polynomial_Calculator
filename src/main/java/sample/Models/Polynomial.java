package sample.Models;

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private ArrayList<Monomial> monomials=new ArrayList<>();
    public Polynomial()
    {

    }
    public ArrayList<Monomial> getMonomials() {
        return monomials;
    }

    public void setMonomials(ArrayList<Monomial> monomials) {
        this.monomials = monomials;
    }
    public void simplify() {
        monomials.removeIf(monomial -> monomial.getCoefficient() == 0);
    }
    public void sortPolynomial()
    {
        Collections.sort(monomials,Collections.reverseOrder());
    }
    public boolean checkIfZero()
    {
        return monomials.size() == 1 && monomials.get(0).getCoefficient() == 0;
    }
    @Override
    public boolean equals(Object object) {

        if (object == this) {
            return true;
        }
        if (!(object instanceof Polynomial)) {
            return false;
        }
        Polynomial p = (Polynomial) object;
        if(this.getMonomials().size()!=p.getMonomials().size())
            return false;
        boolean eq=true;
        int index=0;
        while(index<getMonomials().size())
        {
            if(!(getMonomials().get(index).equals(p.getMonomials().get(index)))){
                eq=false;
                break;
            }
            index++;
        }
        return eq;
    }
    public static boolean validatePolynomial(TextField textField)
    {
        String PATTERN = "^(([+-]{1}|^[+-]?)([0-9]+[*]?[x]{1}|[0-9]+|[x]{1})([\\^]{1}[0-9]+)?)++$";
        Pattern pattern = Pattern.compile(PATTERN);
        String p=textField.getText();
        Matcher matcher = pattern.matcher(p);
        return matcher.matches();
    }
    public static Polynomial getPolynomial(String p1)
    {
        Polynomial polynomial1 = new Polynomial();
        String polyPattern="([+-]?[0-9]*)[*]?([x])?[\\^]?([0-9]*)";
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
            }else
                coeff=1;
            int power =0;
            if (matcher.group(3).equals("")) {
                if(matcher.group(2)!=null)
                    power=1;
            } else {
                power = Integer.parseInt(matcher.group(3));
            }
            if(!(matcher.group(1).equals("") && matcher.group(2)==null &&matcher.group(3).equals("")))
                polynomial1.getMonomials().add(new Monomial(coeff, power));
        }
        polynomial1.sortPolynomial();
        return polynomial1;
    }
}

