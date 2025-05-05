package com.esdc.service;

import com.esdc.entity.Cube;
import com.esdc.entity.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CubeRatioServiceTest {

    @Test
    void testGetCubeRatio_CubeCrossingXY() {
        Cube cube = new Cube(1, "TestCube", new Point(-1, -1, 3), 4);
        assertEquals(1, CubeRatioService.getCubeRatio(cube), 0.001, "Неверное отношение частей для пересечения XY");
    }

    @Test
    void testGetCubeRatio_CubeCrossingYZ() {
        Cube cube = new Cube(1, "TestCube", new Point(3, -1, -1), 4);
        assertEquals(1, CubeRatioService.getCubeRatio(cube), 0.001, "Неверное отношение частей для пересечения YZ");
    }

    @Test
    void testGetCubeRatio_CubeCrossingZX() {
        Cube cube = new Cube(1, "TestCube", new Point(-1, 3, -1), 4);
        assertEquals(1, CubeRatioService.getCubeRatio(cube), 0.001, "Неверное отношение частей для пересечения ZX");
    }

    @Test
    void testGetCubeRatio_NoIntersection() {
        Cube cube = new Cube(1, "TestCube", new Point(5, 5, 5), 4);
        assertEquals(1, CubeRatioService.getCubeRatio(cube), 0.001, "Если нет пересечения, должно возвращаться 1");
    }
}
