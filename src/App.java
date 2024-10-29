import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        
        ArrayList<Song> songs = SongImporter.importSongsFromCSV("songs.csv");

        // Variables to compute statistics on songs
        int totalNumberOfSongs = 0;
        int totalNumberOfSongsFrom1982 = 0;
        int totalNumberOfSongsFrom1998 = 0;
        int totalNumberOfSongsFrom2011 = 0;
        // Don't directly store the max lenght as an integer
        // Instead store the entire song that has the current max length.
        // This way we don't have multiple variables in this context, they are all packaged together into the Song. 
        Song maxLength = new Song();
        Song minShake = new Song();
        // Initialize the starting value to be larger than any expected input. 
        minShake.setShakeTheAudience(1.0); 
        Song loudest = new Song();

        // Creating an average class keeps this logic clean.
        // Otherwise would have: int obscene1950sCount, double obscene1950s...
        Average obscene1950s = new Average();
        Average obscene1960s = new Average();
        Average obscene1970s = new Average();
        Average obscene1980s = new Average();
        Average obscene1990s = new Average();
        Average obscene2000s = new Average();
        Average obscene2010s = new Average();

        // Loop through songs and update statistics
        for (int i=0; i<songs.size(); i++)
        {
            Song s = songs.get(i);

            // Update total number of songs
            totalNumberOfSongs++;

            if (s.getReleaseDate() == 1982)
            {
                totalNumberOfSongsFrom1982++;
            }

            if (s.getReleaseDate() == 1998)
            {
                totalNumberOfSongsFrom1998++;
            }

            if (s.getReleaseDate() == 2011)
            {
                totalNumberOfSongsFrom2011++;
            }

            if (s.getLength() > maxLength.getLength())
            {
                maxLength = s;
            }

            if (s.getShakeTheAudience() < minShake.getShakeTheAudience())
            {
                minShake = s;
            }

            if (s.getLoudness() > loudest.getLoudness())
            {
                loudest = s;
            }

            if (s.getReleaseDate() >= 1950 && s.getReleaseDate() < 1960)
            {
                obscene1950s.addSample(s.getObscene());
            }

            if (s.getReleaseDate() >= 1960 && s.getReleaseDate() < 1970)
            {
                obscene1960s.addSample(s.getObscene());
            }

            if (s.getReleaseDate() >= 1970 && s.getReleaseDate() < 1980)
            {
                obscene1970s.addSample(s.getObscene());
            }

            if (s.getReleaseDate() >= 1980 && s.getReleaseDate() < 1990)
            {
                obscene1980s.addSample(s.getObscene());
            }

            if (s.getReleaseDate() >= 1990 && s.getReleaseDate() < 2000)
            {
                obscene1990s.addSample(s.getObscene());
            }

            if (s.getReleaseDate() >= 2000 && s.getReleaseDate() < 2010)
            {
                obscene2000s.addSample(s.getObscene());
            }

            if (s.getReleaseDate() >= 2010 && s.getReleaseDate() < 2020)
            {
                obscene2010s.addSample(s.getObscene());
            }
        }       

        // Output Report
        System.out.println("Total number of songs: " + totalNumberOfSongs);
        System.out.println("Total number of songs from 1982: " + totalNumberOfSongsFrom1982);
        System.out.println("Total number of songs from 1998: " + totalNumberOfSongsFrom1998);
        System.out.println("Total number of songs from 2011: " + totalNumberOfSongsFrom2011);
        System.out.println("The song with the largest length is: " + maxLength.getTrackName() + " by: " + maxLength.getArtistName() + ", length: " + maxLength.getLength());
        System.out.println("The song with the lowest shakability is: " + minShake.getTrackName() + " by: " + minShake.getArtistName() + ", shakeability: " + minShake.getShakeTheAudience());
        System.out.println("The loudest song is: " + loudest.getTrackName() + " by: " + loudest.getArtistName() + ", loudness: " + loudest.getLoudness());

        System.out.println("Average obscenity in the 1950s: " + obscene1950s.getAverage());
        System.out.println("Average obscenity in the 1960s: " + obscene1960s.getAverage());
        System.out.println("Average obscenity in the 1970s: " + obscene1970s.getAverage());
        System.out.println("Average obscenity in the 1980s: " + obscene1980s.getAverage());
        System.out.println("Average obscenity in the 1990s: " + obscene1990s.getAverage());
        System.out.println("Average obscenity in the 2000s: " + obscene2000s.getAverage());
        System.out.println("Average obscenity in the 2010s: " + obscene2010s.getAverage());
    }
}