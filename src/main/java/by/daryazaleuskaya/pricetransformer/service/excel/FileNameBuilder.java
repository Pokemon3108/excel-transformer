package by.daryazaleuskaya.pricetransformer.service.excel;

public class FileNameBuilder {

    public String transformFilename(String filename) {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be null or empty");
        }
        int lastDotIndex = filename.lastIndexOf(".");
        if (lastDotIndex == -1) {
            throw new IllegalArgumentException("Filename must have an extension");
        }
        String beforeExtension = filename.substring(0, lastDotIndex);
        String extension = filename.substring(lastDotIndex);
        return beforeExtension + "-transformed" + extension;
    }
}
