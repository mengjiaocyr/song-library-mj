import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class SongImporter
{
    public static ArrayList<Song> importSongsFromCSV(String filename)
    {
        ArrayList<Song> songs = new ArrayList<Song>();
        int lineNumber = 0;
        try {
            File file = new File(filename);
            Scanner csv = new Scanner(file);
            csv.useDelimiter(",");

            // First line is a header - read it into a string (basically just to throw it away)
            // artist_name, track_name, release_date, genre, len, shake the audience, obscene, danceability, loudness, topic
            String header_fields = csv.nextLine();

            while (csv.hasNextLine()) {
                if (lineNumber > 30)
                {
                    //break;
                }

                lineNumber++; // Keep track of line numbers to make inspection of data errors simpler.

                // This puts the next line of the file into a String named line.
                String line = csv.nextLine();

                String[] fields = splitLine(line);

                // Each field is given a name to simply their usage in constructing songs. 
                String artistName = fields[0];
                String trackName = fields[1];
                Integer releaseDate = Integer.parseInt(fields[2]);
                // int releaseDate = Integer.parseInt(fields[2]); or you can use int instead of Integer.
                String genre = fields[3];
                Integer length = Integer.parseInt(fields[4]);
                Double shakeTheAudience = Double.parseDouble(fields[5]);
                Double obscene = Double.parseDouble(fields[6]);
                Double danceability = Double.parseDouble(fields[7]);
                Double loudness = Double.parseDouble(fields[8]);
                String topic = fields[9];

                // Debug print
                //System.out.println("artist: " + artist + " length: " + length + "topic: " + topic);

                // Replace the next line with your song constructor
                Song song = new Song(artistName, trackName, releaseDate, genre, length, shakeTheAudience, obscene, danceability, loudness, topic); // code to construct a song object

                // Add the song object to the data output to array.
                songs.add(song);
            }
            csv.close();
        } catch (Exception ex) {
            System.out.println("Error on line: " + lineNumber);
            ex.printStackTrace();
        }
        return songs;
    }

    public static String[] splitLine(String line)
    {
         // The string is then split on each comma into an array of fields.
         String[] inputFields = line.split(",");
         
         // Output: 10 fields, create an empty array of strings
        String[] outputFields = new String[10];

        int outputIndex = 0;
        int inputIndex = 0;
        boolean concatenate = false;
        while (inputIndex < inputFields.length)
        {
            String inputField = inputFields[inputIndex]; // "Clean" copy
            String outputField = inputFields[inputIndex]; // Make small changes to correct output
            
            // Update string contents
            if (concatenate == true)
            {
                outputField = outputField + ","; // split "ate" the comma, add it back.
            }
            else
            {
                outputFields[outputIndex] = ""; // Initialize empty string
            }

            // Match the start of a quoted string
            if (inputField.substring(0,1).equals("\""))
            {
                concatenate = true;
                outputField = outputField.substring(1); // Remove the starting quote
                outputField = outputField + ","; // split "ate" the comma, add it back.
                
            }

            // Match the end of a quoted string
            if (inputField.substring(inputField.length()-1).equals("\""))
            {
                concatenate = false;
                outputField = outputField.substring(0, outputField.length()-2); // Remove the ending quote and comma
            }

            outputFields[outputIndex] += outputField;

            // Update input and output indexes
            if (concatenate == false)
            {
                // Output index only increments when not in concatenation mode.
                outputIndex++;
            }
            // Input index always increments
            inputIndex++;
        }
        return outputFields;
    }
}