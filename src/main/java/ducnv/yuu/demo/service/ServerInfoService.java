package ducnv.yuu.demo.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@Component
public class ServerInfoService {

    @Value("${server.port}")
    private  String port;

    @Value("${server.ssl.enabled:false}")
    private  boolean sslEnabled;
    
    /**
     * Get server information
     * 
     * @return server information
     */
    public Map<String, String> getServerInfo() {
        String ipAddress = null;
        try {
            ipAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        String protocol = sslEnabled ? "https" : "http";
        Map<String, String> info = new HashMap<String, String>();
        info.put("protocol", protocol);
        info.put("ip", ipAddress);
        info.put("port", port);
        return info;
    }
    
    /**
     * Get server url
     * @return A url
     */
    public String getServerUrl(){
        String ipAddress = null;
        String protocol = this.sslEnabled ? "https" : "http";
        try {
            ipAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
        	e.printStackTrace();
        }
        return protocol + "://" + ipAddress + ":" + this.port;
    }
	
}
