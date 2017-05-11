/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.plugin;

import inception.model.Stimulus;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pedro
 */
public class PluginManager {

    private final Map<Class, Plugin> registry;

    public PluginManager() {
        registry = new HashMap<>();
    }

    public void registerPlugin(Class plugin) throws PluginLoaderException {
        if (Plugin.class.isAssignableFrom(plugin)) {
            Plugin p;
            try {
                p = (Plugin) plugin.newInstance();
                if (Stimulus.class.isAssignableFrom(p.getStimulusClass())) {
                    registry.put(plugin, p);
                } else {
                    throw new PluginLoaderException("Method getStimulusClass() in "
                            + plugin.getCanonicalName(), null);
                }
            } catch (InstantiationException | IllegalAccessException ex) {
                throw new PluginLoaderException("The plugin must have a public empty constructor in "
                        + plugin.getCanonicalName(), ex);
            }
        } else {
            throw new PluginLoaderException("The plugin must implement Plugin interface in "
                    + plugin.getCanonicalName(), null);
        }
    }

    public Plugin getPlugin(Class plugin) {
        return registry.get(plugin);
    }

    public Collection<Plugin> getPlugins() {
        return registry.values();
    }

    public Plugin findByStimulus(Class cls) {
        for (Class c : registry.keySet()) {
            Plugin p = registry.get(c);
            if (cls.equals(p.getStimulusClass())) {
                return p;
            }
        }
        return null;
    }

}
