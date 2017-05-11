/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author al342235
 */
public class AppProperties {
    
    private static final String PROPERTIES_FILE = "App.properties";
    private final Properties properties;
    
    public AppProperties() {
        URL propertiesResource = getClass().getResource(PROPERTIES_FILE);
        properties = new Properties();
        try {
            properties.load(propertiesResource.openStream());
        } catch (IOException ex) {
            Logger.getLogger(AppProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void set(String key, String value) {
        properties.put(key, value);
    }
    
    public String get(String key) {
        return (String) properties.get(key);
    }
    
}
