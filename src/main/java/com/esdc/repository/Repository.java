package com.esdc.repository;

import com.esdc.Specification;
import com.esdc.entity.Cube;

import java.util.Comparator;
import java.util.List;

public class Repository {
    private List<Cube> cubes;

    public Repository(List<Cube> cubes) {
        this.cubes = cubes;
    }

    public List<Cube> sort(Specification spec) {
        switch (spec) {
            case ID -> sortById(cubes);
            case NAME -> sortByName(cubes);
            case LENGTH -> sortByLength(cubes);
            case XCOORDINATE -> sortByFirstCoordinate(cubes);
            case YCOORDINATE -> sortBySecondCoordinate(cubes);
            case ZCOORDINATE -> sortByThirdCoordinate(cubes);
        }
        return cubes;
    }

    public void sortById(List<Cube> cubes) {
         cubes.sort(Comparator.comparingLong(Cube::getId));
    }

    public void sortByName(List<Cube> cubes) {
        cubes.sort(Comparator.comparing(Cube::getName));
    }

    public void sortByLength(List<Cube> cubes) {
        cubes.sort(Comparator.comparingDouble(Cube::getLength));
    }

    public void sortByFirstCoordinate(List<Cube> cubes){
        cubes.sort(Comparator.comparing(cube -> cube.getCentre().getX()));
    }

    public void sortBySecondCoordinate(List<Cube> cubes){
        cubes.sort(Comparator.comparing(cube -> cube.getCentre().getY()));
    }

    public void sortByThirdCoordinate(List<Cube> cubes){
        cubes.sort(Comparator.comparing(cube -> cube.getCentre().getZ()));
    }

    public List<Cube> getCubes() {
        return cubes;
    }
    public void addCube(Cube cube) {
        this.cubes.add(cube);
    }

}
