package com.agh.ahp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    private double setOneWeight(Weight w, String firstParameterCode, String secondParameterCode) {
        if (w.contains(secondParameterCode)) {
            return w.containsOnFirst(firstParameterCode) ? w.getPwCWeight() : w.getInversPwCWeight();
        } else {
            return 9;
        }
    }

    public double[] setWeights() {
        double[] comparedWeights = new double[10];
        //just for safe
        for (int i = 0; i < 10; i++) {
            comparedWeights[i] = 1;
        }

        for (Weight w : weightList) {
            if (w.contains("price")) {
                comparedWeights[0] = setOneWeight(w, "price", "announcedDate");
                comparedWeights[1] = setOneWeight(w, "price", "displaySize");
                comparedWeights[2] = setOneWeight(w, "price", "os");
                comparedWeights[3] = setOneWeight(w, "price", "ram");
            } else if (w.contains("announcedDate")) {
                comparedWeights[4] = setOneWeight(w, "announcedDate", "displaySize");
                comparedWeights[5] = setOneWeight(w, "announcedDate", "os");
                comparedWeights[6] = setOneWeight(w, "announcedDate", "ram");
            } else if (w.contains("displaySize")) {
                comparedWeights[7] = setOneWeight(w, "displaySize", "os");
                comparedWeights[8] = setOneWeight(w, "displaySize", "ram");
            } else if (w.contains("os")) {
                comparedWeights[9] = setOneWeight(w, "os", "ram");
            }
        }
        return comparedWeights;
    }
}
