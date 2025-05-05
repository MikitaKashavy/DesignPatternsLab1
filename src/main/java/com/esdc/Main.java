package com.esdc;

import com.esdc.reader.DataParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        DataParser dataParser = new DataParser();
        log.info(dataParser.path().toString());
        }
    }