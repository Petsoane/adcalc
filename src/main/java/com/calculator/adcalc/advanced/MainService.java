package com.calculator.adcalc.advanced;

import com.calculator.adcalc.advanced.precalc.PrecalcService;
import com.calculator.adcalc.advanced.quadratic.QuadService;
import com.calculator.adcalc.advanced.quadratic.QuadraticSolver;
import com.calculator.adcalc.advanced.rpn.RpnService;
import com.calculator.adcalc.advanced.trig.TrigService;
import com.calculator.adcalc.advanced.trig.TrigSolver;
import com.calculator.adcalc.advanced.validate.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Service
public class MainService implements CalcService {
    @Autowired
    private TrigService serveTrigSolver;
    @Autowired
    private QuadService serveQuadSolver;
    @Autowired
    private RpnService rpnService;
    @Autowired
    private ValidateService validateService;
    @Autowired
    private PrecalcService precalcService;

    @Override
    public String quadSolver(double a, double b, double c){
        return serveQuadSolver.solve(a, b, c);
    }
    @Override
    public String trigSolver(double num, char op){
       return serveTrigSolver.solve(num, op);
    }
    @Override
    public String rpn(String input){ return rpnService.solve(input);}
    @Override
    public boolean validate(String input){ return validateService.Check(input);}
    @Override
    public String preCalc(String input){ return precalcService.preCalc(input);}
}
