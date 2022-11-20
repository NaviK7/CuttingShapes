package com.company.сlevertec.comparator;

import com.company.сlevertec.model.Segment;

import java.util.Comparator;

/*
 * Класс-имплементация, реализующий метод сортировки класса Comparator
 */
public class SegmentSortByY implements Comparator<Segment> {
    // метод реализует возрастающую сортировку отрезков по коодинате Y  первой точки отрезка
    @Override
    public int compare(Segment segment1, Segment segment2) {
        return segment1.getPeak()[0].getY() - (segment2.getPeak()[0].getY());
    }
}
