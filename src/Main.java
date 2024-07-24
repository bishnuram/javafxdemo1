import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a Button to open the second window
        Button openButton = new Button("Open Second Window");
        openButton.setOnAction(event -> openSecondWindow(primaryStage));

        // Create a StackPane as the root node of the scene
        StackPane root = new StackPane();
        root.getChildren().add(openButton);

        // Create a Scene with the StackPane as its root node
        Scene scene = new Scene(root, 300, 200);

        // Set the Scene to the Stage
        primaryStage.setScene(scene);

        // Set the title of the Stage
        primaryStage.setTitle("JavaFX Main Window");

        // Show the Stage
        primaryStage.show();
    }

    private void openSecondWindow(Stage primaryStage) {
        // Close the main window (this window)
        primaryStage.close();

        // Create a new stage for the second window
        Stage secondStage = new Stage();

        // Create a Button to open the main window again
        Button openMainButton = new Button("Open Main Window");
        openMainButton.setOnAction(event -> {
            secondStage.close();
            // Create a new instance of the Main class and call its start() method
            new Main().start(new Stage());
        });

        // Create a StackPane as the root node of the scene for the second window
        StackPane secondRoot = new StackPane();
        secondRoot.getChildren().add(openMainButton);

        // Create a Scene with the StackPane as its root node for the second window
        Scene secondScene = new Scene(secondRoot, 300, 200);

        // Set the Scene to the second Stage
        secondStage.setScene(secondScene);

        // Set the title of the second Stage
        secondStage.setTitle("JavaFX Second Window");

        // Show the second Stage
        secondStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
