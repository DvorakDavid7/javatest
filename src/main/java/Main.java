


public class Main {
    public static void main(String[] args) {
        String rawText = Convertor.getTextFromDocxFile();
        PDFMaker.createPdf(rawText);
    }
}
