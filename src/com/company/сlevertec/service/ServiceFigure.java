package com.company.сlevertec.service;

import com.company.сlevertec.comparator.SegmentSortByX;
import com.company.сlevertec.comparator.SegmentSortByY;
import com.company.сlevertec.model.Figure;
import com.company.сlevertec.model.PointElement;
import com.company.сlevertec.model.Segment;
import com.company.сlevertec.repository.RepositoryFigureSKF;
import com.company.сlevertec.repository.RepositorySegmentSKL;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Класс, отвечающий за обработку данных и  реализацию логики поставленной  условием задачи.
 */
public class ServiceFigure {
    private final RepositorySegmentSKL repositorySegmentSKL = new RepositorySegmentSKL();
    private final RepositoryFigureSKF repositoryFigureSKF = new RepositoryFigureSKF();

    /*
     * Метод преобразования координат фигуры из СКФ в СКЛ.
     * Воззвращает новый список с преобразованными  кординатами в СКЛ фигур.
     */
    public List<Figure> getFigureSKL() {
        List<Figure> figureListSKL = new ArrayList<>();
        for (int i = 0; i < repositoryFigureSKF.getFigureSKF().size(); i++) {
            Figure figureSKL = new Figure();
            for (int k = 0; k < repositoryFigureSKF.getFigureSKF().get(i).getPeak().length; k++) {
                figureSKL.getPeak()[k].setX(repositoryFigureSKF.getFigureSKF().get(i).getPeak()[k].getX() +
                        repositoryFigureSKF.startingPointsFigure().get(i).getX());
                figureSKL.getPeak()[k].setY(repositoryFigureSKF.getFigureSKF().get(i).getPeak()[k].getY() +
                        repositoryFigureSKF.startingPointsFigure().get(i).getY());
            }
            figureListSKL.add(figureSKL);
        }
        return figureListSKL;
    }

    /*
     * Метод преобразования координат фигуры из СКФ в СКЛ.
     * Воззвращает новый список с преобразованными  кординатами в СКЛ фигур.
     */
    public List<Figure> getFromMapFigureSKL() {
        List<Figure> figureListSKL = new ArrayList<>();
        int k = 0;
        for (Map.Entry<Figure, PointElement> figureListSKF : repositoryFigureSKF.getMapFigureSKF().entrySet()) {
            Figure figureSKL = new Figure();
            while (k < 4) {
                figureSKL.getPeak()[k].setX(figureListSKF.getKey().getPeak()[k].getX() + figureListSKF.getValue().getX());
                figureSKL.getPeak()[k].setY(figureListSKF.getKey().getPeak()[k].getY() + figureListSKF.getValue().getY());
                k++;
            }
            figureListSKL.add(figureSKL);
            k = 0;
        }
        return figureListSKL;
    }

    /*
     * Метод преобразования  фигуры в отрезки.
     * Воззвращает  список отрезков полученых из списка фигур в СКЛ.
     */
    public List<Segment> getSegmentFromFigure() {
        List<Segment> segmentListFromFigure = new ArrayList<>();
        for (int i = 0; i < getFigureSKL().size(); i++) {
            for (int k = 0; k < getFigureSKL().get(i).getPeak().length; k--) {
                Segment segment = new Segment();
                for (int j = 0; j < segment.getPeak().length; j++) {
                    if (k != 4) {
                        segment.getPeak()[j].setX(getFigureSKL().get(i).getPeak()[k].getX());
                        segment.getPeak()[j].setY(getFigureSKL().get(i).getPeak()[k].getY());
                    }
                    if (k == 4) {
                        segment.getPeak()[1].setX(getFigureSKL().get(i).getPeak()[0].getX());
                        segment.getPeak()[1].setY(getFigureSKL().get(i).getPeak()[0].getY());
                    }
                    k++;
                }
                segmentListFromFigure.add(segment);
            }
        }
        return segmentListFromFigure;
    }

    /*
     * Метод нахождения отрезков , которые налаживаются друг на друга полностью.
     * Воззвращает  список этих отрезков.
     */
    public List<Segment> getCrossSegments() {
        List<Segment> listCrossSegments = new ArrayList<>();
        for (int i = 0; i < repositorySegmentSKL.getSegmentListSKL().size(); i++) {
            for (int k = 0; k < getSegmentFromFigure().size(); k++) {
                if (repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[0].getX() == (getSegmentFromFigure().get(k).getPeak()[0].getX()) &&
                        repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[1].getX() == (getSegmentFromFigure().get(k).getPeak()[1].getX()) &&
                        Math.abs(repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[0].getY() - repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[1].getY()) >=
                                Math.abs(getSegmentFromFigure().get(k).getPeak()[0].getY() - getSegmentFromFigure().get(k).getPeak()[1].getY()) &&
                        Math.min(repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[0].getY(), repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[1].getY()) <=
                                Math.min(getSegmentFromFigure().get(k).getPeak()[0].getY(), getSegmentFromFigure().get(k).getPeak()[1].getY()) &&
                        Math.max(getSegmentFromFigure().get(k).getPeak()[0].getY(), getSegmentFromFigure().get(k).getPeak()[1].getY()) <=
                                Math.max(repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[0].getY(), repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[1].getY())) {
                    listCrossSegments.add(getSegmentFromFigure().get(k));
                } else if (repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[0].getX() == (getSegmentFromFigure().get(i).getPeak()[0].getX()) &&
                        repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[1].getX() == (getSegmentFromFigure().get(i).getPeak()[1].getX()) &&
                        Math.abs(repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[0].getY() - repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[1].getY()) <=
                                Math.abs(getSegmentFromFigure().get(k).getPeak()[0].getY() - getSegmentFromFigure().get(k).getPeak()[1].getY()) &&
                        Math.min(repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[0].getY(), repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[1].getY()) >=
                                Math.min(getSegmentFromFigure().get(k).getPeak()[0].getY(), getSegmentFromFigure().get(k).getPeak()[1].getY()) &&
                        Math.max(getSegmentFromFigure().get(k).getPeak()[0].getY(), getSegmentFromFigure().get(k).getPeak()[1].getY()) >=
                                Math.max(repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[0].getY(), repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[1].getY())) {
                    listCrossSegments.add(repositorySegmentSKL.getSegmentListSKL().get(i));
                } else if (repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[0].getY() == (getSegmentFromFigure().get(k).getPeak()[0].getY()) &&
                        repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[1].getY() == (getSegmentFromFigure().get(k).getPeak()[1].getY()) &&
                        Math.abs(repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[0].getX() - repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[1].getX()) >=
                                Math.abs(getSegmentFromFigure().get(k).getPeak()[0].getX() - getSegmentFromFigure().get(k).getPeak()[1].getX()) &&
                        Math.min(repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[0].getX(), repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[1].getX()) <=
                                Math.min(getSegmentFromFigure().get(k).getPeak()[0].getX(), getSegmentFromFigure().get(k).getPeak()[1].getX()) &&
                        Math.max(getSegmentFromFigure().get(k).getPeak()[0].getX(), getSegmentFromFigure().get(k).getPeak()[1].getX()) <=
                                Math.max(repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[0].getX(), repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[1].getX())) {
                    listCrossSegments.add(getSegmentFromFigure().get(k));
                } else if (repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[0].getY() == (getSegmentFromFigure().get(k).getPeak()[0].getY()) &&
                        repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[1].getY() == (getSegmentFromFigure().get(k).getPeak()[1].getY()) &&
                        Math.abs(repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[0].getX() - repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[1].getX()) <=
                                Math.abs(getSegmentFromFigure().get(k).getPeak()[0].getX() - getSegmentFromFigure().get(k).getPeak()[1].getX()) &&
                        Math.min(repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[0].getX(), repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[1].getX()) >=
                                Math.min(getSegmentFromFigure().get(k).getPeak()[0].getX(), getSegmentFromFigure().get(k).getPeak()[1].getX()) &&
                        Math.max(getSegmentFromFigure().get(k).getPeak()[0].getX(), getSegmentFromFigure().get(k).getPeak()[1].getX()) >=
                                Math.max(repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[0].getX(), repositorySegmentSKL.getSegmentListSKL().get(i).getPeak()[1].getX())) {
                    listCrossSegments.add(repositorySegmentSKL.getSegmentListSKL().get(i));
                }
            }
        }
        return listCrossSegments.stream().distinct().collect(Collectors.toList());
    }

    /*
     * Метод , возвращающий суммарный список из списка отрезков из фигур СКЛ и
     * списка отрезков заданных в условии задачи.
     */
    public List<Segment> getCommonSegments() {
        List<Segment> commonSegmentsList = new ArrayList<>();
        commonSegmentsList.addAll(repositorySegmentSKL.getSegmentListSKL());
        commonSegmentsList.addAll(getSegmentFromFigure());
        return commonSegmentsList;
    }

    /*
     * Метод, возвращающий  общий список отрезков без отрезков,
     * которые накладываются друг на друга.
     */
    public List<Segment> getCommonWithoutCrossSegments() {
        //создаем лист, в который записываем лист полностью пересекаемых отреков без повторений
        List<Segment> segmentsList = new ArrayList<>(getCrossSegments());
        //создаем лист, в который записываем сумарный список отреков из исходных данных и списка отрезков полученных из фигур
        List<Segment> commonSegmentsList = new ArrayList<>(getCommonSegments());
        //выясняем какие элементы в списке отрезков повторяются больше двух раз и записываем их в отдельный список
        List<Segment> moreOne = new ArrayList<>();
        Map<Segment, Integer> map = new HashMap<>();
        for (Segment segment : commonSegmentsList) {
            map.put(segment, Collections.frequency(commonSegmentsList, segment));
        }
        for (Map.Entry<Segment, Integer> pair : map.entrySet()) {
            if (pair.getValue() > 1) {
                moreOne.add(pair.getKey());
            }
        }
        //добавляем в общий список список, полностью пересекающиеся отреков
        commonSegmentsList.addAll(segmentsList);
        /*
         * насколько я понял задачу,
         * если несколько  отрезков полностью равны,
         * то один нужно оставить
         * а если один отрезко накладывается на другой отрезок, то нужно оставить больший из них.
         * Эту проверку делаю для того, чтоб оставить тот отрезок,
         * который налживается  на отрезок из  фигуры полностью  и при этом поторяется.
         * При удалении из общего списка списка полностью пересекающися отрезков,
         * удалятся все равные отрезки из двух списков, но так как из тех отреков,
         * которых несколько, нужно оставить один,
         * то я добавляю его потом снова в список
         */
        if (segmentsList.containsAll(moreOne)) {
            commonSegmentsList.removeAll(segmentsList);
            commonSegmentsList.addAll(moreOne);
        }
        return commonSegmentsList;
    }

    /*
     * Метод сортирует список отрезков по координате  x и y первой точки каждого отрезка из списка и
     * возращает отсортированный список.
     */
    public List<Segment> getSortCommonSegmentsX0Y0() {
        List<Segment> segmentList = new ArrayList<>(getCommonWithoutCrossSegments());
        segmentList.sort(new SegmentSortByX().thenComparing(new SegmentSortByY()));
        return segmentList;
    }

    /*
     * Метод возвращает минимальное расстояние  из всех расстояний меджду присланными координатами точки и
     * точками отрезков, которые входят в присланный список отрезков.
     */
    public int getMinDistance(int x, int y, List<Segment> segmentList) {
        List<Integer> distanceList = new ArrayList<>();
        int distance;
        for (Segment segment : segmentList) {
            for (int k = 0; k < segment.getPeak().length; k++) {
                distance = (int) Math.sqrt(Math.pow(segment.getPeak()[k].getX() - x, 2) +
                        Math.pow(segment.getPeak()[k].getY() - y, 2));
                distanceList.add(distance);
            }
        }
        return Collections.min(distanceList);
    }

    /* Метод возвращает отрезок из присланного списка отрезков,
     * одна из  точек которого находятся ближе всего к концевой точке присланого отрезка.
     * При чем  координаты возвращаемого отрезка записываются в нужном порядке ,
     * чтоб движение резца проходило по кратчайшему пути
     * от концевой точки присланого отрезка к
     *  начальной точке возвращаемого отрезка.
     */
    public Segment getNextSegmentByMinDistance(Segment segment, List<Segment> segmentList) {
        Segment segmentNext = new Segment();
        int distance;
        int x0 = segment.getPeak()[1].getX();
        int y0 = segment.getPeak()[1].getY();
        for (int i = 0; i < segmentList.size(); i++) {
            for (int k = 0; k < segmentList.get(i).getPeak().length; k++) {
                distance = (int) Math.sqrt(Math.pow(segmentList.get(i).getPeak()[k].getX() - x0, 2) +
                        Math.pow(segmentList.get(i).getPeak()[k].getY() - y0, 2));
                if (distance == getMinDistance(x0, y0, segmentList)) {
                    if (k == 1) {
                        segmentNext.getPeak()[0].setX(segmentList.get(i).getPeak()[1].getX());
                        segmentNext.getPeak()[0].setY(segmentList.get(i).getPeak()[1].getY());
                        segmentNext.getPeak()[1].setX(segmentList.get(i).getPeak()[0].getX());
                        segmentNext.getPeak()[1].setY(segmentList.get(i).getPeak()[0].getY());
                    } else if (k == 0) {
                        segmentNext.getPeak()[0].setX(segmentList.get(i).getPeak()[0].getX());
                        segmentNext.getPeak()[0].setY(segmentList.get(i).getPeak()[0].getY());
                        segmentNext.getPeak()[1].setX(segmentList.get(i).getPeak()[1].getX());
                        segmentNext.getPeak()[1].setY(segmentList.get(i).getPeak()[1].getY());
                    }
                    break;
                }
            }
        }
        return segmentNext;
    }

    /*
     * Метод возвращает список отрезков в порядке,
     * который задаст  движение резца по кратчайшей траектории
     * от концевой точки предыдущего отрезка к
     * начальной точке последующего отреза.
     */
    public List<Segment> getListSegmentSortedByDistance() {
        //создаем новый список, в который записываем  список отсортировнный по х и у
        List<Segment> segmentList = new ArrayList<>(getSortCommonSegmentsX0Y0());
        //создаем взвращаемый список, в который будем записывать орезки по нужному порядку
        List<Segment> listSegmentSortedByDistance = new ArrayList<>();
        /*
         * добавляем первый элемент отсортированнаго по х и у списка,  в возвращаемый список,
         * т.к. начальные координаты этого отрезка расположены ближе всего к начальному положеию резца
         */
        listSegmentSortedByDistance.add(segmentList.get(0));
        //затем удаляем этот отезок, чтоб не учитывать его в последующем поиске нужного отрека
        segmentList.remove(0);
        /*
         * так как начальный отрезок был удален из нового списка,
         * то при поиске следующего нужного отрезка вновь обращаемся  к списку, отсортировнному по х и у,
         * забираем у него начальный отрезок и отправляем его вместе с новым списоком откуда он был удален
         * в метод по поику следующего отрезка.
         */
        Segment segmentNext = getNextSegmentByMinDistance(getSortCommonSegmentsX0Y0().get(0), segmentList);
        // добавляем найденый отрезок в возвращаемый список отрезков
        listSegmentSortedByDistance.add(segmentNext);
        //удаляем этот отрезок из нового списка, чтоб не учитывать его в последующем поиске нужного отрека
        segmentList.remove(segmentNext);
        // так как первый и второй отрезки найдены, то остальный можно находить по циклу
        while (segmentList.size() != 0) {
            segmentNext = getNextSegmentByMinDistance(segmentNext, segmentList);
            int indexDelete = 0;
            /*
             * так как найденный следующий отрезок может прийти с перевернутыми точками,
             * то для того чтоб его удалить проверяем его на эквивалентность со своим начальным положением и
             * в случае совпадения, удаляем его, чтоб не учитывать его в последующем поиске нужного отрезка
             */
            for (Segment segment : segmentList) {
                if (segment.getPeak()[0].getX() == (segmentNext.getPeak()[0].getX()) &&
                        segment.getPeak()[0].getY() == (segmentNext.getPeak()[0].getY()) &&
                        segment.getPeak()[1].getX() == (segmentNext.getPeak()[1].getX()) &&
                        segment.getPeak()[1].getY() == (segmentNext.getPeak()[1].getY()) ||
                        segment.getPeak()[0].getX() == (segmentNext.getPeak()[1].getX()) &&
                                segment.getPeak()[0].getY() == (segmentNext.getPeak()[1].getY()) &&
                                segment.getPeak()[1].getX() == (segmentNext.getPeak()[0].getX()) &&
                                segment.getPeak()[1].getY() == (segmentNext.getPeak()[0].getY())) {
                    indexDelete = segmentList.indexOf(segment);
                }
            }
            segmentList.remove(indexDelete);
            listSegmentSortedByDistance.add(segmentNext);
        }
        return listSegmentSortedByDistance;
    }
}




