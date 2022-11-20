package com.company.сlevertec.model;

import java.util.Arrays;

/*
 * Класс описывающий сущность фигуры.
 * Объекты этокго класса состоят из четырех точек с координатами x и y.
 */
public class Figure {
    private final PointElement[] peak;

    public Figure() {
        peak = new PointElement[4];
        peak[0] = (new PointElement());
        peak[1] = (new PointElement());
        peak[2] = (new PointElement());
        peak[3] = (new PointElement());
    }

    public PointElement[] getPeak() {
        return peak;
    }

    @Override
    public String toString() {
        return Arrays.toString(peak) +
                "}" + "\n";
    }
}
