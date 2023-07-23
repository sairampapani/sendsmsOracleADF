package view.bean.common;

import java.io.IOException;

import org.apache.http.HttpResponse;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class GenericCall {
    public GenericCall() {
        super();
    }
    
    public static HttpResponse callSmsAPI(String mobile, String msg){
        System.out.println("Start callSmsAPI:");
        HttpResponse resp = null;
        String SMS_URL = "https://www.fast2sms.com/dev/bulkV2";
        String authString = "xkO1iMEqrV7bIT0dJAhQjU5KoBtDzSe49sX2GmNYpv3Wag68LceFNwm63q2QoaKjIlOzZUrgf5Jbth0n";
       // String message = "Welcome%20to%20MWGL!";
        // String number = "9000634160";
        try {
        String url = SMS_URL+"?authorization="+authString+"&route=q&message="+msg+"&flash=0&numbers="+mobile;
        System.out.println("URL: "+url);
        HttpGet get = new HttpGet(url);
        HttpClient httpClient = HttpClients.createDefault();
        resp = (HttpResponse) httpClient.execute(get);
        } catch (ClientProtocolException e) {
            System.out.println("ClientProtocolException: "+e);
        } catch (IOException e) {
            System.out.println("IOException: "+e);
        }
        System.out.println("End callSmsAPI: "+resp);
        return resp;
    }
    
    
}
