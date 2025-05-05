package com.esdc.reader;

import com.esdc.entity.Cube;
import com.esdc.factory.CubeFactory;
import com.esdc.factory.PointFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

    private static final Logger log = LoggerFactory.getLogger(DataParser.class);

    public List<Cube> path() {
        log.info("Parsing data");

        List<String> lines = DataReader.readData();
        List<Cube> cubes = new ArrayList<>();
        for (String line : lines) {
            String[] arr = line.split(";");
            if(arr.length>=7){
                log.info("invalid line");
                continue;
            }
            PointFactory pointFactory = new PointFactory(Double.parseDouble(arr[0]),
                    Double.parseDouble(arr[1]), Double.parseDouble(arr[2]));
             cubes.add(new CubeFactory(Long.parseLong(arr[3]), arr[4] , pointFactory.create(), Integer.parseInt(arr[5]))
                     .create());
        }
        return cubes;
    }
}
