package view;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Song;

public class SongOverviewController {
    @FXML
    private TableView<Song> songTable;
    @FXML
    private TableColumn<Song, String> songTitleColumn;
    @FXML
    private TableColumn<Song, String> songArtistColumn;

    @FXML
    private Label songTitleLabel;
    @FXML
    private Label songArtistLabel;
    @FXML
    private Label songAlbumLabel;
    @FXML
    private Label songYearLabel;

    // Reference to the main application.
    @SuppressWarnings("unused")
	private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public SongOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        songTitleColumn.setCellValueFactory(cellData -> cellData.getValue().songTitleProperty());
        songArtistColumn.setCellValueFactory(cellData -> cellData.getValue().songArtistProperty());
        showSongDetails(null);
        songTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showSongDetails(newValue));
    }

    @FXML
    private void deleteSong() {
    	int index = songTable.getSelectionModel().getSelectedIndex();
    	if (index >= 0) {
    		songTable.getItems().remove(index);
    	} else {
    		Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Song Selected");
            alert.setContentText("Please select a song in the table.");

            alert.showAndWait();
    	}
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        songTable.setItems(mainApp.getSongData());
    }
    
    private void showSongDetails (Song song) {
    	if (song != null) {
    		songTitleLabel.setText(song.getSongTitle());
    		songArtistLabel.setText(song.getSongArtist());
    		songAlbumLabel.setText(song.getSongAlbum());
    		songYearLabel.setText(song.getSongYear());
    	} else {
    		songTitleLabel.setText("");
    		songArtistLabel.setText("");
    		songArtistLabel.setText("");
    		songArtistLabel.setText("");
    	}
    }
}
