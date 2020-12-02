package com.bernar.adventofcode2015;

import java.util.List;
import java.util.stream.Collectors;

public class Day2 {
    public static void main(String[] args) {
        List<String> content = FileInput.getInstance().readStringFromFile("input2.txt");
        List<Gift> gifts = content.stream()
                .map(giftString -> giftString.split("x"))
                .map(t -> new Gift(Integer.parseInt(t[0]), Integer.parseInt(t[1]), Integer.parseInt(t[2])))
                .collect(Collectors.toList());
        int totalWrap = gifts.stream()
                .map(Gift::wrap)
                .reduce(0, Integer::sum);

        int totalRibbon = gifts.stream()
                .map(Gift::minPerimeter)
                .reduce(0, Integer::sum);

        System.out.println(totalWrap);
        System.out.println(totalRibbon);


    }


    private static class Gift {

        private final int l;
        private final int w;
        private final int h;

        public Gift(int l, int w, int h) {
            this.l = l;
            this.w = w;
            this.h = h;
        }

        public int wrap() {
            return 2 * l * w + 2 * w * h + 2 * h * l + minSideSurface();
        }

        private int minSideSurface() {
            return (l * w < w * h) ? Math.min(l * w, h * l) : Math.min(w * h, h * l);
        }

        private int minPerimeter() {
            int max = (l > w) ? Math.max(l, h) : Math.max(w, h);
            return l + l + w + w + h + h - max - max + l * w * h;
        }
    }
}
