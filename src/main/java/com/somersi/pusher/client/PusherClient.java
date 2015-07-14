package com.somersi.pusher.client;

import com.somersi.pusher.client.channel.Channel;
import com.somersi.pusher.client.channel.PresenceChannel;
import com.somersi.pusher.client.channel.PrivateChannel;
import com.somersi.pusher.client.connection.ConnectionEventListener;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * 
 * @author Mike Mosseri
 */

public final class PusherClient extends JavaScriptObject {
  
  /**
   * Returns the singleton instance of the PusherClient class or <code>null</code>
   * if the javascript library isn't available
   * 
   */
  public static native PusherClient getInstance(String applicationKey, PusherOptions options) /*-{
    return new $wnd.Pusher(applicationKey, options);
  }-*/;

  protected PusherClient() {
    // Required for overlay types
  }
  
  /**
   * Disconnect from Pusher
   */
  public native void disconnect() /*-{
    this.disconnect();
  }-*/;
  
  public native void addConnectionEventListener(ConnectionEventListener listener) /*-{
    var self = this;
    if (listener != null) {
      this.connection.bind('state_change', $entry(function(stateChange) {
        listener.@com.somersi.pusher.client.connection.ConnectionEventListener::onConnectionStateChange(Lcom/somersi/pusher/client/connection/ConnectionStateChange;)(stateChange);
      }));
    }
  }-*/;
  
  /**
   * Subscribes to a Public channel
   * @param name The name of the channel to subscribe to.
   * @return A channel object which events can be bound to.
   */
  public native Channel subscribe(final String name) /*-{
    return this.subscribe(name);
  }-*/;
  
  /**
   * Subscribes to a Private channel
   * @param name The name of the channel to subscribe to. Must start with "private-"
   * @return A channel object which events can be bound to.
   */
  public native PrivateChannel subscribePrivate(final String name) /*-{
    return this.subscribe(name);
  }-*/;
  
  /**
   * Subscribes to a Presence channel
   * @param name The name of the channel to subscribe to. Must start with "presence-"
   * @return A channel object which events can be bound to.
   */
  public native PresenceChannel subscribePresence(final String name) /*-{
    return this.subscribe(name);
  }-*/;
  
  /**
   * Unsubscribes from any channel
   * @param name The name of the channel to unsubscribe to.
   */
  public native void unsubscribe(final String name) /*-{
    return this.unsubscribe(name);
  }-*/;
  
}