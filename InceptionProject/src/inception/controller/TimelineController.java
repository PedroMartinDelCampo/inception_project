/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inception.controller;

import inception.ServiceContainer;
import inception.model.Frame;
import inception.model.Stimulus;
import inception.model.StoryBuilder;
import inception.plugin.Plugin;
import inception.plugin.PluginManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author Humberto
 */
public class TimelineController {

    @FXML
    private GridPane timelineGridPane;

    private final StoryBuilder builder = StoryBuilder.getInstance();
    private final PluginManager manager = ServiceContainer.getInstance().getPluginManager();

    public int i = 0;

    private static final double TIMELINE_WIDTH = 100;
    private static final double TIMELINE_HEIGHT = 30;

    private TimelineView selectedTimeline;
    private int selectedIndex, totalIndex = 0, frameIndex = 0;
    private final ObservableList<TimelineView> timelines = FXCollections.observableArrayList();

    private Label selectedLabel;

    private PreviewController previewController;

    public void setPreviewController(PreviewController previewController) {
        this.previewController = previewController;
    }
    
    public void addTimeline(Stimulus s) {
        Frame frame = builder.selectedFrame();
        if (frame == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("No has seleccionado ningún frame");
            alert.show();
            return;
        }
        frame.add(s);
        System.out.println("clicked on add");
        addTimelineToView(s);
    }
    
    private void addTimelineToView(Stimulus s) {
        Label nombre = new Label("Timeline " + (i + 1));
        TimelineView timeline = new TimelineView(TIMELINE_WIDTH, TIMELINE_HEIGHT);
        timeline.setIndex(i);
        timeline.setStimulus(s);
        timeline.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        timeline.setOnMouseClicked((MouseEvent t) -> {
            timelines.forEach(time -> {
                time.getStyleClass().clear();
            });
            timeline.getStyleClass().add("selected-timeline");
            Plugin plugin = manager.findByStimulus(s.getClass());
            Node preview = plugin.createPreview(s);
            previewController.setPreview(preview);
            Node properties = plugin.createPropertiesPane(s);
            editPropertiesTimeline();
            selectedTimeline = timeline;
            selectedLabel = nombre;
            selectedIndex = timeline.getIndex();
            System.out.println("clicked on add" + selectedIndex);
        });

        timelineGridPane.add(nombre, 0, i);
        timelineGridPane.add(timeline, 1, i);
        GridPane.setMargin(timeline, new Insets(0, 0, 0, 0));
        i++;

        totalIndex++;
        timelines.add(timeline);
    }
    
    @FXML
    public void deleteTimeline() {
        System.out.println("clicked on delete");
        if (selectedTimeline == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("No has seleccionado ningun timeline");
        } else {
            timelineGridPane.getChildren().remove(selectedTimeline);
            timelineGridPane.getChildren().remove(selectedLabel);
            builder.getFrame(frameIndex).remove(selectedIndex);
            previewController.clear();
        }

    }
    
    public void openFrame(Frame frame) {
        timelineGridPane.getChildren().clear();
        i = 0;
        setFrameIndex(builder.getFrames().indexOf(frame));
        frame.getStimuli().forEach(s -> {
            addTimelineToView(s);
        });
    }
    
    public void editPropertiesTimeline() {
    }

    public void editIntervalTimeline() {
        timelineGridPane.setMargin(selectedTimeline, new Insets(0, 0, 0, i));

    }

    private int getRowCount(GridPane pane) {
        int numRows = pane.getRowConstraints().size();
        for (int i = 0; i < pane.getChildren().size(); i++) {
            Node child = pane.getChildren().get(i);
            if (child.isManaged()) {
                Integer rowIndex = GridPane.getRowIndex(child);
                if (rowIndex != null) {
                    numRows = Math.max(numRows, rowIndex + 1);
                }
            }
        }
        return numRows;
    }

    public void setFrameIndex(int frameIndex) {
        this.frameIndex = frameIndex;
    }

}
