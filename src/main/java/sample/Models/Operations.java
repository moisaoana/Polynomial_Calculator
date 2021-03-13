package sample.Models;
import java.util.ArrayList;

public class Operations {
    private Polynomial polynomial1;
    private Polynomial polynomial2;

    public Operations(Polynomial polynomial1, Polynomial polynomial2) {
        this.polynomial1 = polynomial1;
        this.polynomial2 = polynomial2;
    }

    public Polynomial add() {
        Polynomial result = new Polynomial();
        for (Monomial monomial : polynomial1.getMonomials()) {
            result.getMonomials().add(monomial);
        }
        for (Monomial monomial : polynomial2.getMonomials()) {
            int found = 0,index=0;
            for (Monomial monomialResult : result.getMonomials()) {
                if (monomial.getPower() == monomialResult.getPower()) {
                    if (monomialResult.getCoefficient() + monomial.getCoefficient() != 0)
                        monomialResult.setCoefficient(monomialResult.getCoefficient() + monomial.getCoefficient());
                    else
                        result.getMonomials().remove(monomialResult);
                    found = 1;
                    break;
                }
                if (monomial.getPower() > monomialResult.getPower()) {
                    break;
                }
                index++;
            }
            if (found == 0) {
                result.getMonomials().add(index, monomial);
            }
        }
        return result;
    }

    public Polynomial subtract() {
        Polynomial result = new Polynomial();
        for (Monomial monomial : polynomial1.getMonomials()) {
            result.getMonomials().add(monomial);
        }
        for (Monomial monomial : polynomial2.getMonomials()) {
            int found = 0,index = 0;
            for (Monomial monomialResult : result.getMonomials()) {
                if (monomial.getPower() == monomialResult.getPower()) {
                    if (monomialResult.getCoefficient() - monomial.getCoefficient() != 0)
                        monomialResult.setCoefficient(monomialResult.getCoefficient() - monomial.getCoefficient());
                    else
                        result.getMonomials().remove(monomialResult);
                    found = 1;
                    break;
                }
                if (monomial.getPower() > monomialResult.getPower()) {
                    break;
                }
                index++;
            }
            if (found == 0) {
                monomial.setCoefficient((-1) * monomial.getCoefficient());
                result.getMonomials().add(index, monomial);
            }
        }
        return result;
    }

    public Polynomial multiply() {
        Polynomial result=new Polynomial();
        boolean first=true;
        for(Monomial monomial1:polynomial1.getMonomials()) {
            for(Monomial monomial2: polynomial2.getMonomials()) {
                Monomial res=new Monomial(monomial1.getCoefficient()*monomial2.getCoefficient(),monomial1.getPower()+monomial2.getPower());
                Polynomial newPoly=new Polynomial();
                newPoly.getMonomials().add(res);
                if(first){
                    result.getMonomials().add(res);
                    first=false;
                }else {
                    Operations operations = new Operations(result, newPoly);
                    result = operations.add();
                }
            }
        }
    return result;
    }
    public Polynomial derivative()
    {
        Polynomial result=new Polynomial();
        for(Monomial monomial: polynomial1.getMonomials()){
            if(monomial.getPower()!=0) {
                Monomial newMonomial = new Monomial(monomial.getPower() * monomial.getCoefficient(), monomial.getPower() - 1);
                result.getMonomials().add(newMonomial);
            }
        }
            return result;
    }
    public Polynomial integration()
    {
        Polynomial result=new Polynomial();
        for(Monomial monomial: polynomial1.getMonomials()){
                Monomial newMonomial = new Monomial(monomial.getCoefficient()/(monomial.getPower()+1), monomial.getPower()+1);
                result.getMonomials().add(newMonomial);
        }
        return result;
    }
    public ArrayList<Polynomial> division()
    {
        Polynomial dividend,divisor;
        if(polynomial1.getMonomials().get(0).getPower()>polynomial2.getMonomials().get(0).getPower()){
            dividend=polynomial1;
            divisor=polynomial2;
        }else{
            dividend=polynomial2;
            divisor=polynomial1;
        }
        Polynomial remainder=dividend;
        Polynomial quotient=new Polynomial();
        while(remainder.getMonomials().get(0).getPower()>=divisor.getMonomials().get(0).getPower()){
            Monomial newMonomial=new Monomial(remainder.getMonomials().get(0).getCoefficient()/divisor.getMonomials().get(0).getCoefficient(),remainder.getMonomials().get(0).getPower()-divisor.getMonomials().get(0).getPower());
            quotient.getMonomials().add(newMonomial);
            Polynomial oneMonomialPolynomial=new Polynomial();
            oneMonomialPolynomial.getMonomials().add(newMonomial);
            Operations op=new Operations(divisor,oneMonomialPolynomial);
            Polynomial newPolynomial= op.multiply();
            Operations op2=new Operations(remainder,newPolynomial);
            remainder=op2.subtract();
            if(dividend.getMonomials().size()==1 || remainder.getMonomials().isEmpty()){
                break;
            }
        }
        ArrayList<Polynomial> result=new ArrayList<Polynomial>();
        result.add(quotient);
        result.add(remainder);
        return result;
    }
}