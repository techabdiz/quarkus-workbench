package org.packaege.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appearance {
    private Integer id;
    private String name;
    private Double height;
    private Double weight;
    private String skinColor;
}
