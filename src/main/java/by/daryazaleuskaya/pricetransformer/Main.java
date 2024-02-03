package by.daryazaleuskaya.pricetransformer;

import by.daryazaleuskaya.pricetransformer.view.FileUploaderForm;

public class Main {

    private static final FileUploaderForm fileUploaderForm = new FileUploaderForm();

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        fileUploaderForm.setVisible(true);
    }
}
