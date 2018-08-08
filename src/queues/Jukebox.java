package queues;

import cs1c.SongEntry;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Jukebox class manages three objects of type Queue class. Class can read
 * a user requested file of songs to be added to appropriate play list.
 *
 * @author Foothill College, Veronika Cabalova Joseph
 */

public class Jukebox
{
    //class attributes
    private Queue<SongEntry> favoritePL;
    private Queue<SongEntry> roadTripPL;
    private Queue<SongEntry> loungePL;

    /**
     * Constructor initializes three objects of type Queue
     */
    Jukebox()
    {
        this.favoritePL = new Queue<>("favorites");
        this.roadTripPL = new Queue<>( "road trip");
        this.loungePL = new Queue<>( "lounge");
    }

    /**
     * this method reads the test file and then adds songs to one
     * of the three playlist queues
     * @param userRequestedFile String of file that user requests
     * @param allSongs SongEntry type list of all songs we have in store
     */
    public void fillPlaylists(String userRequestedFile, SongEntry[] allSongs)
    {
        File inFile = new File(userRequestedFile);

        try
        {
            Scanner input = new Scanner(inFile);

            //looping through user requested file of songs
            while (input.hasNextLine())
            {
                //reads new line in the file
                String line = input.nextLine();

                //splits the comma separated string from the line in file
                String [] tokens = line.split("[,]");

                String nameOfSong = tokens[1];
                String playlistType = tokens[0];

                //adds song that was found via findASong to appropriate playlist
                addSongsToPlaylist(playlistType, findASong(nameOfSong, allSongs));
            }
            //closing the input file resource
            input.close();
        }
        catch (FileNotFoundException e)
        {
            //e.printStackTrace();
            System.out.println("***File was not found.***");
        }
    }


    //========================= helper methods =========================

    /**
     * this method searches for a song to be found inside list of all the songs
     * @param titleOfSongToFind String that holds title of song that we are looking for
     * @param allSongs SongEntry type list of all songs we have in store
     * @return SongEntry of the song that was found
     */
    public SongEntry findASong(String titleOfSongToFind, SongEntry[] allSongs)
    {
        SongEntry foundSong = null;
        // loops through list of all songs
        for (int i = 0; i < allSongs.length; i++)
        {
            //find song title in allSongs that matches titleOfSongToFind from user requested file
            if (allSongs[i].getTitle().equals(titleOfSongToFind))
            {
                foundSong = allSongs[i];
                return foundSong;
            }
        }
        return foundSong;
    }

    /**
     * using switch, this method compares play list type and enqueues song
     * that was found into appropriate play list queue
     * @param playlistType type of the playlist
     * @param foundSong SongEntry of song that was found and needs to be enqueued
     */

    public void addSongsToPlaylist(String playlistType, SongEntry foundSong)
    {
        switch (playlistType)
        {
            case "favorites":
                favoritePL.enqueue(foundSong);
                break;

            case "road trip":
                roadTripPL.enqueue(foundSong);
                break;

            case "lounge":
                loungePL.enqueue(foundSong);
                break;

            default:
                break;
        }
    }


    //============================ getters ============================

    /**
     * getter method that gets favorite play list
     * @return queue with favorite play list
     */
    public Queue<SongEntry> getFavoritePL()
    {
        return favoritePL;
    }

    /**
     * getter method that gets road trip play list
     * @return queue with road trip play list
     */
    public Queue<SongEntry> getRoadTripPL()
    {
        return roadTripPL;
    }

    /**
     * getter method that gets lounge play list
     * @return queue with lounge play list
     */
    public Queue<SongEntry> getLoungePL()
    {
        return loungePL;
    }
}