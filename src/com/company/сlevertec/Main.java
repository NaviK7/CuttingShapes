package com.company.сlevertec;

import com.company.сlevertec.repository.RepositoryFigureSKF;
import com.company.сlevertec.service.ServiceFigure;

public class Main {
    public static void main(String[] args) {

        ServiceFigure serviceFigure = new ServiceFigure();
//        RepositoryFigureSKF repositoryFigureSKF = new RepositoryFigureSKF();
//        System.out.println(repositoryFigureSKF.getMapFigureSKF());

//        System.out.println(serviceFigure.getFigureSKL());
//        RepositorySegmentSKL repositorySegmentSKL = new RepositorySegmentSKL();
//        System.out.println(repositorySegmentSKL.getSegmentListSKL());
       // System.out.println(serviceFigure.getSortCommonSegmentsX0Y0());
        // System.out.println(serviceFigure.getCrossSegments());
        // System.out.println(serviceFigure.getCommonSegments());
        // System.out.println(serviceFigure.getCommonWithoutCrossSegments());
         System.out.println(serviceFigure.getListSegmentSortedByDistance());
        //System.out.println(serviceFigure.getSortCommonSegmentsX1());
//        List<Segment> segmentsList = new ArrayList<>(CrossSegmentsSingleton.instance(null).getListCrossSegments()).stream().distinct().collect(Collectors.toList());
//        System.out.println(segmentsList);


    }

}
