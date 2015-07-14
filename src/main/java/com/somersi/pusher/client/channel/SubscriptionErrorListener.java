package com.somersi.pusher.client.channel;

/**
 * When an authorization attempt to a private or presence channel fails
 * 
 * @author mosseri
 *
 */
public interface SubscriptionErrorListener {

  public void onError(PrivateChannel channel, int status);
}