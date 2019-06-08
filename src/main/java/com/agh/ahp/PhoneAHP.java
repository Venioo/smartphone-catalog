package com.agh.ahp;


import com.agh.jpa.Phone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneAHP {

    public final int nrOfVariables = 5;
    public final int nrOfComparision = nrOfVariables * (nrOfVariables - 1) / 2;

    private double minCost;
    private double maxCost;

    private int minYear;

    private double minDisplaySize;
    private double maxDisplaySize;

    private String theOS;

    private double minRAM;

    private boolean amongCost(String price) {
        try {
            double p = Double.parseDouble(price);
            return (p >= minCost && p <= maxCost);
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


    private boolean amongDisplaySize(String displaySize) {
        //TODO
        return false;
    }


    private boolean newer(String date) {
        //TODO
        return false;
    }

    private boolean[] getArrayOfTrues(Phone phone) {
        boolean array[] = new boolean[nrOfVariables];
        array[0] = amongCost(phone.getPrice());
        array[1] = newer(phone.getAnnouncedDate());
        array[2] = amongDisplaySize(phone.getDisplaySize());
        array[3] = isOS(phone.getOS());
        array[4] = moreRAM(phone.getRAM());
        return array;
    }

    private boolean[][] getMatrixOfTrues(List<Phone> phones) {
        boolean matrix[][] = new boolean[phones.size()][nrOfVariables];
        for (int i = 0; i < phones.size(); i++) {
            matrix[i] = getArrayOfTrues(phones.get(i));
        }
        return matrix;
    }

    private double calculateValueOfPhone(boolean[] array, double[] weights) {
        double value = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                value += weights[i] * 100;
            }
        }
        return value;
    }

    private List<Integer> findBestPhones(boolean[][] matrix, double[] weights) {
        double[] phoneValue = new double[matrix.length];
        double bestValue = 0;
        for (int i = 0; i < phoneValue.length; i++) {
            phoneValue[i] = calculateValueOfPhone(matrix[i], weights);
            if (bestValue < phoneValue[i]) {
                bestValue = phoneValue[i];
            }
        }
        List<Integer> bestPhones = new ArrayList<>();
        for (int i = 0; i < phoneValue.length; i++) {
            if (phoneValue[i] == bestValue) {
                bestPhones.add(i);
            }
        }
        return bestPhones;
    }

    public List<Phone> findBestPhones(List<Phone> phones, double[] compareValues) {
        if (compareValues.length != nrOfComparision) {
            throw new IllegalArgumentException("Incorrect size of compareValues");
        }
        AHP ahp = new AHP(nrOfVariables);
        ahp.setPairwiseComparisonArray(compareValues);

        List<Integer> positionInList = findBestPhones(getMatrixOfTrues(phones), ahp.getWeights());

        List<Phone> bestPhones = new ArrayList<>();
        for (int i = 0; i < positionInList.size(); i++) {
            bestPhones.add(phones.get(positionInList.get(i)));
        }
        return bestPhones;
    }

    public static void main(String args[]) {
        double[] compareValues = new double[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            compareValues[i] = rand.nextDouble() * 9;
        }
        Phone p1 = new Phone();
        p1.setId(1);
        p1.setPrice("2000");
        p1.setAnnouncedDate("2015  September");
        p1.setDisplaySize("10.1 inches (~68.4% screen-to-body ratio)");
        p1.setOS("iOS");
        p1.setRAM("5 GB");
        p1.setBattery("Removable Li-Ion 4000 mAh battery");

        Phone p2 = new Phone();
        p2.setId(2);
        p2.setPrice("1000");
        p2.setAnnouncedDate("2015  September");
        p2.setDisplaySize("5.5 inches (~69.0% screen-to-body ratio)");
        p2.setOS("Android");
        p2.setRAM("2 GB");
        p2.setBattery("Non-removable Li-Ion battery");

        Phone p3 = new Phone();
        p3.setId(3);
        p3.setPrice("1000");
        p3.setAnnouncedDate("2015  September");
        p3.setDisplaySize("5.5 inches (~69.0% screen-to-body ratio)");
        p3.setOS("Android");
        p3.setRAM("2 GB");
        p3.setBattery("Non-removable Li-Ion battery");

        List<Phone> phones = new ArrayList<>();
        phones.add(p1);
        phones.add(p2);
        phones.add(p3);

        PhoneAHP phoneAHP = new PhoneAHP();
        phoneAHP.minCost = 1000;
        phoneAHP.maxCost = 1600;
        phoneAHP.minDisplaySize = 5.0;
        phoneAHP.maxDisplaySize = 6.0;
        phoneAHP.minYear = 2010;
        phoneAHP.minRAM = 2;
        phoneAHP.theOS = "iOS";

        List<Phone> best = phoneAHP.findBestPhones(phones, compareValues);
        for (Phone p : best) {
            System.out.println(p.getId());
        }
    }

}
