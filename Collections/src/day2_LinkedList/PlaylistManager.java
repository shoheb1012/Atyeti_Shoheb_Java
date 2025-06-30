package day2_LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class PlaylistManager {

    static LinkedList<String> listOfSongs = new LinkedList<>();
    static ListIterator<String> iterator = listOfSongs.listIterator();
    static boolean goingForward = true;
    static String currentSong = null;

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Playlist Menu ---");
            System.out.println("1: Add song at end");
            System.out.println("2: Add song at start");
            System.out.println("3: Play next song");
            System.out.println("4: Play previous song");
            System.out.println("5: Show all songs");
            System.out.println("6: Remove current song");
            System.out.println("7: Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter the Song name: ");
                    String songName = sc.nextLine();
                    addSongAtEnd(songName);
                    break;

                case 2:
                    System.out.print("Enter the Song name: ");
                    String songNameAtStart = sc.nextLine();
                    addSongAtStart(songNameAtStart);
                    break;

                case 3:
                    playNextSong();
                    break;

                case 4:
                    playPreviousSong();
                    break;

                case 5:
                    showAllSongs();
                    break;

                case 6:
                    removeCurrentSong();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Option. Try again.");
            }
        }
    }

    private static void addSongAtEnd(String songName) {
        listOfSongs.addLast(songName);
        resetIterator();
        System.out.println("Added song to end: " + songName);
    }

    private static void addSongAtStart(String songNameAtStart) {
        listOfSongs.addFirst(songNameAtStart);
        resetIterator();
        System.out.println("Added song to start: " + songNameAtStart);
    }

    private static void playNextSong() {
        if (listOfSongs.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (!goingForward) {
            if (iterator.hasNext()) iterator.next();
            goingForward = true;
        }

        if (iterator.hasNext()) {
            currentSong = iterator.next();
            System.out.println("Now playing: " + currentSong);
        } else {
            System.out.println("You are at the end of the playlist.");
        }
    }

    private static void playPreviousSong() {
        if (listOfSongs.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (goingForward) {
            if (iterator.hasPrevious()) iterator.previous();
            goingForward = false;
        }

        if (iterator.hasPrevious()) {
            currentSong = iterator.previous();
            System.out.println("Now playing: " + currentSong);
        } else {
            System.out.println("You are at the beginning of the playlist.");
        }
    }

    private static void showAllSongs() {
        if (listOfSongs.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("All Songs:");
        int i = 1;
        for (String song : listOfSongs) {
            System.out.println(i++ + ". " + song);
        }
    }

    private static void removeCurrentSong() {
        if (currentSong == null) {
            System.out.println("No song is currently playing.");
            return;
        }

        iterator.remove();
        System.out.println("Removed current song: " + currentSong);
        currentSong = null;
    }

    private static void resetIterator() {
        iterator = listOfSongs.listIterator();
        currentSong = null;
        goingForward = true;
    }
}
