package com.bernar.adventofcode2015.day7;

public class Variable extends Operand {
    public Variable(String variable) {
        this.variable = variable;
    }

    private String variable;

    @Override
    public String toString() {
        return "Variable{" +
                "variable='" + variable + '\'' +
                '}';
    }
}

