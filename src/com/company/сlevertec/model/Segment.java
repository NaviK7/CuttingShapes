package com.company.сlevertec.model;

import java.util.Arrays;

/*
 * Класс описывающий сущность отрезка.
 * Объекты этокго класса состоят из двух точек с координатами x и y.
 */
public class Segment {
    private final PointElement[] peak;

    public Segment() {
        peak = new PointElement[2];
        peak[0] = new PointElement();
        peak[1] = new PointElement();
    }

    public PointElement[] getPeak() {
        return peak;
    }

    @Override
    public String toString() {
        return Arrays.toString(peak) +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Segment segment = (Segment) o;
        return Arrays.equals(peak, segment.peak);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(peak);
    }
}
