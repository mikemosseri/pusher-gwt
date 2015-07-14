package com.somersi.pusher.client.channel;

import com.google.gwt.core.client.JavaScriptObject;


/**
 * An object that represents a Pusher channel. An implementation of this interface is returned when you call
 * {@link com.somersi.pusher.client.Pusher#subscribe(String)} or {@link com.somersi.pusher.client.Pusher#subscribe(String, ChannelEventListener, String...)}.
 * 
 * @see https://github.com/pusher/pusher-java-client/blob/master/src/main/java/com/pusher/client/channel/Channel.java
 */
public class Channel extends JavaScriptObject {
  
  public enum ChannelType {
    PUBLIC,
    PRIVATE,
    PRESENCE
  }
  
  protected Channel() {
    // Required for overlay types
  }
  
  public final boolean isPresence() {
    return getName().indexOf("presence-") == 0;
  }
  
  public final boolean isPrivate() {
    return getName().indexOf("private-") == 0;
  }
  
  /**
   * Convenience method to determine the type of channel since casting
   * the JavaScriptObject overlays aren't proper
   * @return
   */
  public final ChannelType getChannelType() {
    if (getName().indexOf("private-") == 0) {
      return ChannelType.PRIVATE;
    } else if (getName().indexOf("presence-") == 0) {
      return ChannelType.PRESENCE;
    } else {
      return ChannelType.PUBLIC;
    }
  }
  
  /**
   * Gets the name of the Pusher channel that this object represents.
   * @return The name of the channel.
   */
  public final native String getName() /*-{
    return this.name;
  }-*/;

  /**
   * Binds a {@link EventListener} to an event. The {@link EventListener} will be notified whenever the
   * specified event is received on this channel.
   *
   * @param eventName The name of the event to listen to.
   * @param listener A listener to receive notifications when the event is received.
   */
  public final native void bind(String eventName, EventListener listener) /*-{
    var self = this;
    if (listener != null) {
      this.bind(eventName, $entry(function(data) {
        listener.@com.somersi.pusher.client.channel.EventListener::onEvent(Lcom/somersi/pusher/client/channel/Channel;Lcom/google/gwt/core/client/JavaScriptObject;)(self, data);
      }));
    }
  }-*/;
  
  /**
   * <p>Unbinds a previously bound {@link EventListener} from an event. The {@link EventListener} will no
   * longer be notified whenever the specified event is received on this channel.</p>
   *
   * <p>Calling this method does not unsubscribe from the channel even if there are no more {@link EventListener}s
   * bound to it. If you want to unsubscribe from the channel completely, call {@link com.pusher.client.Pusher#unsubscribe(String)}.
   * It is not necessary to unbind your {@link EventListener}s first.</p>
   *
   * @param eventName The name of the event to stop listening to.
   * @param listener The listener to unbind from the event.
   */
  public final native void unbind(String eventName, EventListener listener) /*-{
    var self = this;
    if (listener != null) {
      this.unbind(eventName, $entry(function(data) {
        listener.@com.somersi.pusher.client.channel.EventListener::onEvent(Lcom/somersi/pusher/client/channel/Channel;Lcom/google/gwt/core/client/JavaScriptObject;)(self, data);
      }));
    }
  }-*/;
  
  /**
   * Binds a {@link SubscriptionSucceededListener} to the channel. The {@link SubscriptionSucceededListener} will be notified whenever the
   * specified subscription has been registered with Pusher.
   *
   * @param listener A listener to receive notifications.
   */
  public final native void addSubscriptionSucceededListener(SubscriptionSucceededListener listener) /*-{
    var self = this;
    if (listener != null) {
      this.bind('pusher:subscription_succeeded', $entry(function() {
        listener.@com.somersi.pusher.client.channel.SubscriptionSucceededListener::onSucceed(Lcom/somersi/pusher/client/channel/Channel;)(self);
      }));
    }
  }-*/;
}