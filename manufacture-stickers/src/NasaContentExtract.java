import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtract implements ContentExtract {

    public List<Content> contentExtract(String json) {
        List<Map<String, String>> mapList = parser.parse(json);

        List<Content> contents = new ArrayList<>();

        // add the mapList elements in the contents list
        for (Map<String, String> atributos : mapList) {
            String title = atributos.get("title");
            String urlImage = atributos.get("hdurl");

            var content = new Content(title, urlImage);

            contents.add(content);
        }

        return contents;
    }
}
