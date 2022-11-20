package com.company.сlevertec.comparator;

import com.company.сlevertec.model.Segment;

import java.util.Comparator;

/*
 * Класс-имплементация, реализующий метод сортировки класса Comparator
 */
public class SegmentSortByX implements Comparator<Segment> {
    // метод реализует возрастающую сортировку отрезков по коодинате Х первой точки отрезка
    @Override
    public int compare(Segment segment1, Segment segment2) {
        return segment1.getPeak()[0].getX() - (segment2.getPeak()[0].getX());
    }
}
