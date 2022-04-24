package MinGit;

import java.io.File;
import java.util.HashMap;

public class StagingArea {
    static HashMap<File, String> filesStagedForAddition = new HashMap<>();

    public static void addFileForAddition(File file) {
        String shaOfFile = Utils.sha1(file);

    }

}
