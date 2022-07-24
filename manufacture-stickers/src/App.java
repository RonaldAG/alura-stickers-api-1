import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        // Establish a HTTP connection and request information for a URL
        var clientHttp = new ClientHttp();
        String json = clientHttp.requestInformation(ApiUrl.TECHNOLOGIES_PICTURES.getLink());

        // Extract only requested datas
        var personalAPIContent = new TechnologiesContentExtract();
        List<Content> contentExtract = personalAPIContent.contentExtract(json);

        // Transform the url's image of the API content in costums stickers
        var geradora = new StickerGenerate();
        for (Content content : contentExtract) {
                String urlImage = content.urlImage();
                String title = content.title();
    
                InputStream inputStream = new URL(urlImage).openStream();
                String fileName = title + ".png";
    
                geradora.cria(inputStream, fileName, title);
    
                System.out.println(title);
                System.out.println();
        }
    }
}
