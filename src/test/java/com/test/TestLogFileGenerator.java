package com.test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.test.State.FINISHED;
import static com.test.State.STARTED;
import static com.test.Type.APPLICATION_LOG;

public class TestLogFileGenerator {

    private static final int NUMBER_LOG_ENTRIES = 100;

    public static void main(String[] args) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
        Path path = Paths.get(String.format("test.%s.log", timeStamp));

        List<String> lines = new ArrayList<>();
        lines.add("[");
        for (int i = 0; i < NUMBER_LOG_ENTRIES; i++) {

            String id = generateId();
            String hostname = getHostname();
            Long startingTimestamp = generateTimestamp();
            Long finishingTimestamp = startingTimestamp + duration();

            String startEventline = String.format(
                    "{\"id\":\"%s\", \"state\":\"%s\", \"type\":\"%s\", \"host\":\"%s\", \"timestamp\":%s},",
                    id, STARTED, APPLICATION_LOG, hostname, startingTimestamp);
            lines.add(startEventline);

            String finishEventline = String.format(
                    "{\"id\":\"%s\", \"state\":\"%s\", \"type\":\"%s\", \"host\":\"%s\", \"timestamp\":%s},",
                    id, FINISHED, APPLICATION_LOG, hostname, finishingTimestamp);
            lines.add(finishEventline);
        }

        lines.add("]");

        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    private static String generateId () {
        return Long.toHexString(Double.doubleToLongBits(Math.random()));
    }

    private static String getHostname() {
        return Long.toHexString(Double.doubleToLongBits(Math.random()));
    }

    private static Long generateTimestamp() {
        return System.currentTimeMillis();
    }

    private static Long duration() {
        return ThreadLocalRandom.current().nextLong(10);
    }
}
