package com.ve.pushover;

import net.pushover.client.MessagePriority;
import net.pushover.client.PushoverClient;
import net.pushover.client.PushoverException;
import net.pushover.client.PushoverMessage;
import net.pushover.client.PushoverRestClient;
import net.pushover.client.Status;

public class VEPushoverClient {

    private static String userId = "usrqrhxgykc2nofpvxp73h4bf1mhr6";
    private static String apiToken = "ajcq4f55c2xz2accg157xbi4f87xwd";

    public static int sendNormalNotification(String userIdentifier, String message, String url, String urlTitle){
	
	if("".equals(userIdentifier)) userIdentifier = userId;
	
	PushoverClient client = new PushoverRestClient();
	try {
	    Status result = client.pushMessage(PushoverMessage.builderWithApiToken(apiToken).setUserId(userId)
	    	    .setMessage(message).setPriority(MessagePriority.NORMAL) // HIGH|NORMAL|QUIET
	    	    .setUrl(url)
	    	    .setTitleForURL(urlTitle).setSound("magic").build());
	    return result.getStatus();
	}
	catch (PushoverException e) {
	    e.printStackTrace();
	}
	
	return -1;
    }
    
    public static int sendNormalNotification(String userIdentifier, String message){
	if("".equals(userIdentifier)) userIdentifier = userId;
	
	PushoverClient client = new PushoverRestClient();
	try {
	    Status result = client.pushMessage(PushoverMessage.builderWithApiToken(apiToken).setUserId(userId)
	    	    .setMessage(message).setPriority(MessagePriority.NORMAL) // HIGH|NORMAL|QUIET
	    	    .setSound("magic").build());
	    return result.getStatus();
	}
	catch (PushoverException e) {
	    e.printStackTrace();
	}
	
	return -1;
    }
    
    public static void main(String[] args) {

	//int status = sendNormalNotification("","TR Submitted For Approval", "http://cagile.provesio.com/auth?navigationUrl=http:%2F%2Fcagile.provesio.com%2Fbooking-requests%2Fapproval%2F43327%3FtravellerId%3D4409", "Approve TR");
	//System.out.println("Sending Status is " + status);
	int status = sendNormalNotification("","TR has been approved");
	System.out.println("Sending Status is " + status);
    }
}