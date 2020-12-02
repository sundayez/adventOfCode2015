package com.bernar.adventofcode2015.day7;

public class Assign extends MonoOperation {

    public Assign(Operand op, Operand result) {
        this.op = op;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Assign{" +
                "op=" + op +
                ", result=" + result +
                '}';
    }

}
