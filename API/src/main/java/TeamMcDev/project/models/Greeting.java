package TeamMcDev.project.models;

public class Greeting {
    //Greeting class will provide structure for JSON data to be returned to user; ID data and a basic greeting.
    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
