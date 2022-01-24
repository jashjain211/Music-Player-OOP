package com.jash;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String name;
	private String artist;
	private ArrayList<Song> songs;
	public Album(String name, String artist) {
		super();
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}
	
	public Album() {
		
	}
	
	public Song findSong(String title) {
		for(Song checkedSong:songs) {
			if(checkedSong.getTitle().equals(title)) return checkedSong;
		}
		return null;
	}
	
	
	public boolean addSong(String title, double duration){
		if(findSong(title) == null) {
			songs.add(new Song(title,duration));
//			System.out.println(title + "Successfully added to the list");
			return true;
			}
		else {
//			System.out.println("Song with name"+ title+"Already exists in the list");
			return false;
		}
	}
	// add only those songs to playlist which exist in the album otherwise doesnt make snese
	public boolean addToPlaylist(int trackNumber,LinkedList<Song> PlayList) {
//		For example, an arrayList with a size of 5 means that the array list has 5 items, 
//		and the indexes of the items are 0, 1, 2, 3, and 4. Trying to access an index of 5
//		means you’re trying to access a 6th item, which doesn’t exist and is bigger than the arraylist’s size.
		
		int index = trackNumber - 1;
		if(index > 0 && index <= this.songs.size()) {
			PlayList.add(this.songs.get(index));
			return true;
		}
//		System.out.println("This album doesnt have song with track number"+trackNumber);
		return false;
		
	}
	
	public boolean addToPlaylist(String title,LinkedList<Song> PlayList) {
			for(Song checkedSong:this.songs) {
				if(checkedSong.getTitle().equals(title)) {
					PlayList.add(checkedSong);
					return true;
				}
			}
//			System.out.println(title+"There is no such song in album");
			return false;
		}
	
	
}
