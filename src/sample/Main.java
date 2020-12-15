package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.IObserver;
import sample.model.PopupCongratulations;
import sample.model.User;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/start.fxml"));
        primaryStage.setTitle("Language learning app");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        setObserver(new PopupCongratulations());
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void setObserver(IObserver observer) {
        User.getINSTANCE().attach(new PopupCongratulations());
    }
}
