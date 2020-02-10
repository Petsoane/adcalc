package com.calculator.adcalc.advanced.rpn;


import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Rpn implements RpnService
{
    public String solve(String rpn)  throws ArithmeticException, EmptyStackException
    {
        Stack<Double> stack = new Stack<>();

        for (String token : rpn.split("\\s+"))
        {
            System.out.println(token);
            switch (token)
            {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    double divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                case "%":
                    double div = stack.pop();
                    stack.push(stack.pop() % div);
                    break;
                case "^":
                    double exponent = stack.pop();
                    stack.push(Math.pow(stack.pop(), exponent));
                    break;
                case "a":
                    stack.push(Math.abs(stack.pop()));
                    break;
                case "l":
                    stack.push(Math.log10(stack.pop()));
                    break;
                case "s":
                    stack.push(Math.sin(stack.pop()));
                    break;
                case "t":
                    stack.push(Math.tan(stack.pop()));
                    break;
                case "c":
                    stack.push(Math.cos(stack.pop()));
                    break;
                case "r":
                    stack.push(Math.random());
                    break;
                case "!":
                      stack.push(factorial(stack.pop()));
                    break;

                default:
                    stack.push(Double.parseDouble(token));
                    break;
            }

        }
        double tmp = stack.pop();

        return isDecOrNot(tmp) ? String.valueOf(tmp): String.valueOf((int) tmp);
    }
    private double factorial(double val) {
        double tmp = (val - 0.5) * Math.log(val + 4.5) - (val + 4.5);
        double name = 1.0 + 76.18009173 / (val + 0) - 86.50532033 / (val + 1) + 24.01409822 / (val + 2) - 1.231739516 / (val + 3)
                + 0.00120858003 / (val + 4) - 0.00000536382 / (val + 5);


        tmp = val * (Math.exp(tmp + Math.log(name * Math.sqrt(2 * Math.PI))));
        return isDecOrNot(val) ? tmp : Math.ceil(tmp);
    }

    boolean isDecOrNot(double num){
       return num - (int) num != 0;
    }
}


