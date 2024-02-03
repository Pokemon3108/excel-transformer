package by.daryazaleuskaya.pricetransformer.service.excel;

import by.daryazaleuskaya.pricetransformer.service.EncoderUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelPricesTransformer {

    private final FileNameBuilder fileNameBuilder = new FileNameBuilder();

    public File manipulateExcelColumns(File input) throws Exception {
        List<List<Object>> oldTable = readFromExcel(input);
        List<List<Object>> newTable = buildNewFileColumns(oldTable);
        String outputFilePath = fileNameBuilder.transformFilename(input.getAbsolutePath());
        writeToExcel(outputFilePath, newTable);
        return new File(outputFilePath);
    }

    private List<List<Object>> readFromExcel(File file) throws Exception {
        try (FileInputStream fileInputStream = new FileInputStream(file);
             HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream)) {
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            List<List<Object>> table = new ArrayList<>();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                List<Object> tableRow = new ArrayList<>();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            double value = cell.getNumericCellValue();
                            if (value == Math.floor(value)) {
                                tableRow.add((long) value);  // cast to integer if no fractional part
                            } else {
                                tableRow.add(value);      // keep as double if fractional part
                            }
                            break;
                        case BOOLEAN:
                            tableRow.add(cell.getBooleanCellValue());
                            break;
                        default:
                            tableRow.add(cell.getStringCellValue());
                    }
                }
                table.add(tableRow);
            }
            return table;
        }
    }

    private List<List<Object>> buildNewFileColumns(List<List<Object>> table) throws UnsupportedEncodingException {
        List<List<Object>> newTable = new ArrayList<>();
        for (List<Object> row : table) {
            List<Object> newTableRow = new ArrayList<>();
            newTableRow.add(row.get(2));  // Article Number
            newTableRow.add(row.get(3));  // Name
            newTableRow.add(row.get(16)); // Code EAH
            newTableRow.add(row.get(9));  // Amount
            newTableRow.add(row.get(10)); // Price
            newTableRow.add(row.get(12)); // TAX
            newTableRow.add("");
            newTableRow.add(row.get(4) + " " + row.get(6)); // Combo parameters
            newTableRow.add("");
//            List<String> a = new ArrayList<>();
//            a.add("Ббавпжлвоп");
            newTableRow.add(EncoderUtils.getUtf8String("Беларусь"));
            newTableRow.add("ООО \"Марк Формэль\"");
            newTableRow.add(row.get(7));  // Sort
            newTableRow.add(row.get(8));  // Unit of measurement
            newTableRow.add("");
            newTableRow.add("");
            newTableRow.add("");
            newTableRow.add(row.get(1));  // Model
            newTable.add(newTableRow);
        }
        return newTable;
    }

    private void writeToExcel(String filePath, List<List<Object>> table) throws Exception {
        try (HSSFWorkbook workbook = new HSSFWorkbook();
             FileOutputStream out = new FileOutputStream(filePath)) {
            HSSFSheet sheet = workbook.createSheet("Sheet 1");
            for (int rowIndex = 0; rowIndex < table.size(); rowIndex++) {
                Row row = sheet.createRow(rowIndex);
                List<Object> tableRow = table.get(rowIndex);
                for (int colIndex = 0; colIndex < tableRow.size(); colIndex++) {
                    Cell cell = row.createCell(colIndex);
                    cell.setCellValue(tableRow.get(colIndex).toString());
                }
            }
            workbook.write(out);
        }
    }

}