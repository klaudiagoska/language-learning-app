package sample.model;

import javafx.event.ActionEvent;

/*
ICommand interface represents Command design pattern.
 */

public interface ICommand {

    void execute(ActionEvent actionEvent, String path);

}
