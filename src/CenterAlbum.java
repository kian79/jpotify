import javafx.scene.layout.Pane;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CenterAlbum extends Panel implements MakeAlbumListener {
    ArrayList<Album> albums = new ArrayList<>();
    ChoosePlaylist choosePlaylist = null;
    MakeVisibilityTrue makeVisibilityTrue=null;

    public void setMakeVisibilityTrue(MakeVisibilityTrue makeVisibilityTrue) {
        this.makeVisibilityTrue = makeVisibilityTrue;
    }

    public CenterAlbum() {
        super(3);
        this.setLayout(new FlowLayout());
    }

    public void setChoosePlaylist(ChoosePlaylist choosePlaylist) {
        this.choosePlaylist = choosePlaylist;
    }

    @Override
    public void makeAlbum(String name, ArrayList<Song> songs) {
        System.out.println("dare mirize");
        Album album = new Album(name, songs);
        AlbumGUI albumGUI = new AlbumGUI(album);
        albums.add(album);
        this.add(albumGUI);
        albumGUI.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                choosePlaylist.setAlbum(album);
                makeVisibilityTrue.makeTrue(0);
            }
        });
        choosePlaylist.setAlbum(album);
        revalidate();
    }
}
