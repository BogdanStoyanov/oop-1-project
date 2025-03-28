package bg.tu_varna.sit.a2.f23621757.user;

public class CurrentUser {
    private  boolean hasOpenedFile;
    private String currentFileName;
    private  boolean hasLoggedIn;
    private boolean isAdmin;


    public CurrentUser(boolean hasOpenedFile, String currentFileName, boolean hasLoggedIn, boolean isAdmin) {
        this.hasOpenedFile = hasOpenedFile;
        this.currentFileName = currentFileName;
        this.hasLoggedIn = hasLoggedIn;
        this.isAdmin = isAdmin;
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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
