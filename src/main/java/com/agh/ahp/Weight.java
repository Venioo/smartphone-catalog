package com.agh.ahp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Weight {
    private Parameter firstParameter;
    private Parameter secondParameter;
    private String weight;

    public boolean contains(String code) {
        return firstParameter.getCode().equals(code) || secondParameter.getCode().equals(code);
    }

    public double getMinValue(String code) {
        if (firstParameter.getCode().equals(code)) {
            return Double.parseDouble(firstParameter.getValueMin());
        }
        if (secondParameter.getCode().equals(code)) {
            return Double.parseDouble(secondParameter.getValueMin());
        }
        return 0;

    }

    public double getMaxValue(String code) {
        if (firstParameter.getCode().equals(code)) {
            return Double.parseDouble(firstParameter.getValueMax());
        }
        if (secondParameter.getCode().equals(code)) {
            return Double.parseDouble(secondParameter.getValueMax());
        }
        return 1000000;
    }

    public String getOS(String code) {
        if (firstParameter.getCode().equals(code)) {
            return firstParameter.getValueMin();
        }
        if (secondParameter.getCode().equals(code)) {
            return secondParameter.getValueMin();
        }
        return "";
    }
}
