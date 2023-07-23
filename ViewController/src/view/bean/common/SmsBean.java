package view.bean.common;

import javax.faces.event.ActionEvent;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public class SmsBean {
    public SmsBean() {
    }
    private String mobileNo;
    private String message;
    public void sendSMS(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("Start sendSMS: ");
        String mobile = this.getMobileNo();
        String message = this.getMessage();
        System.out.println("mobile: "+mobile);
        System.out.println("message: "+message);
        
        String msg = message.replaceAll(" ", "%20");
        System.out.println("Msg: "+msg);

        HttpResponse resp = GenericCall.callSmsAPI(mobile, msg);
         StatusLine status = resp.getStatusLine();
        int statusCode = status.getStatusCode();
        System.out.println("status:"+statusCode);
        
        if(statusCode == 200){
            System.out.println("Message Sent successfully!");
        }else{
            System.out.println("Message not sent. There is a problem!");
        }
        System.out.println("END sendSMS:");
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
