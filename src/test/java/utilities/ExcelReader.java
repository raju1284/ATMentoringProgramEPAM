package utilities;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    static HSSFWorkbook workbook;
    static HSSFSheet sheet;

    public int getRowCount(String path)    {
        try {
            FileInputStream file = new FileInputStream(path);
            workbook = new HSSFWorkbook(file);

            sheet=workbook.getSheet("Sheet1");
            return sheet.getPhysicalNumberOfRows();

        }
        catch(IOException exp){
            exp.printStackTrace();
        }
        return -1;
    }
 public int getColCount(String path) {
     try {
         FileInputStream file = new FileInputStream(path);
         workbook = new HSSFWorkbook(file);
         workbook = new HSSFWorkbook();
         sheet = workbook.getSheet("Sheet1");
         return sheet.getRow(0).getPhysicalNumberOfCells();
     } catch (IOException exp) {
         exp.printStackTrace();
     }
     return -1;
 }
 public String getCellDataAsString(String path ,int rowNum, int colNum)
 {
     try {
         FileInputStream file = new FileInputStream(path);
         workbook = new HSSFWorkbook(file);
         workbook = new HSSFWorkbook();
         sheet = workbook.getSheet("Sheet1");
         DataFormatter df = new DataFormatter();
         return df.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
     } catch (IOException exp) {
         exp.printStackTrace();
     }
     return null;
 }

 }
