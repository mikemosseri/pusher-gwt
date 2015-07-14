package com.somersi.pusher.client.channel;

public class PrivateChannel extends Channel {
  protected PrivateChannel() {
    // Required for overlay types
  }
  
  /**
   * Binds a {@link SubscriptionErrorListener} to the channel. The {@link SubscriptionErrorListener} will be notified whenever the
   * authentication request for a private or presence channels fails.
   *
   * @param listener A listener to receive notifications.
   */
  public final native void addSubscriptionErrorListener(SubscriptionErrorListener listener) /*-{
    var self = this;
    if (listener != null) {
      this.bind('pusher:subscription_error', $entry(function(status) {
        listener.@com.somersi.pusher.client.channel.SubscriptionErrorListener::onError(Lcom/somersi/pusher/client/channel/PrivateChannel;I)(self, status);
      }));
    }
  }-*/;
}
