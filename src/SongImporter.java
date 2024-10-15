import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SongImporter
{
    public static ArrayList<Song> importSongsFromCSV(String filename)
    {
        ArrayList<Song> songs = new ArrayList<Song>();
        try {
            File file = new File(filename);
            Scanner csv = new Scanner(file);

            // First line is a header
            // artist_name, track_name, release_date, genre, len, shake the audience, obscene, danceability, loudness, topic
            String header_fields = csv.nextLine();
            
            while (csv.hasNextLine()) {
                String line = csv.nextLine();
                String[] fields = line.split(",");
                // Construct a song object using the fields.
                System.out.println("Field 0: " + fields[0]);
                // Replace the next line with your song constructor
                Song song = new Song(); // code to construct a song object
                songs.add(song);
            }
            csv.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return songs;
    }
}