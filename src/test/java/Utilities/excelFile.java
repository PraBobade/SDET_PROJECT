package Utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class excelFile {



    public static Object[][] UserName() throws IOException {
        String PathExcel = System.getProperty("user.dir")+"\\src\\test\\java\\PageDATA\\LoginData.xlsx";
        FileInputStream fis = new FileInputStream((PathExcel));
        XSSFWorkbook workBook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workBook.getSheetAt(0);

        Iterator<Row> rows = sheet.iterator();

        ArrayList<String> UserName = new ArrayList<>();
        ArrayList<String> pass = new ArrayList<>();
        int RowNumber=0;
        int ColumnNumber=0;

        while(rows.hasNext()){
            Iterator<Cell> ce = rows.next().cellIterator(); // rows.next()  is move the control to next row i.e. downward direction so here control is on firstCell of firstRow
            ColumnNumber=0;
            UserName.add(ce.next().getStringCellValue());  // ce.next()  is help to move next cell i.e. towards right side --> (here control is on first cell)
            ColumnNumber++;
            pass.add(ce.next().getStringCellValue());  //with help of ce.next()  control is now on second cell of first row, and then it checks for
            // and again while loop check for is there is next row present or not.
            ColumnNumber++;
            RowNumber++;
        }
        Object[][] data1= new String[RowNumber][ColumnNumber];

        for(int i=1;i<=RowNumber;i++) {
            for(int j=0;j<ColumnNumber;j++) {  // 0
                if (j==0){
                    data1[i-1][j]= UserName.get((i-1));
                    }
                else{
                    data1[i-1][j] = pass.get((i-1));
                   }
            }
        }

        return data1;
    }

    public void AddNewCustomer() throws IOException {
        /*
        String PathExcel = System.getProperty("user.dir")+"\\src\\test\\java\\PageDATA\\LoginData.xlsx";
        FileInputStream fis = new FileInputStream((PathExcel));
        XSSFWorkbook workBook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workBook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();
        ArrayList<String> CustomerName = new ArrayList<>();
        ArrayList<String> Gender = new ArrayList<>();
        ArrayList<String> DOB = new ArrayList<>();
        ArrayList<String> Address = new ArrayList<>();
        ArrayList<String> city = new ArrayList<>();
        ArrayList<String> state = new ArrayList<>();
        ArrayList<String> pin = new ArrayList<>();
        ArrayList<String> mobile = new ArrayList<>();
        ArrayList<String> password = new ArrayList<>();

        int RowNumber=0;
        int ColumnNumber=0;

        while(rows.hasNext()){
            Iterator<Cell> ce = rows.next().cellIterator();
            ColumnNumber=0;
            CustomerName.add(ce.next().getStringCellValue());
            ColumnNumber++;
            Gender.add(ce.next().getStringCellValue());
            ColumnNumber++;
            DOB.add(ce.next().getStringCellValue());
            ColumnNumber++;
            Address.add(ce.next().getStringCellValue());
            ColumnNumber++;
            city.add(ce.next().getStringCellValue());
            ColumnNumber++;
            state.add(ce.next().getStringCellValue());
            ColumnNumber++;
            pin.add(ce.next().getStringCellValue());
            ColumnNumber++;
            mobile.add(ce.next().getStringCellValue());
            ColumnNumber++;
            password.add(ce.next().getStringCellValue());
            ColumnNumber++;
            RowNumber++;
        }
        Object[][][][][][][][][] data1= new String[][][][][][][][][];

        for(int i=1;i<=RowNumber;i++) {
            for(int j=0;j<ColumnNumber;j++) {  // 0
                if (j==0){
                    data1[i-1][j][0][0][0][0][0][0][0]= CustomerName.get((i-1));
                }
                else{
                    data1[i-1][j] = pass.get((i-1));
                }
            }
        }

        return data1;*/

    }
}
