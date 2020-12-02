package com.bernar.adventofcode2015;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day6 {
    public static void main(String[] args) {
        List<String> lines = FileInput.getInstance().readStringFromFile("input6.txt");
        List<Instruction> instructions = lines.stream()
                .map(instruction -> Arrays.asList(instruction.split(" ")))
                .map(Day6::parseTokens)
                .collect(Collectors.toList());

        System.out.println(part1(instructions));
        System.out.println(part2(instructions));
    }

    private static int part1(List<Instruction> instructions) {
        boolean[][] grid = new boolean[1000][1000];
        for (Instruction instruction : instructions) {
            for (int i = instruction.xMin; i <= instruction.xMax; i++) {
                for (int j = instruction.yMin; j <= instruction.yMax; j++) {
                    switch (instruction.instructionType) {
                        case TOGGLE -> grid[i][j] = !grid[i][j];
                        case TURN_ON -> grid[i][j] = true;
                        case TURN_OFF -> grid[i][j] = false;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (grid[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static BigInteger part2(List<Instruction> instructions) {
        BigInteger[][] grid = new BigInteger[1000][1000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                grid[i][j] = BigInteger.ZERO;
            }
        }
        for (Instruction instruction : instructions) {
            for (int i = instruction.xMin; i <= instruction.xMax; i++) {
                for (int j = instruction.yMin; j <= instruction.yMax; j++) {
                    switch (instruction.instructionType) {
                        case TOGGLE -> grid[i][j] = grid[i][j].add(BigInteger.valueOf(2));
                        case TURN_ON -> grid[i][j] = grid[i][j].add(BigInteger.valueOf(1));
                        case TURN_OFF -> grid[i][j] = (grid[i][j].compareTo(BigInteger.ONE) < 0) ? BigInteger.ZERO :
                            grid[i][j].subtract(BigInteger.valueOf(1));
                    }
                }
            }
        }
        BigInteger total = BigInteger.ZERO;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                total = total.add(grid[i][j]);
            }
        }
        return total;
    }

    private enum InstructionType {TURN_ON, TURN_OFF, TOGGLE}

    private static class Instruction {
        private final InstructionType instructionType;
        private final int xMin;
        private final int yMin;
        private final int xMax;
        private final int yMax;

        public Instruction(InstructionType instructionType, int x1, int y1, int x2, int y2) {
            this.instructionType = instructionType;
            this.xMin = Math.min(x1, x2);
            this.yMin = Math.min(y1, y2);
            this.xMax = Math.max(x1, x2);
            this.yMax = Math.max(y1, y2);
        }

        @Override
        public String toString() {
            return "Instruction{" +
                    "instructionType=" + instructionType +
                    ", xMin=" + xMin +
                    ", yMin=" + yMin +
                    ", xMax=" + xMax +
                    ", yMax=" + yMax +
                    '}';
        }
    }

    private static Instruction parseTokens(List<String> tokens) {
        if (tokens.get(0).equals("turn")) {
            String[] coord1 = tokens.get(2).split(",");
            String[] coord2 = tokens.get(4).split(",");
            int x1 = Integer.parseInt(coord1[0]);
            int y1 = Integer.parseInt(coord1[1]);
            int x2 = Integer.parseInt(coord2[0]);
            int y2 = Integer.parseInt(coord2[1]);
            return new Instruction(tokens.get(1).equals("on") ? InstructionType.TURN_ON : InstructionType.TURN_OFF, x1, y1, x2, y2);
        }
        String[] coord1 = tokens.get(1).split(",");
        String[] coord2 = tokens.get(3).split(",");
        int x1 = Integer.parseInt(coord1[0]);
        int y1 = Integer.parseInt(coord1[1]);
        int x2 = Integer.parseInt(coord2[0]);
        int y2 = Integer.parseInt(coord2[1]);
        return new Instruction(InstructionType.TOGGLE, x1, y1, x2, y2);

    }

}
