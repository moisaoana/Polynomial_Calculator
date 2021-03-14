package sample.Models;

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


}
