import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import javazoom.jl.decoder.JavaLayerException;

import java.io.IOException;
import java.util.ArrayList;

public class Album {
    private ArrayList<Song> songs = new ArrayList<>();

    public ArrayList<SongGUI> getGuis() {
        return guis;
    }

    private ArrayList<SongGUI> guis = new ArrayList<>();

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getPath() {
        return path;
    }

    public int getNum() {
        return num;
    }

    private String name;
    private String artist;
    private String path;
    private int num;

    public Album(String name, ArrayList<Song> songs) {
        this.name = name;

        //getting songs
        this.songs=songs;
        for (Song song:songs) {
            guis.add(new SongGUI(song));
        }
        num = songs.size();
        artist = songs.get(0).artist;
    }
}
