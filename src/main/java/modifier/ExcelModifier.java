package modifier;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelModifier {
    private static final String SAMPLE_XLSX_FILE_PATH = "./employee.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {
        // Obtain a workbook from the excel file
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        // Get Sheet at index 0
        Sheet sheet = workbook.getSheetAt(0);

        // Get Row at index 2
        Row row = sheet.getRow(2);

        Cell cell;
        // Create the cell if it doesn't exist
        if (row.getCell(9) == null) {
            cell = row.createCell(9);
        } else {
            cell = row.getCell(9);
        }

        // Update the cell's value
        cell.setCellType(CellType.STRING);
        cell.setCellValue("Updated Value");

        // Write the output to the file
        FileOutputStream fileOut = new FileOutputStream("modifier-employee.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }
}
