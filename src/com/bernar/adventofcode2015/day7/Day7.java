package com.bernar.adventofcode2015.day7;

import com.bernar.adventofcode2015.FileInput;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day7 {
    public static void main(String[] args) {
        List<String> lines = FileInput.getInstance().readStringFromFile("input7.txt");
        List<Operation> operations = lines
                .stream()
                .map(Day7::fromString)
                .collect(Collectors.toList());

        Map<Variable, Value> solved = new HashMap<>();
        
        operations.forEach(System.out::println);
    }

    private static Operation fromString(String line) {
        String[] splitLine = line.split("->");

        String result = splitLine[1].trim();
        Operand resultOperand = operandFromString(result);

        String[] splitLeft = splitLine[0].split(" ");

        if (splitLeft.length == 3) {
            Operand op1 = operandFromString(splitLeft[0]);
            Operand op2 = operandFromString(splitLeft[2]);
            switch (splitLeft[1]) {
                case "RSHIFT":
                    return new RShift(op1, op2, resultOperand);
                case "LSHIFT":
                    return new LShift(op1, op2, resultOperand);
                case "AND":
                    return new And(op1, op2, resultOperand);
                case "OR":
                    return new Or(op1, op2, resultOperand);
            }
        } else if (splitLeft.length == 2) {
            Operand op = operandFromString(splitLeft[1]);
            return new Not(op, resultOperand);
        }
        Operand op = operandFromString(splitLeft[0]);
        return new Assign(op, resultOperand);
    }

    private static Operand operandFromString(String result) {
        return isNumeric(result) ? new Value(Integer.parseInt(result)) : new Variable(result);
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
