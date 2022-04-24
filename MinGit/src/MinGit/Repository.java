package MinGit;

import java.io.File;
import java.io.IOException;

import static MinGit.Utils.*;

public class Repository {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File MIN_GIT = join(CWD, ".mingit");
    public static File COMMIT_DIR = join(MIN_GIT, "commits");
    static File rootShaCode = new File(COMMIT_DIR, "root.txt");


    /* TODO: fill in the rest of this class. */

    public static void init() throws IOException {
        MIN_GIT.mkdir();
        COMMIT_DIR.mkdir();
        Commit root = new Commit();
        byte[] rootSerialized = serialize(root);
        String rootSha = sha1(rootSerialized);
        File rootOutFile = join(COMMIT_DIR, rootSha);
        writeObject(rootOutFile, rootSerialized);
        rootShaCode.createNewFile();
        writeContents(rootShaCode, rootSha);
    }


}