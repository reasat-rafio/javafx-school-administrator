package com.example.schooladministrator;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Function;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ActionButtonTableCell<S> extends TableCell<S, Button> {

    @FXML
    private static Stage stage;

    private final Button actionButton;

    public ActionButtonTableCell(String label,boolean isEditButton, Function< S, S> function) {
        this.getStyleClass().add("action-button-table-cell");

        this.actionButton = new Button(label);
        this.actionButton.setOnAction((ActionEvent e) -> {
            if(!isEditButton) function.apply(getCurrentItem());
            else {
                try {
                    System.out.println("try");
                    function.apply(goToEditPage(e));
                } catch (IOException ex) {
                    System.out.println("CATCh");
                    throw new RuntimeException(ex);
                }
            }
        });
        this.actionButton.setMaxWidth(Double.MAX_VALUE);
    }

    public S getCurrentItem() {
        return (S) getTableView().getItems().get(getIndex());
    }

    public S goToEditPage(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("update-single-student.fxml")));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        String css = Objects.requireNonNull(this.getClass().getResource("style.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
        getTableView().getItems();
        getIndex();
        return (S) getTableView().getItems().get(getIndex());
    }

    public static <S> Callback<TableColumn<S, Button>, TableCell<S, Button>> forTableColumn(String label, boolean isEditButton, Function< S, S> function) {
        return param -> new ActionButtonTableCell<>(label, isEditButton, function);
    }

    @Override
    public void updateItem(Button item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setGraphic(null);
        } else {
            setGraphic(actionButton);
        }
    }
}