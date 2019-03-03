package com.qa.hubspot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.hubspot.constants.Constants;

public class TestUtil {
	
	public static Workbook book;
	public static Sheet sheet;
	
	
	public static void shortWait() {
		try {
			Thread.sleep(Constants.SHORT_WAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void mediumWait() {
		try {
			Thread.sleep(Constants.MEDIUM_WAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void longWait() {
		try {
			Thread.sleep(Constants.LONG_WAIT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static Object[][] getTestdata(String sheetName) { //to read data from excel file
		FileInputStream file = null;
		try {
			file = new FileInputStream(Constants.TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file); //test data copy to be created in the java memory. Then it will interact.
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		Object data [][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; //Two dimensional array. Instead of hard coding, we are taking last rows and columns using Apache POI API
		for(int i=0; i<sheet.getLastRowNum(); i++) { //i is representing rows
			for(int k = 0; k<sheet.getRow(0).getLastCellNum(); k++) { //k is representing columns
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				
			}
		}
		
		return data;
		
		
		
		
	}
		
		
	
	public static Object[][] getDealsTestdata(String sheetName) { //to read data from excel file
		FileInputStream file = null;
		try {
			file = new FileInputStream(Constants.DEALSDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file); //test data copy to be created in the java memory. Then it will interact.
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		Object data [][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; //Two dimensional array. Instead of hard coding, we are taking last rows and columns using Apache POI API
		for(int i=0; i<sheet.getLastRowNum(); i++) { //i is representing rows
			for(int k = 0; k<sheet.getRow(0).getLastCellNum(); k++) { //k is representing columns
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				System.out.println(data[i][k]);
				
			}
		}
		
		return data;
		
		
		
		
	}


}
