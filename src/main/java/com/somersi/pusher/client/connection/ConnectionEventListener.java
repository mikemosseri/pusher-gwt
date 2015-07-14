package com.somersi.pusher.client.connection;

public interface ConnectionEventListener {
  public void onConnectionStateChange(ConnectionStateChange state);
}
