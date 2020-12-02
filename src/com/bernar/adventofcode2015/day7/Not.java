package com.bernar.adventofcode2015.day7;

public class Not extends MonoOperation {

    public Not(Operand op, Operand result) {
        this.op = op;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Not{" +
                "op=" + op +
                ", result=" + result +
                '}';
    }
}
