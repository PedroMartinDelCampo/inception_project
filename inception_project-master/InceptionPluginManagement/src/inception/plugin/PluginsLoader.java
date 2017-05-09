/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.plugin;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Pedro
 */
public class PluginsLoader {
    
    public static void loadFromFile(File file) throws PluginLoaderException {
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(PluginListWrapper.class);
        } catch (JAXBException ex) {
            throw new PluginLoaderException("Error when creating JAXBContext", ex);
        }
        Unmarshaller um;
        try {
            um = context.createUnmarshaller();
        } catch (JAXBException ex) {
            throw new PluginLoaderException("Error when creating unmarshaller", ex);
        }
        
        PluginListWrapper wrapper;
        try {
            wrapper = (PluginListWrapper) um.unmarshal(file);
        } catch (JAXBException ex) {
            throw new PluginLoaderException("Error when reading / parsing file", ex);
        }
        List<String> plugins = wrapper.getPlugins();
        if (plugins == null || plugins.size() == 0) return;
        for (String plugin : plugins) {
            Class c;
            try {
                c = Class.forName(plugin);
            } catch (ClassNotFoundException ex) {
                throw new PluginLoaderException("Class not found: " + plugin, ex);
            }
            PluginManager.getInstance().registerPlugin(c);
        }
    }
    
}
