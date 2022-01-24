package com.jash;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	private static ArrayList<Album> albums = new ArrayList<>();
	
	public static void main(String[] args) {
		
		// created 2 albums and added to an arraylist of albums
		
		Album album = new Album("Album1","AC/DC");
		album.addSong("TNT", 4.5);
		album.addSong("Highway to Hell", 3.5);
		album.addSong("ThunderStruck", 5.0);
		albums.add(album);
		
		
		album = new Album("Album2","Eminem");
		album.addSong("Rap God", 4.5);
		album.addSong("Not Afraid", 3.5);
		album.addSong("Lose Yourself", 5.0);
		albums.add(album);
	
		LinkedList<Song> playList_1 = new LinkedList<>();
		
		albums.get(0).addToPlaylist("TNT", playList_1);
		albums.get(0).addToPlaylist("Highway to Hell", playList_1);
		albums.get(1).addToPlaylist("Rap God", playList_1);
		albums.get(1).addToPlaylist("Lose Yourself", playList_1);
		
		play(playList_1);
	
	}
	private static void play(LinkedList<Song> playList) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listiterator = playList.listIterator();
		if(playList.size() == 0){
			System.out.println("This PLaylist has no song");
		}
		else {
			System.out.println("Now playing-" + listiterator.next().toString());
			printMenu();
		}
		while(!quit) {
			int action = sc.nextInt();
			
			switch(action) {
			case 0:
				System.out.println("PLaylist complete");
				quit = true;
				break;
			case 1:
				if(!forward) {
					if(listiterator.hasNext()) {
						listiterator.next();
					}
					forward = true;
				}
				if(listiterator.hasNext()) {
					System.out.println("Now playling"+ listiterator.next().toString());
				}else {
					System.out.println("No song available, reached to the end of the list");
					forward = false;
				}
				break;
			case 2:
				if(forward) {
					if(listiterator.hasPrevious()) {
						System.out.println("Now playing"+listiterator.previous());
					}
					else {
						System.out.println("We are at the first song");
						forward = false;
					}
					break;
				}
			case 3:
				if(forward) {
					if(listiterator.hasPrevious()) {
						System.out.println("Now playing"+listiterator.previous().toString());
						forward = false;
					}
					else {
						System.out.println("We are at the start of the list");	
					}
				}
				else {
						if(listiterator.hasNext()) {
							System.out.println("Now playing"+listiterator.next().toString());
					}
						else {
							System.out.println("Reached to the end of list");
						}
				}
				break;
			case 4:
				PrintList(playList);
				break;
			case 5:
				printMenu();
				break;
			case 6:
				if(playList.size()>0) {
					listiterator.remove();
					if(listiterator.hasNext()){
						System.out.println("Now playing"+listiterator.next().toString());
					}
					else {
						if(listiterator.hasPrevious())
						System.out.println("Now playing"+listiterator.previous().toString());
					}
				}
	}
			}
	}
	private static void printMenu() {
		System.out.println("Available Options\n press");
		System.out.println("0 - to quit\n"+
							"1 - to play next song\n" + 
							"2 - to play previous song\n" + 
							"3 - to replay current song\n" + 
							"4 - list of all songs\n" + 
							"5 - print all available options\n" +
							"6 - to delete current song");
		
	}
	
	private static void PrintList(LinkedList<Song> playlist) {
		Iterator<Song> iterator = playlist.iterator();
		System.out.println("---------------------------\n");
		
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		System.out.println("---------------------------\n");
		}
	
}
