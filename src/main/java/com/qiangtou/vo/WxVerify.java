package com.qiangtou.vo;

import com.qiangtou.utils.EncoderHandler;

import java.util.Arrays;

/**
 * Created by Administrator on 2015/12/2.
 */
public class WxVerify {

    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    public boolean verify(){
        String arr[]=new String[]{this.getEchostr(),this.getNonce(),this.getTimestamp()};
        Arrays.sort(arr);
        return EncoderHandler.encode("sha1",arr[0]+arr[1]+arr[2]).equals(this.getSignature());
    }

    @Override
    public String toString() {
        return "WxVerify{" +
                "signature='" + signature + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", nonce='" + nonce + '\'' +
                ", echostr='" + echostr + '\'' +
                '}';
    }

    public static void main(String[] args) {
        WxVerify v=  new WxVerify();
        v.setEchostr("1");
        v.setNonce("234234");
        v.setTimestamp(System.currentTimeMillis()+"");
        v.setSignature("ttt");
        System.out.print(v.verify());
    }
}
