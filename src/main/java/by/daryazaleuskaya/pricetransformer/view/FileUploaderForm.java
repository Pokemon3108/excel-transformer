package by.daryazaleuskaya.pricetransformer.view;

import by.daryazaleuskaya.pricetransformer.service.excel.ExcelPricesTransformer;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileUploaderForm extends JFrame {

    private final String PATH = System.getenv("PRICE_PATH");
    private final ExcelPricesTransformer excelPricesTransformer = new ExcelPricesTransformer();
    private File file;

    public FileUploaderForm() {
        JButton openButton = new JButton("Open file");
        JButton transformButton = new JButton("Transform");
        JButton cancelButton = new JButton("Cancel");
        JFileChooser fileChooser = new JFileChooser(PATH);
        JLabel fileNameLabel = new JLabel();
        JLabel successLabel = configureSuccessLabel();
        JLabel errorLabel = configureErrorLabel();

        setTitle("Prices transformer");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 150);
        setLocationRelativeTo(null);
        setResizable(false);

        openButton.addActionListener(e -> {
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                fileNameLabel.setText(file.getAbsolutePath());
                errorLabel.setVisible(false);
                successLabel.setVisible(false);
            }
        });

        transformButton.addActionListener(e -> {
            if (file != null) {
                System.out.println("File to transform: " + file.getPath());
                try {
                    excelPricesTransformer.manipulateExcelColumns(file);
                    new AlertFrame("Success!", new Color(52, 169, 29)).setVisible(true);
                } catch (Exception ex) {
                    new AlertFrame(ex.getMessage(), Color.RED).setVisible(true);
                }
            }
        });

        cancelButton.addActionListener(e -> {
            file = null;
            fileNameLabel.setText(null);
            errorLabel.setVisible(false);
            successLabel.setVisible(false);
        });

        add(openButton);
        add(transformButton);
        add(cancelButton);
        add(fileNameLabel);
        add(errorLabel);
        add(successLabel);
    }

    private JLabel configureSuccessLabel() {
        JLabel successLabel = new JLabel();
        successLabel.setText("Success!");
        successLabel.setVisible(false);
        successLabel.setForeground(Color.GREEN);
        return successLabel;
    }

    private JLabel configureErrorLabel() {
        JLabel errorLabel = new JLabel();
        errorLabel.setText("Error occured during file processing.");
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);
        return errorLabel;
    }

}