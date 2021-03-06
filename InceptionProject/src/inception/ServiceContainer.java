/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception;

import inception.plugin.PluginManager;
import inception.view.ViewService;

/**
 *
 * @author al342235
 */
public class ServiceContainer {
    
    private static final ServiceContainer container = new ServiceContainer();
    
    private final PluginManager pluginManager;
    private final ViewService viewService;
    private final AppProperties appProperties;
    
    private ServiceContainer() {
        pluginManager = new PluginManager();
        viewService = new ViewService();
        appProperties = new AppProperties();
    }
    
    public static ServiceContainer getInstance() {
        return container;
    }

    public PluginManager getPluginManager() {
        return pluginManager;
    }

    public ViewService getViewService() {
        return viewService;
    }

    public AppProperties getAppProperties() {
        return appProperties;
    }
    
        
}
