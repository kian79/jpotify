import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;

public class LeftBar extends Panel {
    AddPlaylistListener listener=null;
    Button AddBtn=new Button("Add");
    JLabel text=new JLabel();
    Button home=new Button("Home");

    public void setListener(AddPlaylistListener listener) {
        this.listener = listener;
    }

    Button btn2=new Button("browse");
    Button btn3=new Button("Library");
    Button btn4=new Button("Song");
    Button btn5=new Button("Albums");
        public LeftBar(){
            Color bright =new Color(194,194,194);
            Color dark=new Color(24,24,24);
            AddBtn.setIcon(new ImageIcon("plus.png"));
            text.setText("Your menu kian merge");
            home.setBackground(dark);
            home.setForeground(bright);
            text.setForeground(dark);
            AddBtn.setBackground(dark);
            AddBtn.setForeground(bright);
            AddBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    jfc.setDialogTitle("Multiple file and directory selection:");
                    jfc.setMultiSelectionEnabled(true);
                    jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

                    int returnValue = jfc.showDialog(null,"انتخاب موزیک");
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File[] files = jfc.getSelectedFiles();
                        System.out.println("Directories found\n");
                        Arrays.asList(files).forEach(x -> {
                            if (x.isDirectory()) {
                                System.out.println(x.getName());
                            }
                        });
                        System.out.println("\n- - - - - - - - - - -\n");
                        System.out.println("Files Found\n");
                        Arrays.asList(files).forEach(x -> {
                            if (x.isFile()) {
                                listener.addToPlayList(x);
                            }
                        });
                    }
                }
            });
            this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
            this.add(text);
            this.add(home);
            this.add(btn2);
            this.add(btn3);
            this.add(btn4);
            this.add(btn5);
            this.add(AddBtn,BorderLayout.PAGE_END);
        }
}

