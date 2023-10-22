package Handlers;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class FileHandler {
    public static XSSFWorkbook createWorkbook(String pathname) throws FileNotFoundException, IOException {
        return new XSSFWorkbook(new FileInputStream(pathname));
    }

    public static ArrayList<String> readWorkbookRowToArrayList(XSSFWorkbook workbook, String sheetName, int rowNumber) {
        ArrayList arrayList = new ArrayList<String>();
        workbook.getSheet(sheetName).getRow(rowNumber).forEach(cell -> {arrayList.add(cell.getStringCellValue());});
        return arrayList;
    }

    public static void writeHashSetToWorkbookRow(HashSet hashSet, XSSFWorkbook workbook, String sheetName, int rowNumber) throws FileNotFoundException, IOException {
        hashSet.forEach(item -> {
            switch (item.getClass().getTypeName()) {
                case "java.lang.String":
                    workbook.getSheet(sheetName).getRow(rowNumber).cellIterator().next().setCellValue((String) item);
                    break;
                case "java.lang.Integer":
                    workbook.getSheet(sheetName).getRow(rowNumber).cellIterator().next().setCellValue((Integer) item);
                    break;
                case "java.lang.Double":
                    workbook.getSheet(sheetName).getRow(rowNumber).cellIterator().next().setCellValue((Double) item);
                    break;
                case "java.lang.Boolean":
                    workbook.getSheet(sheetName).getRow(rowNumber).cellIterator().next().setCellValue((Boolean) item);
                    break;
                    case "java.lang.Door":

            }
            workbook.getSheet(sheetName).getRow(rowNumber).cellIterator().next().setCellValue(item);});
    }
}