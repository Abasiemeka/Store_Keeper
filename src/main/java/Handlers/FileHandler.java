package Handlers;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public interface FileHandler {
    default void createFile(String filename) throws IOException {
        Path filePath = Path.of(filename);
        Files.createFile(filePath);
    }
    default void openFile(Files file) throws FileNotFoundException {
        Files.newInputStream(file);
    }
    default void readFile(){
    }

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet spreadsheet = workbook.createSheet("employe db");

    XSSFRow row = spreadsheet.createRow(1);
    XSSFCell cell;
    cell = row.createCell(1);
      cell.setCellValue("EMP ID");
    cell = row.createCell(2);
      cell.setCellValue("EMP NAME");
    cell = row.createCell(3);
      cell.setCellValue("DEG");
    cell = row.createCell(4);
      cell.setCellValue("SALARY");
    cell = row.createCell(5);
      cell.setCellValue("DEPT");
    int i = 2;

      while(resultSet.next()) {
        row = spreadsheet.createRow(i);
        cell = row.createCell(1);
        cell.setCellValue(resultSet.getInt("eid"));
        cell = row.createCell(2);
        cell.setCellValue(resultSet.getString("ename"));
        cell = row.createCell(3);
        cell.setCellValue(resultSet.getString("deg"));
        cell = row.createCell(4);
        cell.setCellValue(resultSet.getString("salary"));
        cell = row.createCell(5);
        cell.setCellValue(resultSet.getString("dept"));
        i++;
    }

    FileOutputStream out = new FileOutputStream(new File("exceldatabase.xlsx"));
      workbook.write(out);
      out.close();
      System.out.println("exceldatabase.xlsx written successfully");
}
}
