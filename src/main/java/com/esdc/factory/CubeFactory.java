package com.esdc.factory;


import com.esdc.entity.Cube;
import com.esdc.entity.Point;

public class CubeFactory implements Factory<Cube> {
    private final long id;
    private final String name;
    private final Point center;
    private final double length;

    public CubeFactory(long id, String name, Point center, double length) {
        this.id = id;
        this.name = name;
        this.center = center;
        this.length = length;
    }

    @Override
    public Cube create() {
        return new Cube(id, name, center, length);
    }
}

