package main;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.record.aggregates.WorksheetProtectionBlock;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import persistence.PersistenceUtility;
import entity.*;

public class XmlToMySqlDAO {
	
	private HSSFWorkbook workbook;
	private List<HSSFSheet> xlSheets;
	private final int SHEET_SIZE = 5;
	
	public XmlToMySqlDAO() {
		
		try{
			FileInputStream in = new FileInputStream("/home/colm/Desktop/GroupProject/failures.xls");
			workbook = new HSSFWorkbook(in);
	
			}catch (IOException e) {
				
				System.out.println(e.getMessage());
			}
		
		System.out.println(workbook.getSheetName(3));
		insertCapabilityData();
		insertUEVendorData();
		insertUETypeData();
		insertInputMethodData();
		insertOSData();
		insertMCCData();
		insertMNCData();
		displayAllCapabilities();
		displayAllUECapabilities();
		displayUEVendorData();
		displayUETypes();
		displayAllInputMethods();
		displayAllOS();
		displayAllMCC();
		displayAllMNC();
		
		
	}
	
	

	public void transitionCallFailurDataToDB(){
			CallFailure callFailure;
			
			for(Row row : workbook.getSheetAt(0)){
				
				
			}
		
	}
	
	public void insertCapabilityData(){
		Capability capability;
		UECapabilityLookup lookup;
		int tacVal;
		boolean tacInDB = true;
		HSSFSheet sheet = workbook.getSheetAt(3);
		Set<String> capabilitySet = new HashSet<String>();
		Set<Integer> tacSet = new HashSet<Integer>();
		for(int i = 1; i < sheet.getLastRowNum();i++){
			Row row = sheet.getRow(i);
			String[] capValues = row.getCell(3).getStringCellValue().split(", ");
			tacVal = (int)row.getCell(0).getNumericCellValue();
			if(!tacSet.contains(tacVal)){
				tacInDB = false;
			}
			for(String s : capValues){
					if(capabilitySet.add(s)){
						capability = new Capability(s);
						PersistenceUtility.persist(capability);
					}
					if(!tacInDB){
						lookup = new UECapabilityLookup(tacVal);
						lookup.setCapabilityId(PersistenceUtility.findCapabilityById(s));
						PersistenceUtility.persist(lookup);
					}
				}
			tacSet.add(tacVal);
		}
		
	}
	
	public void insertUEVendorData(){
		UEVendor vendor;
		HSSFSheet sheet = workbook.getSheetAt(3);
		String vendorString;
		Set<String> vendorVals = new HashSet<String>();
		for(int i = 1; i < sheet.getLastRowNum();i++){
			vendorString = sheet.getRow(i).getCell(2).getStringCellValue();
			
				if(vendorVals.add(vendorString)){
					vendor = new UEVendor(vendorString);
					PersistenceUtility.persist(vendor);
			}
		}
		
	}
	public void insertUETypeData(){
		UEType type;
		HSSFSheet sheet = workbook.getSheetAt(3);
		String typeString;
		Set<String> typeVals = new HashSet<String>();
		for(int i = 1; i < sheet.getLastRowNum();i++){
			typeString = sheet.getRow(i).getCell(6).getStringCellValue();
				if(typeVals.add(typeString)){
					type = new UEType(typeString);
					PersistenceUtility.persist(type);
					
			}
		}
		

	}
	public void insertInputMethodData(){
		InputMethod input;
		HSSFSheet sheet = workbook.getSheetAt(3);
		String inputString;
		Set<String> inputVals = new HashSet<String>();
		for(int i = 1; i < sheet.getLastRowNum();i++){
			inputString = sheet.getRow(i).getCell(8).getStringCellValue();
				if(inputVals.add(inputString)){
					input = new InputMethod(inputString);
					PersistenceUtility.persist(input);
					
			}
		}
		

	}
	public void insertOSData(){
		OS os;
		HSSFSheet sheet = workbook.getSheetAt(3);
		String osString;
		Set<String> osVals = new HashSet<String>();
		for(int i = 1; i < sheet.getLastRowNum();i++){
			osString = sheet.getRow(i).getCell(7).getStringCellValue();
				if(osVals.add(osString)){
					os = new OS(osString);
					PersistenceUtility.persist(os);
					
			}
		}
		

	}
	public void insertMCCData(){
		MCC mcc;
		HSSFSheet sheet = workbook.getSheetAt(4);
		int code;
		String country;
		Set<String> countryVals = new HashSet<String>();
		for(int i = 1;i<sheet.getLastRowNum();i++){
			country = sheet.getRow(i).getCell(2).getStringCellValue();
			if(countryVals.add(country)){
				code = (int)sheet.getRow(i).getCell(0).getNumericCellValue();
				mcc = new MCC(code, country);
				PersistenceUtility.persist(mcc);
			}
		}
	}
	public void insertMNCData(){
		MNC mnc;
		HSSFSheet sheet = workbook.getSheetAt(4);
		int MNCcode;
		int MCCcode;
		String operator;
		Set<String> operatorVals = new HashSet<String>();
		for(int i = 1;i<sheet.getLastRowNum();i++){
			operator = sheet.getRow(i).getCell(3).getStringCellValue();
			if(operatorVals.add(operator)){
				MCCcode = PersistenceUtility.findMCCIdByName(sheet.getRow(i).getCell(2).getStringCellValue());
				MNCcode = (int)sheet.getRow(i).getCell(1).getNumericCellValue();
				mnc = new MNC(MNCcode,MCCcode,operator);
				PersistenceUtility.persist(mnc);
			}
		}
	}
	
	public void displayAllMNC(){
		List<MNC> mncs = PersistenceUtility.findAllMNC();
		for(MNC m: mncs){
			System.out.println("MCCID:"+m.getMccId()+"|"+m.getMncId()+"|"+m.getOperator());
		}
	}
	
	public void displayAllMCC(){
		List<MCC> mccs = PersistenceUtility.findAllMCC();
		for(MCC m: mccs){
			System.out.println("ID:"+m.getMmcId()+"|"+m.getCountry());
		}
	}
	
	
	public void displayAllOS(){
		List<OS> oses = PersistenceUtility.findAllOS();
		for(OS o : oses){
			System.out.println("ID:"+o.getOSid()+"|"+o.getOSName());
		}
	}
	public void displayAllInputMethods(){
		List<InputMethod> inputs = PersistenceUtility.findAllInputMethods();
		for(InputMethod i : inputs){
			System.out.println("ID:"+i.getInputMethodId()+"|"+i.getInputMethod());
		}
	}
	
	
	public void displayAllCapabilities(){
		List<Capability> caps = PersistenceUtility.findAllCapabilities();
			
		for(Capability c: caps){
			System.out.println("ID:"+c.getCapability_id()+"|"+c.getCapability());
		}
	}
	public void displayAllUECapabilities(){
		List<UECapabilityLookup> caps = PersistenceUtility.findAllUECapabilities();
		for(UECapabilityLookup c: caps){
			System.out.println("TAC: "+c.getTacId()+"|"+c.getCapabilityId());
		}
	}
	public void displayUEVendorData() {
		List<UEVendor> vendors = PersistenceUtility.findAllUEVendors();
		for(UEVendor v : vendors){
			System.out.println("ID:"+v.getVendorId()+"|"+v.getManufacturer());
		}
		
	}
	public void displayUETypes(){
		List<UEType> types = PersistenceUtility.findAllUETypes();
		for(UEType t : types){
			System.out.println("ID:"+t.getUeId()+"|"+t.getUeType());
		}
	}
	

	public static void main(String [] args){
		XmlToMySqlDAO conf = new XmlToMySqlDAO();
	}
	
}
