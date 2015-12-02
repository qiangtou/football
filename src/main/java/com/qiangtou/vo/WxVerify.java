package com.qiangtou.vo;

import com.qiangtou.utils.EncoderHandler;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * Created by Administrator on 2015/12/2.
 */
public class WxVerify {

    private String token="wszgr";
    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;

    public WxVerify() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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

    public boolean verify() {
        if (StringUtils.isEmpty(this.getEchostr())
                || StringUtils.isEmpty(this.getTimestamp())
                || StringUtils.isEmpty(this.getNonce())
                || StringUtils.isEmpty(this.getSignature())) {
                return false;
        }
        String arr[] = new String[]{this.getToken(), this.getNonce(), this.getTimestamp()};
        Arrays.sort(arr);
        return EncoderHandler.encode("sha1", arr[0] + arr[1] + arr[2]).equals(this.getSignature());
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

        String token="wszgr";
        String nonce="sdfg345dgs";
        String timestamp=System.currentTimeMillis() + "";
        String arr[] = new String[]{token, nonce, timestamp};
        Arrays.sort(arr);
        String merge=arr[0]+arr[1]+arr[2];
        System.out.println(merge);
        String signature=EncoderHandler.encode("SHA1", merge);
        System.out.println(signature);

        WxVerify v = new WxVerify();
        v.setEchostr("1");
        v.setNonce(nonce);
        v.setTimestamp(timestamp);
        v.setSignature(signature);
        System.out.print(v.verify());
    }
}
