package writer;

import model.Employee;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExcelWriter {
    private static String[] columns = {"Name", "Email", "Date of birth", "Days of work", "Salary Per Day", "Total Salary"};
    private static List<Employee> employees = new ArrayList<>();

    // Initializing employees data to insert into the excel file
    static {
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1995, 0, 8); // 0 means January
        employees.add(new Employee("Tubean", "tubean@github.com", dateOfBirth.getTime(), 22d, 100d, null));
        dateOfBirth.set(1998, 2, 15);
        employees.add(new Employee("Quynh", "vivichan@gmail.com", dateOfBirth.getTime(), 21d, 120d, null));
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {
        // Create a Workbook
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances of various things like DataFormat,
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Employee");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Cell Style for formatting Date
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        // Create Other rows and cells with employees data
        int rowNum = 1;
        for (Employee employee : employees) {
            Row row = sheet.createRow(rowNum++);

            // Employee's name (Column A)
            row.createCell(0)
                    .setCellValue(employee.getName());

            // Employee's email (Column B)
            row.createCell(1)
                    .setCellValue(employee.getEmail());

            // Employee's date of birth (Column C)
            Cell dateOfBirth = row.createCell(2);
            dateOfBirth.setCellValue(employee.getDateOfBirth());
            dateOfBirth.setCellStyle(dateCellStyle);

            // Employee's days of Work (Column D)
            row.createCell(3, CellType.NUMERIC)
                    .setCellValue(employee.getDaysOfWork());

            // Employee's salary per day (Column E)
            row.createCell(4, CellType.NUMERIC)
                    .setCellValue(employee.getSalaryPerDay());

            // Employee's total salary (Column F = D * E)
            String formula = "D" + rowNum + " * E" + rowNum;
            row.createCell(5, CellType.FORMULA)
                    .setCellFormula(formula);
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("employee.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }
}
