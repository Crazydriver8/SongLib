/*
 * Brandon Berrios and Bilal Bari
 * CS 213 Assignment 1
 */

package view;

import application.SongLib;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Song;

public class SongOverviewController {
    @FXML
    private TableView<Song> songTable;
    @FXML
    private TableColumn<Song, String> songTitleColumn;
    @FXML
    private TableColumn<Song, String> songArtistColumn;

    @FXML
    private TextField songTitleLabel;
    @FXML
    private TextField songArtistLabel;
    @FXML
    private TextField songAlbumLabel;
    @FXML
    private TextField songYearLabel;

    // Reference to the main application.
    private SongLib mainApp;

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
    
    @FXML
    private void editSong() {
    	int index = songTable.getSelectionModel().getSelectedIndex();
    	Song song = songTable.getSelectionModel().getSelectedItem();
    	if (song == null) {
    		Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Song Selected");
            alert.setContentText("Please select a song in the table.");

            alert.showAndWait();
    	}
    	if (songTitleLabel.getText() != null) {
    		song.setSongTitle(songTitleLabel.getText());
    	} else {
    		songTitleLabel.setText("Need this value");
    		return;
    	}
    	if (songArtistLabel.getText() != null) {
    		song.setSongArtist(songArtistLabel.getText());
    	} else {
    		songTitleLabel.setText("Need this value");
    		return;
    	}
    	if (songAlbumLabel.getText() != null) {
    		song.setSongAlbum(songAlbumLabel.getText());
    	}
    	if (songYearLabel.getText() != null) {
    		song.setSongYear(songYearLabel.getText());
    	}
    	mainApp.songData.set(index, song);
    	showSongDetails(song);
    }
    
    @FXML
    private void newSong() {
    	Song song = new Song();
    	if (songTitleLabel.getText() != null) {
    		song.setSongTitle(songTitleLabel.getText());
    	} else {
    		songTitleLabel.setText("Need this value");
    		return;
    	}
    	if (songArtistLabel.getText() != null) {
    		song.setSongArtist(songArtistLabel.getText());
    	} else {
    		songTitleLabel.setText("Need this value");
    		return;
    	}
    	if (songAlbumLabel.getText() != null) {
    		song.setSongAlbum(songAlbumLabel.getText());
    	}
    	if (songYearLabel.getText() != null) {
    		song.setSongYear(songYearLabel.getText());
    	}
    	mainApp.getSongData().add(song);
    	
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(SongLib mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        songTable.setItems(mainApp.getSongData());
    }
    
    private void showSongDetails (Song song) {
    	if (song != null) {
    		if (song.getSongTitle() != null) {
    			songTitleLabel.setText(song.getSongTitle());
    		}
    		if (song.getSongArtist() != null) {
    			songArtistLabel.setText(song.getSongArtist());
    		}
    		if (song.getSongAlbum() != null) {
    			songAlbumLabel.setText(song.getSongAlbum());
    		}
    		if (song.getSongYear() != null) {
    			songYearLabel.setText(song.getSongYear());
    		}
    	} else {
    		songTitleLabel.setText("");
    		songArtistLabel.setText("");
    		songArtistLabel.setText("");
    		songArtistLabel.setText("");
    	}
    }
}
