package Handlers;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandler {
    public static XSSFWorkbook createWorkbook(String pathname) throws FileNotFoundException, IOException {
        return new XSSFWorkbook(new FileInputStream(pathname));
    }

    public static ArrayList<String> readWorkbookRowToArrayList(XSSFWorkbook workbook, String sheetName, int rowNumber) {
        ArrayList arrayList = new ArrayList<String>();
        workbook.getSheet(sheetName).getRow(rowNumber).forEach(cell -> {arrayList.add(cell.getStringCellValue());});
        return arrayList;
    }

    public static void arrayListToWorkbookRow(ArrayList<String> arrayList, XSSFWorkbook workbook, String sheetName, int rowNumber) throws FileNotFoundException, IOException {
        arrayList.forEach(item -> {workbook.getSheet(sheetName).getRow(rowNumber).getCell(0).setCellValue(item);});
    }
}