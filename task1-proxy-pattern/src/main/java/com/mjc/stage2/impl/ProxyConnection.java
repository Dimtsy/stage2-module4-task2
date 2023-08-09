package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private RealConnection realConnection;
    private boolean isClosed;

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
        this.isClosed = false;
    }

    public void reallyClose() {
        if (!isClosed) {
            realConnection = null;
            isClosed = true;
        }
    }

    @Override
    public void close() {
        realConnection.close();
    }

    @Override
    public boolean isClosed() {
        return isClosed;
    }
}
