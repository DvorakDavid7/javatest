import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class PDFMaker {

    public static void createPdf(String text) {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();

        PDFont font = PDType1Font.HELVETICA;
        final int FONTSIZE = 12;

        document.addPage(page);

        try {
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.beginText();
            contentStream.setFont(font,FONTSIZE);
            contentStream.newLineAtOffset(100,500);
            contentStream.setLeading(14.5f);

            addTextToPdfDocument(contentStream, text);

            contentStream.endText();
            contentStream.close();

            document.save("test.pdf");
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addTextToPdfDocument(PDPageContentStream contentStream, String content) throws IOException {
        String[] lines = content.split("\n");
        for (String line : lines) {
            if (!line.equals("")) {
                contentStream.showText(line);
            }
            contentStream.newLine();
        }
    }
}
