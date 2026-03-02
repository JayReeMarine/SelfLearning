#include "splashkit.h"
#include "utilities.h"
#include <string>

using std::to_string;

const int MAX_SONGS = 100;

/**
 * The data structure to store song data
 *
 * @field name the name of the song
 * @field unique_id the unique identifier for the song (e.g. "song-0")
 * @field path the file path of the song
 * @field loved whether the song is loved or not
 * @field times_played the number of times the song has been played
 */
struct song_data
{
    string name;
    string unique_id;
    string path;
    bool loved;
    int times_played;
};

/**
 * The data structure for the music player
 *
 * @field songs an array to store the song data
 * @field num_songs the number of songs currently stored
 * @field next_id the number for the next song ID
 */
struct music_player
{
    song_data songs[MAX_SONGS];
    int num_songs;
    int next_id;
};

/**
 * Add a new song to the music player.
 * Prompts the user for name, path, and loved status.
 * Assigns a unique ID and loads the music file.
 *
 * @param player the music player to add the song to
 */
void add_song(music_player &player)
{
    if (player.num_songs >= MAX_SONGS)
    {
        write_line("Music player is full!");
        return;
    }

    song_data new_song;

    new_song.name = read_string("Enter song name: ");
    new_song.path = read_string("Enter file path: ");
    new_song.loved = read_string("Loved? (yes/no): ") == "yes";
    new_song.unique_id = "song-" + to_string(player.next_id);
    new_song.times_played = 0;

    load_music(new_song.unique_id, new_song.path);

    player.songs[player.num_songs] = new_song;
    player.num_songs++;
    player.next_id++;

    write_line(new_song.name + " added!");
}

/**
 * Search for a song by name and let the user select one from
 * the matching results. Returns the index of the selected song,
 * or -1 if no songs are found or selection is invalid.
 *
 * @param player the music player to search in
 * @returns the index of the selected song, or -1
 */
int search_song(music_player &player)
{
    if (player.num_songs == 0)
    {
        write_line("No songs in the music player.");
        return -1;
    }

    string search = read_string("Enter name to search: ");

    bool found_any = false;
    for (int i = 0; i < player.num_songs; i++)
    {
        if (contains(player.songs[i].name, search))
        {
            write_line(to_string(i) + ": " + player.songs[i].name);
            found_any = true;
        }
    }

    if (!found_any)
    {
        write_line("No matching songs found.");
        return -1;
    }

    int choice = read_integer("Select song number: ");
    if (choice < 0 || choice >= player.num_songs)
    {
        write_line("Invalid song number.");
        return -1;
    }

    return choice;
}

/**
 * Play a selected song and increment its play count.
 * Uses search_song to let the user choose which song to play.
 *
 * @param player the music player to play music from
 */
void play_song(music_player &player)
{
    int index = search_song(player);
    if (index == -1) return;

    player.songs[index].times_played++;
    play_music(player.songs[index].unique_id);
    write_line("Playing: " + player.songs[index].name);
}

/**
 * Toggle between pausing and resuming the currently playing music.
 */
void pause_resume_song()
{
    if (music_playing())
    {
        pause_music();
        write_line("Music paused.");
    }
    else
    {
        resume_music();
        write_line("Music resumed.");
    }
}

/**
 * Update a song's details. User can change name, toggle loved status,
 * reset play count, or delete the song. Menu repeats until user quits.
 *
 * @param player the music player to update from
 */
void update_song(music_player &player)
{
    int index = search_song(player);
    if (index == -1) return;

    bool quit = false;
    while (!quit)
    {
        write_line("");
        write_line("Updating: " + player.songs[index].name);
        write_line("1: Update name");
        write_line("2: Toggle loved");
        write_line("3: Reset times played");
        write_line("4: Delete");
        write_line("5: Quit update");

        int choice = read_integer("Choose: ");

        if (choice == 1)
        {
            player.songs[index].name = read_string("Enter new name: ");
        }
        else if (choice == 2)
        {
            player.songs[index].loved = !player.songs[index].loved;
        }
        else if (choice == 3)
        {
            player.songs[index].times_played = 0;
        }
        else if (choice == 4)
        {
            for (int i = index; i < player.num_songs - 1; i++)
            {
                player.songs[i] = player.songs[i + 1];
            }
            player.num_songs--;
            write_line("Song deleted.");
            quit = true;
        }
        else if (choice == 5)
        {
            quit = true;
        }
    }
}

/**
 * Print a status report showing:
 * - total number of songs
 * - total number of times songs have been played
 * - total number of loved songs
 *
 * @param player the music player to get information from
 */
void print_status(music_player &player)
{
    int total_played = 0;
    int loved_count = 0;

    for (int i = 0; i < player.num_songs; i++)
    {
        total_played += player.songs[i].times_played;

        if (player.songs[i].loved)
        {
            loved_count++;
        }
    }

    write_line("");
    write_line("Number of songs: " + to_string(player.num_songs));
    write_line("Total times played: " + to_string(total_played));
    write_line("Loved songs: " + to_string(loved_count));
}

int main()
{
    music_player player;
    player.num_songs = 0;
    player.next_id = 0;

    bool running = true;
    while (running)
    {
        write_line("");
        write_line("=== Music Player ===");
        write_line("1: Add a song");
        write_line("2: Update a song");
        write_line("3: Play a song");
        write_line("4: Pause/Resume");
        write_line("5: Print status");
        write_line("6: Quit");

        int choice = read_integer("Choose an option: ");

        if (choice == 1)
        {
            add_song(player);
        }
        else if (choice == 2)
        {
            update_song(player);
        }
        else if (choice == 3)
        {
            play_song(player);
        }
        else if (choice == 4)
        {
            pause_resume_song();
        }
        else if (choice == 5)
        {
            print_status(player);
        }
        else if (choice == 6)
        {
            running = false;
        }
        else
        {
            write_line("Invalid option, try again.");
        }
    }

    write_line("Thank you for using the music player. Goodbye!");
    return 0;
}
