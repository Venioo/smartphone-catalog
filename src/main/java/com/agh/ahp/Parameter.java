package com.agh.ahp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parameter {
    private String code;
    private String name;
    private String valueMin;
    private String valueMax;
    private boolean checked;
}
