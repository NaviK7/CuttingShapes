package com.company.сlevertec.repository;

import com.company.сlevertec.model.Segment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Класс, хранящиий заданные в условии  задачи,
 * координаты отрезков в СКЛ
 */
public class RepositorySegmentSKL {
    //список  координат отрезков в СКЛ, данных в задаче
    private final List<Integer> integerList = new ArrayList<>(Arrays.asList(
            15, 0, 15, 3210,
            6000, 15, 0, 15,
            1500, 0, 1500, 3210,
            15, 1015, 1500, 1015,
            15, 2015, 1500, 2015,
            15, 3015, 1500, 3015,
            2550, 0, 2550, 3210,
            1500, 1415, 2550, 1415,
            1500, 2815, 2550, 2815,
            3991, 0, 3991, 3210,
            2550, 515, 3991, 515,
            2550, 1015, 3991, 1015,
            2550, 1515, 3991, 1515,
            2550, 2015, 3991, 2015,
            2550, 2765, 3991, 2765,
            3250, 2015, 3250, 2765,
            4789, 0, 4789, 3210,
            3991, 1515, 4789, 1515,
            3991, 3015, 4789, 3015,
            5843, 0, 5843, 3210,
            4789, 1123, 5843, 1123,
            5316, 15, 5316, 1123
    ));

    //метод , создающий объекты отрезков по заданным координатам и возвращающий список полученных отрезков
    public List<Segment> getSegmentListSKL() {
        List<Segment> segmentList = new ArrayList<>();
        for (int i = 0; i < integerList.size() - 3; ) {
            Segment segment = new Segment();
            segment.getPeak()[0].setX(integerList.get(i));
            segment.getPeak()[0].setY(integerList.get(i + 1));
            segment.getPeak()[1].setX(integerList.get(i + 2));
            segment.getPeak()[1].setY(integerList.get(i + 3));
            segmentList.add(segment);
            i = i + 4;
        }
        return segmentList;
    }
}