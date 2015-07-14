package com.somersi.pusher.client.channel;

import com.google.gwt.core.client.JavaScriptObject;

public interface EventListener {

  public void onEvent(Channel channel, JavaScriptObject data);
}