package com.calculator.adcalc.advanced;

public interface CalcService {
//    String solve(String equation);
    String quadSolver(double a, double b , double c);
    String trigSolver(double num, char op);
    String rpn(String input);
    boolean validate(String input);
    String preCalc(String input);
//    String simpleSolver();
}
