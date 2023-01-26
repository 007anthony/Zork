package ch.bbw.zork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Map {

    private Room[] rooms;

    public Map(Room... rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        String result = "";

        result = "|" + "-".repeat(6) + "|" + " ".repeat(6);
        result = "|" + " ".repeat(6) + "|" + " ".repeat(6);
        return result;

    }
}
