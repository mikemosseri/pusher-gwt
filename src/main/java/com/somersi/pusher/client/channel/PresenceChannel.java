package com.somersi.pusher.client.channel;

import com.google.gwt.core.client.JsArray;

public final class PresenceChannel extends PrivateChannel {
  protected PresenceChannel() {
    // Required for overlay types
  }
  
  /**
   * A property with a value that indicates how many members are subscribed 
   * to the presence channel.
   * @return number of members
   */
  public final native String getMembersCount() /*-{
    return this.members.count;
  }-*/;
  
  /**
   * Instead of the each with callback, provide a method to get
   * a list of all members
   * @return all members subscribed to this presence channel
   */
  public final native JsArray<Member> getMembers() /*-{
    var arr = [];
    this.members.each(function(member) {
      arr.push(member);
    });
    return arr;
  }-*/;
  
  /**
   * Method can be used to get a member with a specified memberId.
   * 
   * @return A member object with a member.id and member.info property.
   */
  public final native Member getMember(String memberId) /*-{
    return this.members.get(memberId);
  }-*/;
  
  
  /**
   * Once a member has had their subscription request authenticated (see 
   * Authenticating Users) and the subscription has succeeded it is 
   * possible to access information about the local member on the presence 
   * channel.
   * 
   * @return local member
   */
  public final native Member getMe() /*-{
    return this.members.me;
  }-*/;
  
  
  /**
   * Binds a {@link MemberListener} to the channel. The {@link MemberListener} 
   * will be notified whenever a member is added or removed.
   *
   * @param listener A listener to receive notifications.
   */
  public final native void addMemberListener(MemberListener listener) /*-{
    var self = this;
    if (listener != null) {
      this.bind('pusher:member_added', $entry(function(member) {
        listener.@com.somersi.pusher.client.channel.MemberListener::onMemberAdded(Lcom/somersi/pusher/client/channel/PresenceChannel;Lcom/somersi/pusher/client/channel/Member;)(self, member);
      }));
      this.bind('pusher:member_removed', $entry(function(member) {
        listener.@com.somersi.pusher.client.channel.MemberListener::onMemberRemoved(Lcom/somersi/pusher/client/channel/PresenceChannel;Lcom/somersi/pusher/client/channel/Member;)(self, member);
      }));
    }
  }-*/;
  
  
 }
