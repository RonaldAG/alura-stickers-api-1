import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.FontMetrics;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerGenerate {

    public void cria(InputStream inputStream, String nomeArquivo, String description) throws Exception {

        // Read image in a file
        BufferedImage originalImage = ImageIO.read(inputStream);

        // Create a image that will be the background of the main image
        int stickerWidth = 400;
        int resizedHeight = (originalImage.getHeight() * stickerWidth) / originalImage.getWidth();
        int newHeight = resizedHeight + 50;
        BufferedImage novaImagem = new BufferedImage(stickerWidth, newHeight, BufferedImage.TRANSLUCENT);

        // Create a new image that will override the original
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(originalImage, stickerWidth/2 - originalImage.getHeight()/2, 0, null);

        // set the font
        var fonte = new Font("Comic Sans MS", Font.BOLD, 50);
        graphics.setColor(Color.GREEN);
        graphics.setFont(fonte);
        graphics.setBackground(Color.BLACK);
        FontMetrics phraseSize = graphics.getFontMetrics(fonte);

        // white a legend
        String[] needNextLine = needBreakDescription(description);
        if (needNextLine != null) {
            graphics.drawString(needNextLine[0], stickerWidth / 2 - phraseSize.stringWidth(needNextLine[0]) / 2,
                    newHeight - 45);
            graphics.drawString(needNextLine[1], stickerWidth / 2 - phraseSize.stringWidth(needNextLine[1]) / 2,
                    newHeight - 10);
        } else {
            int legendPosition = (resizedHeight - originalImage.getHeight()) / 2;
            graphics.drawString(description, stickerWidth / 2 - phraseSize.stringWidth(description) / 2,
                    newHeight - legendPosition);

        }

        // build the image and save it in a folder
        ImageIO.write(novaImagem, "png", new File("manufacture-stickers/images/" + nomeArquivo));

    }

    
    private String[] needBreakDescription(String description) {
        if (description.length() > 25) {
            String[] text = new String[2];
            text[0] = description.substring(0, 25);
            text[1] = description.substring(25);
            return text;
        }
        return null;
    }
}