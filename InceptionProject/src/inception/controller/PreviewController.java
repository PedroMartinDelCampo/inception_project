/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Pedro
 */
public class PreviewController {
    
    @FXML
    private AnchorPane preview;
    
    public void setPreview(Node p) {
        preview.getChildren().clear();
        preview.getChildren().add(p);
    }
    
}
