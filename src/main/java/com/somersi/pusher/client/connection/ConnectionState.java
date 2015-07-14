package com.somersi.pusher.client.connection;

/**
 * States:
 * - initialized - initial state, never transitioned to
 * - connecting - connection is being established
 * - connected - connection has been fully established
 * - disconnected - on requested disconnection
 * - unavailable - after connection timeout or when there's no network
 * - failed - when the connection strategy is not supported
 */
public enum ConnectionState {
  INITIALIZED,
  CONNECTING,
  CONNECTED,
  DISCONNECTED,
  UNAVAILABLE,
  FAILED;
  
  public static ConnectionState fromString(String input) {
    for (ConnectionState cs : ConnectionState.values()) {
      if (cs.toString().equalsIgnoreCase(input)) {
        return cs;
      }
    }
    return null;
  }
}
