package sample.Models;

import java.util.ArrayList;

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


}
