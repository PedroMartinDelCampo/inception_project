/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

/**
 *
 * @author Pedro
 */
public class ViewService {
    
    public <T extends Node> T getView(String view) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ViewService.class.getResource("resources/" + view + ".fxml"));
        try {
            return loader.load();
        } catch (IOException ex) {
            return null;
        }
    }
    
}
