package com.company.сlevertec.comparator;

import com.company.сlevertec.model.Segment;

import java.util.Comparator;

public class SegmentSortByX1 implements Comparator<Segment> {
    // метод реализует возрастающую сортировку отрезков по коодинате Х второй точки отрезка
    @Override
    public int compare(Segment segment1, Segment segment2) {
        return segment1.getPeak()[1].getX() - (segment2.getPeak()[1].getX());
    }
}
