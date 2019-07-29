package com.morning.star.openfalcon.agent;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * 网络工具类.
 * @author Tim
 *
 */
class NetUtils {
    
    private static String hostName;


    public static String getHostName() {
        if(hostName != null) {
            return hostName;
        }
        hostName = getHostNameByCmd();
        return hostName;
    }
    
    
    private static String getHostNameByCmd() {
        try {
            Process process = Runtime.getRuntime().exec("hostname");
 
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
 
            String line = null;
            while ((line = input.readLine()) != null) {
                return line;
            }
        } catch (java.io.IOException e) {
        }
        return "Unknown";
    }
    
}
