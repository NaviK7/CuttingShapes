package com.company.сlevertec.repository;

import com.company.сlevertec.model.Figure;
import com.company.сlevertec.model.PointElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Класс, хранящиий заданые в условии  задачи,
 * координаты фигур и координаты положения этих фигур в СКЛ
 */
public class RepositoryFigureSKF {

    // метод, возвращающий список фигур, данных в задаче
    public List<Figure> getFigureSKF() {
        List<Figure> figureList = new ArrayList<>();
        Figure figure1 = new Figure();
        figure1.getPeak()[0] = (new PointElement(0, 0));
        figure1.getPeak()[1] = (new PointElement(1470, 0));
        figure1.getPeak()[2] = (new PointElement(1200, 1000));
        figure1.getPeak()[3] = (new PointElement(0, 1000));

        Figure figure2 = new Figure();
        figure2.getPeak()[0] = (new PointElement(0, 0));
        figure2.getPeak()[1] = (new PointElement(1470, 0));
        figure2.getPeak()[2] = (new PointElement(1200, 1000));
        figure2.getPeak()[3] = (new PointElement(0, 1000));

        Figure figure3 = new Figure();
        figure3.getPeak()[0] = (new PointElement(15, 0));
        figure3.getPeak()[1] = (new PointElement(1485, 0));
        figure3.getPeak()[2] = (new PointElement(1485, 1000));
        figure3.getPeak()[3] = (new PointElement(285, 1000));

        Figure figure4 = new Figure();
        figure4.getPeak()[0] = (new PointElement(0, 0));
        figure4.getPeak()[1] = (new PointElement(798, 0));
        figure4.getPeak()[2] = (new PointElement(798, 1485));
        figure4.getPeak()[3] = (new PointElement(0, 1000));

        Figure figure5 = new Figure();
        figure5.getPeak()[0] = (new PointElement(0, 0));
        figure5.getPeak()[1] = (new PointElement(798, 0));
        figure5.getPeak()[2] = (new PointElement(798, 1200));
        figure5.getPeak()[3] = (new PointElement(0, 1485));

        Figure figure6 = new Figure();
        figure6.getPeak()[0] = (new PointElement(15, 0));
        figure6.getPeak()[1] = (new PointElement(685, 0));
        figure6.getPeak()[2] = (new PointElement(600, 735));
        figure6.getPeak()[3] = (new PointElement(150, 735));

        Collections.addAll(figureList, figure1, figure2, figure3, figure4, figure5, figure6);
        return figureList;
    }

    // метод, возвращающий список координат положения  фигур в СКЛ, данных в задаче
    public List<PointElement> startingPointsFigure() {
        List<PointElement> startingPointsFigure = new ArrayList<>();
        PointElement startingPointFigure1 = new PointElement(15, 15);
        PointElement startingPointFigure2 = new PointElement(15, 1015);
        PointElement startingPointFigure3 = new PointElement(15, 2015);
        PointElement startingPointFigure4 = new PointElement(3991, 15);
        PointElement startingPointFigure5 = new PointElement(3991, 1515);
        PointElement startingPointFigure6 = new PointElement(2550, 2015);
        startingPointsFigure.add(startingPointFigure1);
        startingPointsFigure.add(startingPointFigure2);
        startingPointsFigure.add(startingPointFigure3);
        startingPointsFigure.add(startingPointFigure4);
        startingPointsFigure.add(startingPointFigure5);
        startingPointsFigure.add(startingPointFigure6);
        return startingPointsFigure;
    }
}