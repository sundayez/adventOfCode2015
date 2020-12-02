package com.bernar.adventofcode2015.day7;

public class RShift extends BiOperation {
    public RShift(Operand op1, Operand op2, Operand result) {
        this.op1 = op1;
        this.op2 = op2;
        this.result = result;
    }

    @Override
    public String toString() {
        return "RShift{" +
                "op1=" + op1 +
                ", op2=" + op2 +
                ", result=" + result +
                '}';
    }
}
