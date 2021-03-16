package sample.Models;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sample.Controller;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OperationsTest {

    @ParameterizedTest
    @MethodSource("provideInputAddition")
    void testAddition(String s1,String s2,String expectedString){
        Polynomial p1= Polynomial.getPolynomial(s1);
        Polynomial p2=Polynomial.getPolynomial(s2);
        Polynomial expectedResult=Polynomial.getPolynomial(expectedString);
        Operations operations=new Operations(p1,p2);
        assertEquals(expectedResult,operations.add());
    }
    private static List<Arguments> provideInputAddition(){
        List<Arguments>argumentsList=new ArrayList<>();
        argumentsList.add(Arguments.of("x^3-3*x^2+14*x-5","-2*x^3+5*x^2+10","-x^3+2*x^2+14*x+5"));
        argumentsList.add(Arguments.of("4*x^5-3*x^4+x^2-8*x+1","3*x^4-x^3+x^2+2*x-1","4*x^5-x^3+2*x^2-6*x"));
        argumentsList.add(Arguments.of("x^66","-3","x^66-3"));
        argumentsList.add(Arguments.of("x^4-7*x^3+4*x^2-8*x","-x^4+4*x^2-11","-7*x^3+8*x^2-8*x-11"));
        argumentsList.add(Arguments.of("x","-x","0"));
        return argumentsList;
    }

    @ParameterizedTest
    @MethodSource("provideInputSubtraction")
    void testSubtraction(String s1,String s2,String expectedString){
        Polynomial p1= Polynomial.getPolynomial(s1);
        Polynomial p2=Polynomial.getPolynomial(s2);
        Polynomial expectedResult=Polynomial.getPolynomial(expectedString);
        Operations operations=new Operations(p1,p2);
        assertEquals(expectedResult,operations.subtract());
    }
    private static List<Arguments> provideInputSubtraction(){
        List<Arguments>argumentsList=new ArrayList<>();
        argumentsList.add(Arguments.of("x^3-3*x^2+14*x-5","-2*x^3+5*x^2+10","3*x^3-8*x^2+14*x-15"));
        argumentsList.add(Arguments.of("4*x^5-3*x^4+x^2-8*x+1","3*x^4-x^3+x^2+2*x-1","4*x^5-6*x^4+x^3-10*x+2"));
        argumentsList.add(Arguments.of("x^66","-3","x^66+3"));
        argumentsList.add(Arguments.of("x^4-7*x^3+4*x^2-8*x","-x^4+4*x^2-11","2*x^4-7*x^3-8*x+11"));
        argumentsList.add(Arguments.of("x^2+x-1","x^2+x-1","0"));
        argumentsList.add(Arguments.of("0","0","0"));
        return argumentsList;
    }
    @ParameterizedTest
    @MethodSource("provideInputMultiplication")
    void testMultiplication(String s1,String s2,String expectedString){
        Polynomial p1= Polynomial.getPolynomial(s1);
        Polynomial p2=Polynomial.getPolynomial(s2);
        Polynomial expectedResult=Polynomial.getPolynomial(expectedString);
        Operations operations=new Operations(p1,p2);
        assertEquals(expectedResult,operations.multiply());
    }
    private static List<Arguments> provideInputMultiplication(){
        List<Arguments>argumentsList=new ArrayList<>();
        argumentsList.add(Arguments.of("-x^3+9*x^2+5*x-2","x^2-x-1","-x^5+10*x^4-3*x^3-16*x^2-3*x+2"));
        argumentsList.add(Arguments.of("1","x^2+5*x-11","x^2+5*x-11"));
        argumentsList.add(Arguments.of("x^2+5*x-11","-1","-x^2-5*x+11"));
        argumentsList.add(Arguments.of("0","0","0"));
        argumentsList.add(Arguments.of("x^2+5*x-11","0","0"));
        return argumentsList;
    }

    @ParameterizedTest
    @MethodSource("provideInputDerivative")
    void testDerivative(String s1,String expectedString){
        Polynomial p1= Polynomial.getPolynomial(s1);
        Polynomial expectedResult=Polynomial.getPolynomial(expectedString);
        Operations operations=new Operations(p1,null);
        assertEquals(expectedResult,operations.derivative());
    }
    private static List<Arguments> provideInputDerivative(){
        List<Arguments>argumentsList=new ArrayList<>();
        argumentsList.add(Arguments.of("-x^7+3*x^2-5*x-12","-7*x^6+6*x-5"));
        argumentsList.add(Arguments.of("10*x","10"));
        argumentsList.add(Arguments.of("x","1"));
        argumentsList.add(Arguments.of("10","0"));
        argumentsList.add(Arguments.of("0","0"));
        return argumentsList;
    }

    @ParameterizedTest
    @MethodSource("provideInputIntegration")
    void testIntegration(String s1,String expectedString){
        Polynomial p1= Polynomial.getPolynomial(s1);
        Polynomial expectedResult=Polynomial.getPolynomial(expectedString);
        Operations operations=new Operations(p1,null);
        assertEquals(expectedResult,operations.integration());
    }
    private static List<Arguments> provideInputIntegration(){
        List<Arguments>argumentsList=new ArrayList<>();
        argumentsList.add(Arguments.of("4*x^3+3*x^2+2*x+1","x^4+x^3+x^2+x"));
        argumentsList.add(Arguments.of("3","3*x"));
        argumentsList.add(Arguments.of("0","0*x"));
        argumentsList.add(Arguments.of("-1","-x"));
        argumentsList.add(Arguments.of("5*x^4-3*x^2-2*x","x^5-x^3-x^2"));
        return argumentsList;
    }
    @ParameterizedTest
    @MethodSource("provideInputDivision")
    void testDivision(String s1,String s2,String exQuotient,String exRemainder){
        Polynomial p1= Polynomial.getPolynomial(s1);
        Polynomial p2=Polynomial.getPolynomial(s2);
        Polynomial expectedQuotient=Polynomial.getPolynomial(exQuotient);
        Polynomial expectedRemainder=Polynomial.getPolynomial(exRemainder);
        Operations operations=new Operations(p1,p2);
        ArrayList<Polynomial>actualResult=operations.division();
        assertEquals(expectedQuotient,actualResult.get(0));
        assertEquals(expectedRemainder,actualResult.get(1));
    }
    private static List<Arguments> provideInputDivision(){
        List<Arguments>argumentsList=new ArrayList<>();
        argumentsList.add(Arguments.of("x^3-2*x^2+6*x-5","x^2-1","x-2","7*x-7"));
        argumentsList.add(Arguments.of("x^2+1","x^2+1","1","0"));
        argumentsList.add(Arguments.of("x^3-x","x","x^2-1","0"));
        argumentsList.add(Arguments.of("3*x^3-5*x^2+4","x^2","3*x-5","4"));
        return argumentsList;
    }

}