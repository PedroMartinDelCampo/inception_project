/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.controller;

import javafx.fxml.FXML;

/**
 *
 * @author Humberto
 */
public class MainController {
    
    @FXML
    private TimelineController timelineController;
    
    @FXML
    private ToolbarController toolbarController;
    
    @FXML
    private PreviewController previewController;
    
    @FXML
    private FrameController framesController;
    
    @FXML
    public void initialize() {
        timelineController.setPreviewController(previewController);
        toolbarController.setController(timelineController);
        framesController.setTimelineController(timelineController);
    }
    
}
