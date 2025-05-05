package com.esdc.factory;

import com.esdc.entity.Point;
public class PointFactory implements Factory<Point> {
    private final double x;
    private final double y;
    private final double z;

    public PointFactory(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Point create() {
        return new Point(x, y, z);
    }
}

