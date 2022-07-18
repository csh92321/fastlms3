package com.zerobase.fastlms.util;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class RequestUtils {


    public static String getUserAgent(HttpServletRequest request) {

        return request.getHeader("User-Agent");

    }

    public static String getClientIP(HttpServletRequest request) throws UnknownHostException {

        String ipAddress = request.getRemoteAddr();
        if(ipAddress.equalsIgnoreCase("0:0:0:0:0:0:0:1")){
            InetAddress inetAddress = InetAddress.getLocalHost();
            ipAddress = inetAddress.getHostAddress();
        }

        return ipAddress;

    }
}
