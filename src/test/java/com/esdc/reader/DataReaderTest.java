package com.esdc.reader;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataReaderTest {

    String[] testData = {
            "10;20;30;1;Hello;5",
            "15;25;35;2;World;8",
            "20;30;40;3;Java;12",
            "25;35;45;4;Spring;6",
            "30;40;50;5;Filter;10",
            "35;45;55;6;Response;7"
    };

    @Test
    void testReadData_Success() {
        List<String> result = DataReader.readData();
        assertEquals(6, result.size());
        assertEquals(testData[0], result.get(0));
        assertEquals(testData[1], result.get(1));
        assertEquals(testData[2], result.get(2));
        assertEquals(testData[3], result.get(3));
        assertEquals(testData[4], result.get(4));
        assertEquals(testData[5], result.get(5));
    }

}
