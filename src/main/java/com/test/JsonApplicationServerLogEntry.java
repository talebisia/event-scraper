package com.test;

public class JsonApplicationServerLogEntry extends JsonLogEntry implements ApplicationServerLogEntry {
    private final String host;
    private final Type type;

    public JsonApplicationServerLogEntry(String id, State state, long timestamp, String host, Type type) {
        super(id, state, timestamp);
        this.host = host;
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String getHost() {
        return host;
    }
}
