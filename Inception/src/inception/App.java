/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception;

import inception.model.DummyStimulus;
import inception.plugin.Plugin;
import inception.plugin.PluginLoaderException;
import inception.plugin.PluginManager;
import inception.plugin.PluginsLoader;
import inception.plugin.video.VideoPlugin;
import inception.view.ViewService;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Pedro
 */
public class App extends Application {
    
    private final ServiceContainer container = ServiceContainer.getInstance();
    
    @Override
    public void start(Stage primaryStage) throws PluginLoaderException {
        AppProperties appProperties = container.getAppProperties();
        ViewService viewService = container.getViewService();
        
        String pluginsPath = appProperties.get("plugins.file");
        File pluginsFile = new File(pluginsPath);
        PluginsLoader.loadFromFile(pluginsFile);
        
        PluginManager manager = PluginManager.getInstance();
        
        Plugin p = manager.getPlugin(VideoPlugin.class);
        Node testPreview = p.createPreview(new DummyStimulus());
        Node testProperties  = p.createPropertiesPane(new DummyStimulus());
        
        AnchorPane pane = viewService.getView("MainLayout");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
