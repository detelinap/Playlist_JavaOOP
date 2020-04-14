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
	
	public Album(LinkedList<Song> album, String name) {
		super();
		try {
			this.album = fillAlbum(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.name = name;
	}

	private LinkedList<Song> getAlbum() {
		return album;
	}

	private void setAlbum(LinkedList<Song> album) {
		this.album = album;
	}

	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public void addToAlbum(Song a) {
		album.add(a);
		System.out.println("The song " + a.getTitle() + " has been added.");
	}

	public void removeFromAlbum(Song a) {
		album.remove(a);
		System.out.println("The song " + a.getTitle() + " has been removed.");

	}

	public void searchInAlbum(Song a) {
		if (album.contains(a)) {
			System.out.println("This song is already in the album");
			
		} else {
			System.out.println("This song is not in the album");
		}

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double duration = Double.valueOf(durationBuffer).doubleValue();
		Song song = new Song (name,duration);
		return song;
		
	}
	
	public void printAlbum() {
		System.out.println("The name of the album is "+getName()+" and it has "+getAlbum().size()+" songs.");
		for (Song song : album ) {
		System.out.println("The name of the  song is "+song.getTitle()+" and the duration is "+song.getDuration());
	}}


}