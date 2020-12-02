package com.bernar.adventofcode2015;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Day3 {
    public static void main(String[] args) {
        String hints = FileInput.getInstance().readStringFromFile("input3.txt").get(0);
        System.out.println(santaClausTrip(hints).keySet().size());
        System.out.println(santaClausTrip("^>v<").keySet().size());
        System.out.println(santaClausAndRobotTrip(hints).keySet().size());
        System.out.println(santaClausAndRobotTrip("^>v<").keySet().size());

    }

    private static @NotNull
    Map<Position, Void> santaClausTrip(String hints) {
        int x = 0;
        int y = 0;
        Map<Position, Void> visited = new HashMap<>();
        visited.put(new Position(x, y), null);
        for (int i = 0; i < hints.length(); i++) {
            switch (hints.charAt(i)) {
                case '>' -> x++;
                case '<' -> x--;
                case '^' -> y++;
                case 'v' -> y--;
            }
            visited.put(new Position(x, y), null);
        }
        return visited;
    }

    private static @NotNull
    Map<Position, Void> santaClausAndRobotTrip(String hints) {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        Map<Position, Void> visited = new HashMap<>();
        visited.put(new Position(x1, y1), null);
        for (int i = 0; i < hints.length(); i+=2) {
            switch (hints.charAt(i)) {
                case '>' -> x1++;
                case '<' -> x1--;
                case '^' -> y1++;
                case 'v' -> y1--;
            }
            visited.put(new Position(x1, y1), null);
            switch (hints.charAt(i+1)) {
                case '>' -> x2++;
                case '<' -> x2--;
                case '^' -> y2++;
                case 'v' -> y2--;
            }
            visited.put(new Position(x2, y2), null);
        }
        return visited;
    }

    private static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x &&
                    y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
