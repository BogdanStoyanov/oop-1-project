public class Cleaner implements Worker{
    private String fullName;

    public Cleaner(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String workDescription() {
        return "Cleaner "+fullName+" is cleaning";
    }
}
