package org.power;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class DatabasCod {
	
	static File f;
	static FileInputStream fin;
	static FileOutputStream fout;
	static Workbook w;
	static Sheet s;
	public static String getattribute(WebElement w,String s) {
	 s = w.getAttribute("Value");
	 System.out.println(s);
	return s;
	}
	public static void fileBrowse(String path) {
		f = new File(path);
	}
	public static void sheetName(String sheetname) throws IOException {
		  fin = new FileInputStream(f);
			fout=new FileOutputStream(f); 
			w = new XSSFWorkbook(fin);
			s = w.getSheet(sheetname);
	}
	
	
	
	public static String getData(int i, int j) throws IOException {
		 
		Row r = s.getRow(i);
		Cell c = r.getCell(j);
		int type = c.getCellType();
		String name = "";
		if (type == 1) {
			name = c.getStringCellValue();
		} else if (type == 0) {
			if (DateUtil.isCellDateFormatted(c))
				;
			Date d = c.getDateCellValue();
			SimpleDateFormat fo = new SimpleDateFormat("dd/MM/yyyy");
			name = fo.format(d);
		} 
		else {
			double da = c.getNumericCellValue();
			long o = (long) da;
			name = String.valueOf(o);
			
		}

		return name;
		
	}
	
	public static String writeExcel(int row, int cell) throws IOException {
		fout = new FileOutputStream(f);
		Row r = s.getRow(row);
		Cell c = r.createCell(cell);
		//int type = c.getCellType();
		String s = c.getStringCellValue();
		System.out.println(s);
		w.write(fout);
		System.out.println("Writed");
		return s;
		
		
	}
	
	
	
}
