package com.bernar.adventofcode2015.day7;

public class Value extends Operand {
    private int value;

    public Value(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Value{" +
                "value=" + value +
                '}';
    }
}
