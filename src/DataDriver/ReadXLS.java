package DataDriver;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ReadXLS {
 
     public List<String[]> getData() {
 
           String path = "/Users/miloonken/Downloads/DataSheet.xls";
           List<String[]> dataList = new ArrayList<String[]>();
           FileInputStream fis = null;
           try {
               fis = new FileInputStream(new File(path));
               @SuppressWarnings("resource")
               XSSFWorkbook workbook = new XSSFWorkbook(fis);
               XSSFSheet sheet = workbook.getSheet("TestData");
               Iterator<Row> rows = sheet.rowIterator();
 
               while (rows.hasNext()) {
                   XSSFRow row = ((XSSFRow) rows.next());
                   // int r=row.getRowNum();
                   Iterator<Cell> cells = row .cellIterator();
                   int i = 0;
                   String[] testData= new String[3];
                   while (cells.hasNext()) {
 
                       XSSFCell cell = (XSSFCell) cells.next();
                       String value = cell.getStringCellValue();
                       if (!value.equals(null)) {
                            testData [i] = value;
                            i++;
                       }
                   }
                   dataList.add(testData);
               }
           }
           catch (Exception e) {
               e.printStackTrace();
           }
           return dataList;
     }
 
}