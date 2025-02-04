public class Song
{
  // Private instance variables
  private String artistName = "Unknown Artist";
  private String trackName = "Unknown";
  private Integer releaseDate = 1000;
  private String genre = "N/A";
  private Integer length = 0;
  private Double shakeTheAudience = 0.0;
  private Double obscene = 0.0;
  private Double danceability = 0.0;
  private Double loudness = 0.0;
  private String topic = "N/A";

  // Default constructor
  public Song(){} 

  // Overloaded constructor
  public Song(String artistName, String trackName, Integer releaseDate, String genre, Integer length, Double shakeTheAudience, Double obscene, Double danceability, Double loudness, String topic) 
  {
    // note usage of this to assign to the instance variables
    this.artistName = artistName;
    this.trackName = trackName;
    this.releaseDate = releaseDate;
    this.genre = genre;
    this.length = length;
    this.shakeTheAudience = shakeTheAudience;
    this.obscene = obscene;
    this.danceability = danceability;
    this.loudness = loudness;
    this.topic = topic;
  }

  // toString for printing the object
  public String toString()
  {
    return artistName + ", " + trackName + ", " + releaseDate + ", " + genre + ", " + length + ", " + shakeTheAudience + ", " + obscene + ", " + danceability + ", " + loudness + ", " + topic;
  }
  
  // Getters for getting private instance variables
  public String getArtistName()
  {
    return artistName;
  }

  public String getTrackName()
  {
    return trackName;
  }

  public Integer getReleaseDate()
  {
    return releaseDate;
  }

  public String getGenre()
  {
    return genre;
  }

  public Integer getLength()
  {
    return length;
  }

  public Double getShakeTheAudience()
  {
    return shakeTheAudience;
  }

  public void setShakeTheAudience(Double shakeTheAudience)
  {
    this.shakeTheAudience = shakeTheAudience;
  }

  public Double getObscene()
  {
    return obscene;
  }

  public Double getDanceability()
  {
    return danceability;
  }

  public Double getLoudness()
  {
    return loudness;
  }

  public String getTopic()
  {
    return topic;
  }
}