package com.test;

public interface ApplicationServerLogEntry extends LogEntry {
    Type getType();
    String getHost();

}
