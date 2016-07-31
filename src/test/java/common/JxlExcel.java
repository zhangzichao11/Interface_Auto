package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import jxl.Cell;
import jxl.CellType;
import jxl.LabelCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * 封装了一些操作excel的方法
 * @author zzc
 *
 */
public class JxlExcel{
	
	/**
	 * 读取Excel单元格内容
	 * @param filePath
	 * @param sheetNo
	 */
	public static void readExcel(String filePath,int sheetNo){
		
		try {
			
			InputStream is= new FileInputStream(filePath);
			Workbook rwb=Workbook.getWorkbook(is);
			Sheet st=rwb.getSheet(sheetNo);
			Cell cell=st.getCell(0, 0);
			String strCell=cell.getContents();//获取该单元格的内容
			if(cell.getType()==CellType.LABEL){
				
				LabelCell label=(LabelCell)cell;
				strCell=label.getString();
			}
			
			System.out.println(strCell);//输出该单元格内容
			rwb.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**   
    * 拷贝后,进行修改,其中file1为被copy对象，file2为修改后创建的对象；如果不想改名字的话他们可以一样   
    * 单元格原有的格式化修饰是不能去掉的，我们还是可以将新的单元格修饰加上去，    
    * 以使单元格的内容以不同的形式表现    
	 * @param file1
	 * @param file2
	 * @param context
	 */
	public static void modifyExcel(File file1,File file2,String context){
		
		try {
			
			Workbook wb = Workbook.getWorkbook(file1);//打开一个文件的副本，并且指定数据写回到原文件
			WritableWorkbook wwb = Workbook.createWorkbook(file2,wb);//copy    
	        WritableSheet ws = wwb.getSheet(0);    
	        WritableCell wc = ws.getWritableCell(2,10);    
	         //判断单元格的类型,做出相应的转换    
	     if(wc.getType() == CellType.LABEL){
	    	 
	             Label label = (Label)wc;    
	             label.setString(context);    
	        }    
	     
		     wwb.write();    
	         wb.close();    
	         wb.close();  
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	    /**一次修改三个单元格的内容
	    * 拷贝后,进行修改,其中file1为被copy对象，file2为修改后创建的对象；如果不想改名字的话他们可以一样   
	    * 单元格原有的格式化修饰是不能去掉的，我们还是可以将新的单元格修饰加上去，    
	    * 以使单元格的内容以不同的形式表现    
		 * @param file1
		 * @param file2
		 * @param context1
		 * @param context2
		 * @param context3
	     * @throws WriteException 
		 */
		public void modifyExcel1(File file1,File file2,String cardHolder,String bankCardNum,String cardHolder1,String idCardCode){
			
			try {
				
				Workbook wb = Workbook.getWorkbook(file1);//打开一个文件的副本，并且指定数据写回到原文件
				WritableWorkbook wwb = Workbook.createWorkbook(file2,wb);//copy    
		        WritableSheet ws = wwb.getSheet(0);
		        
		        WritableCell wc1 = ws.getWritableCell(2,10);
		        WritableCell wc2 = ws.getWritableCell(4,10);
		        WritableCell wc3 = ws.getWritableCell(5,10);
		        WritableCell wc4 = ws.getWritableCell(15,10);
		        
		         //判断单元格的类型,做出相应的转换    
		     if(wc1.getType() == CellType.LABEL){
		    	 
		             Label label = (Label)wc1;    
		             label.setString(cardHolder);
		            
		     }    
		     if(wc2.getType() == CellType.LABEL){
		    	 
	             Label label = (Label)wc2;    
	             label.setString(bankCardNum); 
		     }    
		     if(wc3.getType() == CellType.LABEL){
		    	 
	             Label label = (Label)wc3;    
	             label.setString(cardHolder1);    
		     }    
		     
		     if(wc4.getType() == CellType.LABEL){
		    	 
	             Label label = (Label)wc4;    
	             label.setString(idCardCode);    
		     }
		     
			     wwb.write();    
		         wwb.close();    
		         wb.close();  
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
