package com.test;

public class JsonLogEntry implements LogEntry {

    protected final String id;
    protected final State state;
    protected final long timestamp;

    public JsonLogEntry(String id, State state, long timestamp) {
        this.id = id;
        this.state = state;
        this.timestamp = timestamp;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }
}
