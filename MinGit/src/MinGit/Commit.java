package MinGit;

import java.io.File;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

public class Commit implements Serializable {
    private String message;
    private Instant committedAt;
    private String parent;
    private HashMap<File, String> fileShaMap;

    public Commit() {
        message = "Initial Commit";
        committedAt = Instant.EPOCH;
        parent = null;
        fileShaMap = null;
    }

    @Override
    public String toString() {
        return "Commit{" +
                "message='" + message + '\'' +
                ", committedAt=" + committedAt +
                ", parent='" + parent + '\'' +
                '}';
    }
}
