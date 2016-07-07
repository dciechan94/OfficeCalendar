package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.util.*;
import java.util.stream.Collectors;


public class Cont2 {

    private static final String LANG_FILE = "LangBundle";
    private static final String[] WEEK_IDS = { "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday" };

    @FXML private VBox weekContainer;

    @FXML private Label monLabel;
    @FXML private Label tueLabel;
    @FXML private Label wedLabel;
    @FXML private Label thuLabel;
    @FXML private Label friLabel;
    @FXML private Label satLabel;
    @FXML private Label sunLabel;

    @FXML private VBox xxx;

    private Properties lang;


    public Cont2() {
        lang = LanguageLoader.getLanguageProperties(LANG_FILE);
    }

    @FXML
    public void initialize() {
        List<GridPane> panes = weekContainer.getChildren().stream()
                .filter(child -> child instanceof GridPane).map(node -> (GridPane) node).collect(Collectors.toList());

        double height = panes.stream().max(Comparator.comparing(panee -> panee.getWidth())).get().getWidth();
        weekContainer.getChildren().stream()
                .filter(child -> child instanceof GridPane)
                .forEach(gridPaneNode -> setGridConstraints((GridPane) gridPaneNode, height));

        loadDayNames();
        loadDayNo();

        CalendarQuickstart x = new CalendarQuickstart();

        Calendar c = getStartOfThisWeek();
        Date begin = c.getTime();
        c.add(Calendar.WEEK_OF_YEAR, 1);
        Date end = c.getTime();

        //x.getEvents(begin, end).forEach(entry -> xxx.getChildren().add(new Label(entry.getSummary())));

    }

    private Label getDayNoLabel(String gridPaneId) {
        GridPane pane = (GridPane)weekContainer.getChildren().stream().filter(node->node.getId().equals(gridPaneId)).findFirst().get();
        return getNodeByRowColumnIndex(pane, 0, 1);
    }

    private Label getNodeByRowColumnIndex(GridPane gridPane, final int row, final int column) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();
        for(Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        return (Label)result;
    }

    private Calendar getStartOfThisWeek() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);

        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());

        return cal;
    }

    private void setGridConstraints(GridPane pane, double height) {
        RowConstraints rowConstraint = new RowConstraints();
        rowConstraint.setMinHeight(90.0);
        rowConstraint.setVgrow(Priority.ALWAYS);

        pane.getRowConstraints().addAll(rowConstraint);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setMinWidth(30.0);
        column1.setPercentWidth(6.0);
        column1.setHgrow(Priority.ALWAYS);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setMinWidth(30.0);
        column2.setPercentWidth(12.0);
        column2.setHgrow(Priority.ALWAYS);

        ColumnConstraints column3 = new ColumnConstraints();
        column3.setMinWidth(30.0);
        column3.setPercentWidth(82.0);
        column3.setHgrow(Priority.ALWAYS);

        pane.getColumnConstraints().addAll(column1, column2, column3);
    }

    private void loadDayNames() {
        monLabel.setText(lang.getProperty("MondayLabel"));
        tueLabel.setText(lang.getProperty("TuesdayLabel"));
        wedLabel.setText(lang.getProperty("WednesdayLabel"));
        thuLabel.setText(lang.getProperty("ThursdayLabel"));
        friLabel.setText(lang.getProperty("FridayLabel"));
        satLabel.setText(lang.getProperty("SaturdayLabel"));
        sunLabel.setText(lang.getProperty("SundayLabel"));
    }

    private void loadDayNo() {
        Calendar cal = getStartOfThisWeek();

        for(String gridPaneId : WEEK_IDS) {
            Label dayNo = getDayNoLabel(gridPaneId);
            dayNo.setText(Integer.toString(cal.get(Calendar.DAY_OF_MONTH)));
            cal.add(Calendar.DATE, 1);
        }
    }

}
