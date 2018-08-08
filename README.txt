project folder:
Veronika131-cs1c-project04/



Brief description of submitted files:


docs/
    -   JavaDocs folder based on source code

lib/
    -   library folder with json-simple-1.1.1.jar file that's used for parsing JSON file.



src/cs1c/MillionSongDataSubset.java
    -   Parses a JSON data set and stores each entry in an array.

src/cs1c/SongEntry.java
    -   Stores a simplified version of the genre data set from the Million Song Dataset.

src/cs1c/TimeConverter.java
    -   Converts duration into a string representation.



src/queues/Jukebox.java
    -   Jukebox manages three objects of type Queue<String>.

src/queues/MyTunes.java
    -   Partially simulate the digital jukebox TouchTunes using a queue which holds playlist.

src/queues/Queue.java
    -   Queue manages items in a singly linked list where we can enqueue() and dequeue() items.



resources/music_genre_subset.json
    -   Input data file that holds over 59600 songs used by MyTunes.java and Jukebox.java.

resources/RUN.txt
    -   Various test outputs of MyTunes class that display different play lists of songs based
        on requested file and number of songs to be played.

resources/tunes.txt
    -   Testing Jukeboxs class by enqueuing songs into different playlists and
        by requesting to play less songs than the total number of songs in file.

resources/tunes_test3.txt
    -   Testing file that has songs only in 2 out of 3 playlists.

resources/tunes_test4.txt
    -   Testing file that has no songs in any of the playlists.

resources/tunes_truncated.txt
    -   Testing the boundary condition where requested number of songs is bigger than
        total number of songs in file.



.gitignore
    -   .gitignore content tells git to ignore specified things.

README.txt
    -   Description of submitted files.