import java.util.List;

public interface ContentExtract {
    public final JsonParser parser = new JsonParser();

    
    public abstract List<Content> contentExtract(String json);
}
