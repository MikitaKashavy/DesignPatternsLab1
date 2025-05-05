package com.esdc.warehouse;

import com.esdc.entity.Cube;
import com.esdc.service.CubeCalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Warehouse implements Observe {
    private static final Logger log = LoggerFactory.getLogger(Warehouse.class);
    private static Warehouse instance;
    private final Map<Long, Double> shapeAreaValues = new HashMap<>();
    private final Map<Long, Double> shapePerimetrValues = new HashMap<>();
    private final Map<Long, Double> shapeVolumeValues = new HashMap<>();


    private Warehouse() {
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    @Override
    public void update(Cube cube) {
        log.info("Updating " + cube.getName());
        long id = cube.getId();
        shapeAreaValues.put(id, CubeCalculationService.calculateArea(cube));
        shapePerimetrValues.put(id, CubeCalculationService.calculatePerimeter(cube));
        shapeVolumeValues.put(id, CubeCalculationService.calculateVolume(cube));
    }

    public Double getArea(int shapeId) {
        return shapeAreaValues.get(shapeId);
    }

    public Double getPerimeter(int shapeId) {
        return shapePerimetrValues.get(shapeId);
    }
    public Double getVolume(int shapeId) {
        return shapeVolumeValues.get(shapeId);
    }
}
