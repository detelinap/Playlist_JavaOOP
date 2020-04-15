package playlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Playlist {
	private ArrayList<Album> albums = new ArrayList<Album>();
	private String nameOfPlaylist;
	static BufferedReader reader = 
			  new BufferedReader(new InputStreamReader(System.in));

	public Playlist() {
		super();
		this.albums = generateAlbums();
		System.out.println("What is  the name of the playlist?");
		try {
			this.nameOfPlaylist = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private ArrayList<Album> generateAlbums() {
		ArrayList<Album> albums = new ArrayList<Album>();
		boolean quit = false;
		while (quit == false) {
			Album a = new Album();
			albums.add(a);
			System.out.println("Would you like to continue with another album?");
			String answer = null;
			try {
				answer = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (answer.toLowerCase().equals("no")) {
				quit = true;
			}
		}
		return albums;
	}
	
	public void printPlaylist() {
		System.out.println("Your playlist called "+ nameOfPlaylist+ "  has the following songs: ");
		for (Album album : albums) {
			album.printAlbum();
		}
	}

}
