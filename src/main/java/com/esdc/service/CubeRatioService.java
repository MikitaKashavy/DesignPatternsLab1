package com.esdc.service;

import com.esdc.entity.Cube;
import com.esdc.entity.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CubeRatioService {


    private static final Logger log = LoggerFactory.getLogger(CubeRatioService.class);

    public static double getCubeRatio(Cube cube) {
        log.trace("getCubeRatio");

        Point centre = cube.getCentre();

        if (isCrossingTwoAxis(cube, centre.getX(), centre.getY())) {
            return calculateCubeRatio(cube, centre.getX(), centre.getY());
        } else if (isCrossingTwoAxis(cube, centre.getY(), centre.getZ())) {
            return calculateCubeRatio(cube, centre.getZ(), centre.getY());
        } else if (isCrossingTwoAxis(cube, centre.getZ(), centre.getX())) {
            return calculateCubeRatio(cube, centre.getZ(), centre.getX());
        }
        return 1;
    }

    private static double calculateCubeRatio(Cube cube, double axis, double axis1) {
        log.trace("calculateCubeRatio");

        double realY = axis + cube.getLength() / 2;
        double realX = axis1 + cube.getLength() / 2;
        double realX1 = cube.getLength() - realX;
        double realY1 = cube.getLength() - realY;
        return (realX * realY) / (realX1 * realY1);
    }

    private static boolean isCrossingTwoAxis(Cube cube, double axis, double axis1) {
        log.trace("isCrossingTwoAxis");

        return axis + cube.getLength() / 2 > 0 && axis + cube.getLength() / 2 < 0
                && axis1 + cube.getLength() / 2 > 0 && axis1 + cube.getLength() / 2 < 0;
    }
}