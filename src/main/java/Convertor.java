

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;

public class Convertor {

    public static String getTextFromDocxFile() {

        try {
            XWPFDocument docx = new XWPFDocument(new FileInputStream("Document.docx"));

            XWPFWordExtractor we = new XWPFWordExtractor(docx);
            return we.getText();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
