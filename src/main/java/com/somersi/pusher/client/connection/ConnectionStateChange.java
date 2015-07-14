package com.somersi.pusher.client.connection;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Represents a change in connection state.
 * @see @see https://github.com/pusher/pusher-java-client/blob/master/src/main/java/com/pusher/client/connection/ConnectionStateChange.java
 */
public final class ConnectionStateChange extends JavaScriptObject {

  protected ConnectionStateChange() {
    // Required for overlay types
  }
  
  
  /**
   * The previous connections state. The state the connection has transitioned from.
   * 
   * @return ConnectionState
   */
  public ConnectionState getPreviousState() {
    return ConnectionState.fromString(getPreviousStateImpl());
  }
  private native String getPreviousStateImpl() /*-{
    return this.previous;
  }-*/;

  /**
   * The current connection state. The state the connection has transitioned to.
   * 
   * @return ConnectionState
   */
  public ConnectionState getCurrentState() {
    return ConnectionState.fromString(getCurrentStateImpl());
  }
  private native String getCurrentStateImpl() /*-{
    return this.current;
  }-*/;
}