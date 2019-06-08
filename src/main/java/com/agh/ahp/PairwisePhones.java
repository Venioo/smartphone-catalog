package com.agh.ahp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PairwisePhones {
    private final static int max = 1000000;
    private List<Weight> weightList;
    private List<Long> phonesList;

    public double getMinCost() {
        for (Weight w : weightList) {
            if (w.contains("price")) {
                return w.getMinValue("price");
            }
        }
        return 0;
    }

    public double getMaxCost() {
        for (Weight w : weightList) {
            if (w.contains("price")) {
                return w.getMaxValue("price");
            }
        }
        return max;
    }

    public double getMinDisplay() {
        for (Weight w : weightList) {
            if (w.contains("displaySize")) {
                return w.getMinValue("displaySize");
            }
        }
        return 0;
    }

    public double getMaxDisplay() {
        for (Weight w : weightList) {
            if (w.contains("displaySize")) {
                return w.getMaxValue("displaySize");
            }
        }
        return max;
    }

    public int getMinYear() {
        for (Weight w : weightList) {
            if (w.contains("announcedDate")) {
                return (int) w.getMinValue("announcedDate");
            }
        }
        return 0;
    }

    public double getMinRam() {
        for (Weight w : weightList) {
            if (w.contains("ram")) {
                return w.getMinValue("ram");
            }
        }
        return 0;
    }

    public String getOS() {
        for (Weight w : weightList) {
            if (w.contains("os")) {
                return w.getOS("os");
            }
        }
        return "";
    }

    public double[] setWeights() {
        double[] comparedWeights = new double[10];
        /*
        "costToYear":"1",
        "costToDisplay":"1",
        "costToOS":"1",
        "costToRam":"1",
        "yearToDisplay":"1",
        "yearToOS":"1",
        "yearToRam":"1",
        "displayToOS":"1",
        "displayToRam":"1",
        "osToRam":"1"
        */
        for (Weight w : weightList) {

        }
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            comparedWeights[i] = rand.nextDouble() * 9;
        }
        return comparedWeights;
    }
}
