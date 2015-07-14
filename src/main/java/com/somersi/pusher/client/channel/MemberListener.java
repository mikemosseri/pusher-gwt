package com.somersi.pusher.client.channel;

public interface MemberListener {
  /**
   * Triggered when a member joins a channel. Its quite possible that a 
   * member can have multiple connections to the same channel (for example 
   * by having multiple browser tabs open) and in this case the events 
   * will only be triggered when the first tab is opened.
   * 
   * @param member
   */
  public void onMemberAdded(PresenceChannel channel, Member member);
  
  /**
   * Triggered when a member leaves a channel. Its quite possible that a 
   * member can have multiple connections to the same channel (for example 
   * by having multiple browser tabs open) and in this case the events 
   * will only be triggered when the last one is closed.
   * 
   * @param member
   */
  public void onMemberRemoved(PresenceChannel channel, Member member);
}
