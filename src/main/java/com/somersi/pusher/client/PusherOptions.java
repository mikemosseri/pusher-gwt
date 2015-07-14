package com.somersi.pusher.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public final class PusherOptions extends JavaScriptObject {
  
  public static PusherOptions createImpl() {
    return (PusherOptions) JavaScriptObject.createObject();
  }
  
  protected PusherOptions() {
    // Required for overlay types
  }

  /**
   * A Pusher client can be configured to only connect over encrypted (SSL) 
   * connections. An application that uses SSL should use this option to ensure 
   * connection traffic is encrypted. It is also possible to force connections 
   * to use SSL by enabling the Encrypted setting within an applications dashboard 
   * settings.
   * 
   * @param encrypted 
   */
  public native void setEncrypted(boolean encrypted) /*-{
    this.encrypted = encrypted;
  }-*/;

  /**
   * Endpoint on your server that will return the authentication signature needed
   * for private and presence channels. Defaults to '/pusher/auth'.
   * @param url 
   */
  public native void setAuthEndpoint(String url) /*-{
    this.authEndpoint = url;
  }-*/;

  /**
   * Defines how the authentication endpoint, defined using authEndpoint, will be 
   * called. There are two options available: 
   *  ajax - The default option where an XMLHttpRequest object will be used to make 
   *   a request. The parameters will be passed as POST parameters. 
   *  jsonp - The authentication endpoint will be called by a <script> tag being 
   *   dynamically created pointing to the endpoint defined by authEndpoint. This 
   *   can be used when the authentication endpoint is on a different domain to the web 
   *   application. The endpoint will therefore be requested as a GET and parameters 
   *   passed in the query string. For more information see the Channel 
   *   authentication transport section of the authenticating users docs.
   * @param authTransport
   */
  public native void setAuthTransport(String authTransport) /*-{
    this.authTransport = authTransport;
  }-*/;


  /**
   * Allows connecting to a different datacenter by setting up correct hostnames 
   * and ports for the connection. Optional, when not supplied, will connect to the 
   * default us-east cluster. Alternate is "eu" cluster.
   * 
   * @param cluster
   */
  public native void setCluster(String cluster) /*-{
    this.cluster = cluster;
  }-*/;
  
  /**
   * Disables Flash fallback, leaving only WebSockets and HTTP fallback.
   * @param disableFlash
   */
  public native void setDisableFlash(boolean disableFlash) /*-{
    this.disableFlash = disableFlash;
  }-*/;

  /**
   * Disables stats collection, so that connection metrics are not submitted to
   * Pushers servers.
   * @param disableStats
   */
  public native void setDisableStats(boolean disableStats) /*-{
    this.disableStats = disableStats;
  }-*/;


  /**
   * Specifies which transports should be used by Pusher to establish a 
   * connection. Useful for applications running in controlled, well-behaving 
   * environments. Available transports: ws, flash, sockjs. Additional transports 
   * may be added in the future and without adding them to this list, they will 
   * be disabled.
   * 
   * GWT Ex:
   * JsArrayString arr = JavaScriptObject.createArray().cast();
   * arr.push(str1); 
   * arr.push(str2);
   * 
   * @param enabledTransports
   */
  public native void setEnabledTransports(JsArrayString enabledTransports) /*-{
    this.enabledTransports = enabledTransports;
  }-*/;

  /**
   * Specified which transports must not be used by Pusher to establish a
   * connection. This settings overwrites transports whitelisted via the 
   * enabledTransports options. Available transports: ws, flash, sockjs. 
   * Additional transports may be added in the future and without adding 
   * them to this list, they will be enabled.
   * 
   * @param disabledTransports
   */
  public native void setDisabledTransports(JsArrayString disabledTransports) /*-{
    this.disabledTransports = disabledTransports;
  }-*/;
  
  /**
   * Helper method to just add a single transport
   * @param disabledTransport
   */
  public native void addDisabledTransports(String disabledTransport) /*-{
    var d = this.disabledTransports || [];
    d.push(disabledTransport);
    this.disabledTransports = d;
  }-*/;

  /** 
   * After this time (in miliseconds) without any messages received from the 
   * server, a ping message will be sent to check if the connection is still 
   * working. Default value is is supplied by the server, low values will result
   * in unnecessary traffic.
   * 
   * @param activityTimeout
   */
  public native void setActivityTimeout(int activityTimeout) /*-{
    this.activityTimeout = activityTimeout;
  }-*/;
  
  /** 
   * Time before the connection is terminated after sending a ping message. 
   * Default is 30000 (30s). Low values will cause false disconnections, if 
   * latency is high.
   * 
   * @param disabledTransports
   */
  public native void setPongTimeout(int pongTimeout) /*-{
    this.pongTimeout = pongTimeout;
  }-*/;
  

  /**
   * Only applied when using ajax authentication 
   * Provides the ability to pass additional HTTP Headers to the channel 
   * authentication endpoint when authenticating a channel. This can be useful 
   * with some web application frameworks that guard against CSRF (Cross-site 
   * request forgery).
   * 
   * @param name
   * @param value
   */
  public native void addAuthHeader(String name, String value) /*-{
    var a = this.auth || {};
    var h = a.headers || {};
    h[name] = value;
    a.headers = h;
    this.auth = a;
  }-*/;
  
  /**
   * Additional parameters to be sent when the channel authentication endpoint 
   * is called. When using ajax authentication the parameters are passed as 
   * additional POST parameters. When using jsonp authentication the parameters
   *  are passed as GET parameters. This can be useful with web application 
   *  frameworks that guard against CSRF (Cross-site request forgery).
   * 
   * @param name
   * @param value
   */
  public native void addAuthParam(String name, String value) /*-{
    var a = this.auth || {};
    var p = a.params || {};
    p[name] = value;
    a.params = p;
    this.auth = a;
  }-*/;
}
