package com.somersi.pusher.client.channel;

import com.google.gwt.core.client.JavaScriptObject;

public final class Member extends JavaScriptObject {
  protected Member() {
    // Required for overlay types
  }
  
  /**
   * A unique identifier of the member. The value for this depends on the server
   * authentication.
   * @return id
   */
  public final native String getId() /*-{
    return this.id;
  }-*/;
  
  /**
   * An object that can have any number of properties on it. The properties 
   * depend on the server authentication.
   * @return info
   */
  public final native JavaScriptObject getInfo() /*-{
    return this.info;
  }-*/;
}
