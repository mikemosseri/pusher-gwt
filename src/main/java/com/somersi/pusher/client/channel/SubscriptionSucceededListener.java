package com.somersi.pusher.client.channel;

/**
 * When a client is successfully connected to a channel
 * @author mosseri
 *
 */
public interface SubscriptionSucceededListener {

  public void onSucceed(Channel channel);
}