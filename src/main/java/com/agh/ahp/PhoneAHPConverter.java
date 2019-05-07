package com.agh.ahp;


import com.agh.jpa.Phone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneAHPConverter {
    private double minCost;
    private double maxCost;

    private int minYear;

    private double minDisplaySize;
    private double maxDisplaySize;

    private double minDisplayResolution;
    private double maxDisplayResolution;

    private String theOS;

    private double minRAM;

    private double minWeight;
    private double maxWeight;

    private double minBattery;

    private boolean amongCost(String price) {
        try {
            double p = Double.parseDouble(price);
            return (p >= minCost && p <= maxCost);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean amongWeight(String weight) {
        try {
            double w = Double.parseDouble(weight);
            return (w >= minWeight && w <= maxWeight);
        } catch (Exception e) {
            return false;
        }
    }


    private boolean isBiggerBattery(String battery) {
        try {
            double b = Double.parseDouble(battery);
            return b >= minBattery;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean moreRAM(String ram) {
        try {
            double r = Double.parseDouble(ram);
            return r >= minRAM;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isOS(String os) {
        return os.equals(theOS);
    }

    private boolean amongDisplayResolution(String displayResolution) {
        //TODO
        return false;
    }

    private boolean amongDisplaySize(String displaySize) {
        //TODO
        return false;
    }


    private boolean newer(String date) {
        //TODO
        return false;
    }

    public boolean[] getArrayOfTrues(Phone phone) {
        boolean array[] = new boolean[8];
        array[0] = amongCost(phone.getPrice());
        array[1] = newer(phone.getAnnouncedDate());
        array[2] = amongDisplaySize(phone.getDisplaySize());
        array[3] = amongDisplayResolution(phone.getDisplayResolution());
        array[4] = isOS(phone.getOS());
        array[5] = moreRAM(phone.getRAM());
        array[6] = amongWeight(phone.getWeight());
        array[7] = isBiggerBattery(phone.getBattery());
        return array;
    }

    //To powinno byc uzyte w jakiejs metodzie w PhoneController
    //ktora nastepnie ta macierz i wagi wykorzysta z AHP
    public boolean[][] getMatrixOfTrues(List<Phone> phones) {
        boolean matrix[][] = new boolean[phones.size()][8];
        for (int i = 0; i < phones.size(); i++) {
            matrix[i] = getArrayOfTrues(phones.get(i));
        }
        return matrix;
    }
}
