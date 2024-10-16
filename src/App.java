import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        
        ArrayList<Song> songs = SongImporter.importSongsFromCSV("songs.csv");

        for (int i=0; i<songs.size(); i++)
        {
            Song s = songs.get(i);
            System.out.println(s);
            //System.out.println("Artist:" + s.getArtist() + " Title: " + s.getTitle());
        }       
    }
}