package utilities;

//package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public String getCellData(String filePath, String sheetName, int rowIndex, int colIndex) {
        String cellData = "";

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowIndex);
            Cell cell = row.getCell(colIndex);

            if (cell != null) {
                switch (cell.getCellType()) {
                    case STRING:
                        cellData = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        cellData = String.valueOf((int) cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        cellData = String.valueOf(cell.getBooleanCellValue());
                        break;
                    case FORMULA:
                        cellData = cell.getCellFormula();
                        break;
                    default:
                        cellData = "";
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cellData;
    }
}

