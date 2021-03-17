package sample.Models;

public class Monomial implements Comparable< Monomial> {
    private double coefficient;
    private int power;
    public Monomial(double coefficient,int power){
        this.coefficient=coefficient;
        this.power=power;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public int compareTo(Monomial o) {
        return Integer.compare(this.getPower(),o.getPower());
    }

    @Override
    public boolean equals(Object object) {

        if (object == this) {
            return true;
        }
        if (!(object instanceof Monomial)) {
            return false;
        }
       Monomial m = (Monomial) object;
        return Double.compare(coefficient, m.coefficient) == 0
                && Integer.compare(power, m.power) == 0;
    }
}
