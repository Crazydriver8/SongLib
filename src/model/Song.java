/*
 * Brandon Berrios and Bilal Bari
 * CS 213 Assignment 1
 */

package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Song {
	private final StringProperty songTitle;
	private final StringProperty songArtist;
	private final StringProperty songAlbum;
	private final StringProperty songYear;
	
	public Song() {
		this(null, null);
	}
	
	public Song(String title, String artist) {
		this.songTitle = new SimpleStringProperty(title);
		this.songArtist = new SimpleStringProperty(artist);
		this.songAlbum = new SimpleStringProperty("N/A");
		this.songYear = new SimpleStringProperty("N/A");
	}
	
	public String getSongTitle() {
		return songTitle.get();
	}
	
	public void setSongTitle(String title) {
		this.songTitle.set(title);
	}
	
	public StringProperty songTitleProperty() {
		return songTitle;
	}
	
	public String getSongArtist() {
		return songArtist.get();
	}
	
	public void setSongArtist(String artist) {
		this.songArtist.set(artist);
	}
	
	public StringProperty songArtistProperty() {
		return songArtist;
	}
	
	public String getSongAlbum() {
		return songAlbum.get();
	}
	
	public void setSongAlbum(String album) {
		this.songAlbum.set(album);
	}
	
	public StringProperty songAlbumProperty() {
		return songAlbum;
	}
	
	public String getSongYear() {
		return songYear.get();
	}
	
	public void setSongYear(String year) {
		this.songYear.set(year);
	}
	
	public StringProperty songYearProperty() {
		return songYear;
	}
	
}
