package sample.Models;

public class Operations {
    private Polynomial polynomial1;
    private Polynomial polynomial2;
    public  Operations(Polynomial polynomial1,Polynomial polynomial2)
    {
        this.polynomial1=polynomial1;
        this.polynomial2=polynomial2;
    }
    public Polynomial add(){
        Polynomial result =new Polynomial();
        for(Monomial monomial: polynomial1.getMonomials()){
            result.getMonomials().add(monomial);
        }
        for(Monomial monomial: polynomial2.getMonomials()){
            int found=0;
            int index=-1;
            for(Monomial monomialResult: result.getMonomials()){
                index++;
                if(monomial.getPower()==monomialResult.getPower()){
                    if(monomialResult.getCoefficient()+monomial.getCoefficient()!=0)
                         monomialResult.setCoefficient(monomialResult.getCoefficient()+monomial.getCoefficient());
                    else
                        result.getMonomials().remove(monomialResult);
                    found=1;
                    break;
                }
                if(monomial.getPower()>monomialResult.getPower())
                {
                    break;
                }
            }
            if(found==0)
            {
                result.getMonomials().add(index,monomial);
            }
        }
        return result;
    }
    public Polynomial subtract(){
        Polynomial result =new Polynomial();
        for(Monomial monomial: polynomial1.getMonomials()){
            result.getMonomials().add(monomial);
        }
        for(Monomial monomial: polynomial2.getMonomials()){
            int found=0;
            int index=-1;
            for(Monomial monomialResult: result.getMonomials()){
                index++;
                if(monomial.getPower()==monomialResult.getPower()){
                    if(monomialResult.getCoefficient()-monomial.getCoefficient()!=0)
                        monomialResult.setCoefficient(monomialResult.getCoefficient()-monomial.getCoefficient());
                    else
                        result.getMonomials().remove(monomialResult);
                    found=1;
                    break;
                }
                if(monomial.getPower()>monomialResult.getPower())
                {
                    break;
                }
            }
            if(found==0)
            {
                monomial.setCoefficient((-1)*monomial.getCoefficient());
                result.getMonomials().add(index,monomial);
            }
        }
        return result;
    }
}

