package bg.tu_varna.sit.a2.f23621757.user;

public class CurrentUser {
    private  boolean hasOpenedFile;
    private  boolean hasLoggedIn;
    private String currentFileName;

    public CurrentUser(boolean hasOpenedFile, boolean hasLoggedIn, String currentFileName) {
        this.hasOpenedFile = hasOpenedFile;
        this.hasLoggedIn = hasLoggedIn;
        this.currentFileName = currentFileName;
    }

    public boolean isHasOpenedFile() {
        return hasOpenedFile;
    }

    public void setHasOpenedFile(boolean hasOpenedFile) {
        this.hasOpenedFile = hasOpenedFile;
    }

    public boolean isHasLoggedIn() {
        return hasLoggedIn;
    }

    public void setHasLoggedIn(boolean hasLoggedIn) {
        this.hasLoggedIn = hasLoggedIn;
    }

    public String getCurrentFileName() {
        return currentFileName;
    }

    public void setCurrentFileName(String currentFileName) {
        this.currentFileName = currentFileName;
    }
}
