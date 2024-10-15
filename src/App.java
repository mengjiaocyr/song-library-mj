import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Song s = new Song();
        System.out.println(s);

        ArrayList<Song> songs = SongImporter.importSongsFromCSV("songs.csv");

        System.out.println("\n Example from returned songs ArrayList:");
        System.out.println(songs.get(2));
    }
}

