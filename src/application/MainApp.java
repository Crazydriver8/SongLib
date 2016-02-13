package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Song;
import view.SongOverviewController;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    public ObservableList<Song> songData = FXCollections.observableArrayList();

    public MainApp() {
    	songData.add(new Song("Hans", "Muster"));
        songData.add(new Song("Ruth", "Mueller"));
        songData.add(new Song("Heinz", "Kurz"));
        songData.add(new Song("Cornelia", "Meier"));
        songData.add(new Song("Werner", "Meyer"));
        songData.add(new Song("Lydia", "Kunz"));
        songData.add(new Song("Anna", "Best"));
        songData.add(new Song("Stefan", "Meier"));
        songData.add(new Song("Martin", "Mueller"));
    }
    
    public ObservableList<Song> getSongData() {
    	return songData;
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("SongLib");

        initRootLayout();

        showSongOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showSongOverview() {
        try {
            // Load song overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/SongOverview.fxml"));
            AnchorPane songOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(songOverview);
            
            SongOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
