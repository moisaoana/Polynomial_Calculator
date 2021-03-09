package sample.Models;

public class Monomial {
    private int coefficient;
    private int power;
    public Monomial(int coefficient,int power){
        this.coefficient=coefficient;
        this.power=power;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }


}
