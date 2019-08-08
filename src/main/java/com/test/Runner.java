package com.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Runner {

    public static void main(String[] args) {

        Path path = Paths.get(args[0]);
        EventScraper eventScraper = new EventScraper(path);
    }
}
