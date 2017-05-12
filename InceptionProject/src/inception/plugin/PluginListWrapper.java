/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.plugin;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pedro
 */
@XmlRootElement(name = "plugins")
public class PluginListWrapper {
    
    private List<String> plugins;
    
    @XmlElement(name = "plugin")
    public List<String> getPlugins() {
        return plugins;
    }
    
    public void setPlugins(List<String> plugins) {
        this.plugins = plugins;
    }
    
}
