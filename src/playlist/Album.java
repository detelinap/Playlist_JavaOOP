package playlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Album {
	private LinkedList<Song> album = new LinkedList<Song>();
	private String name;
	static BufferedReader reader = 
			  new BufferedReader(new InputStreamReader(System.in));
	
	public Album() {
		System.out.println("What is the name of your album?");
		try {
			this.name = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			this.album = fillAlbum(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private LinkedList<Song> getAlbum() {
		return album;
	}


	private String getName() {
		return name;
	}

	public void addToAlbum(Song a) {
		if (!isSongInAlbum(a.getTitle())) {
		album.add(a);
		System.out.println("The song " + a.getTitle() + " has been added.");}else {
			System.out.println("The song is already in the album, so it has not been added.");
		}
		
	}

	public void removeFromAlbum(Song a) {
		album.remove(a);
		System.out.println("The song " + a.getTitle() + " has been removed.");

	}

	public boolean isSongInAlbum(String title) {
		for (Song check : album) {
			if(check.getTitle().equals(title)) {
				return true;
			}
		} return false;

	}
	
	private LinkedList<Song> fillAlbum (String name) throws IOException{
		System.out.println("The album "+name+" can be filled");
		LinkedList<Song> album = new LinkedList<Song>();
		boolean quit = false;
		while (quit == false) {
			Song song = addSong();
			album.add(song);
			System.out.println("Would you like to continue with another song for this album?");
			String answer = reader.readLine();
			if (answer.toLowerCase().equals("no")) {
				quit = true;
			}			
		}		
		return album;		
	}
	
	public Song addSong () {
		System.out.println("What is the name of the song?");
		String name = null;
		try {
			name = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("What is the duration of the song?");
		String durationBuffer = null;
		try {
			durationBuffer = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double duration = Double.valueOf(durationBuffer).doubleValue();
		Song song = new Song (name,duration);
		return song;
		
	}
	
	public void printAlbum() {
		int a = 1;
		System.out.println("___________________________________________________________________");
		System.out.println("The name of the "+a+" album is "+getName()+" and it has "+getAlbum().size()+" songs.");
		System.out.println("___________________________________________________________________");
		a++;
		int i = 1;
		for (Song song : album ) {
		System.out.println("The name of the "+i+" song is "+song.getTitle()+" and the duration is "+song.getDuration());
		i++;
	}}


}