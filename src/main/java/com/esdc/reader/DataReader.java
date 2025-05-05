package com.esdc.reader;

import com.esdc.exception.InvalidPathException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private final static String DATA_PATH="..//src//main//resources//cube_data.txt";
    private static final Logger log = LoggerFactory.getLogger(DataReader.class);

    public static List<String> readData(){
        log.info("Reading data from file");

        List<String> lines = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(DATA_PATH))){
            do {
                String line = bufferedReader.readLine();
                if(line == null){
                    break;
                }
                lines.add(line);
            }while(bufferedReader.ready());
        } catch (FileNotFoundException e) {
            throw new InvalidPathException(e.getMessage());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return lines;
    }
}
