package utilities;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;

public class ExcelWriter {

    static HSSFWorkbook workbook;
    static HSSFSheet sheet;
    static File writeWorkbook;
    static FileInputStream fis;
    static FileOutputStream fout;

    public void writeToExecl(String path, int rowNum, int colNum, String value) {
        try {
            writeWorkbook = new File(path);
            fis = new FileInputStream(writeWorkbook);
            workbook = new HSSFWorkbook(fis);
            sheet = workbook.getSheet("Sheet1");
            sheet.createRow(rowNum).createCell(colNum).setCellValue(value);
            fout = new FileOutputStream(writeWorkbook);
            workbook.write(fout);
            workbook.close();

        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    public String createEmptyExcelFile(String excelFileName, String path) throws IOException {

        FileInputStream file = new FileInputStream(path);
        workbook = new HSSFWorkbook(file);

        sheet = workbook.getSheet("Sheet1");
        String name = String.format("%s%s.xlsx", path, excelFileName);
        try {
            fout = new FileOutputStream(name);
            workbook.write(fout);
            workbook.close();
        } catch (IOException exp) {
            exp.printStackTrace();
        }
        return name;
    }
}