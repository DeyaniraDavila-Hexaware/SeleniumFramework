package hex.selenium.utilities;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadDatasheet {

	public ReadDatasheet()
	{
		
	}
	
	private int totalRows = 0;
	
	public int getTotalRows() {
		return totalRows;
	}
	
	
	public String[][] readExcelCsv(String dataSheetName) throws IOException {

		String FilePath = "Datasheet\\"+dataSheetName;
		String thisLine;
		FileInputStream fs = new FileInputStream(FilePath);
		@SuppressWarnings("resource")
		DataInputStream myInput = new DataInputStream(fs);
		
		List<String[]> lines = new ArrayList<String[]>();
		String[][] inputDataArray = new String[100][100];
		int x=0;
		while ((thisLine = myInput.readLine()) != null)	
		{
			int y=0;
			String[] values = thisLine.split(",");
        	for (String str : values)
        	{
        		
        		inputDataArray[x][y]=str;
        		//System.out.print(inputDataArray[x][y] + " ");
				y=y+1;
        	}
        	//System.out.println("");
        	x=x+1;        	
		}
		
		totalRows = x;
		
		myInput.close();
		
		int k = 0;
		 for (int i = 0; i < inputDataArray.length; i++) {
		        ArrayList<Object> list = new ArrayList<Object>();
		        for (int j = 0; j < inputDataArray[i].length; j++) {
		            if (inputDataArray[i][j] != null) {
		                list.add(inputDataArray[i][j]);
		            }
		        }
		        inputDataArray[k++] = list.toArray(new String[list.size()]);
		    }
		
		return inputDataArray;
        	
	}
	
	public String GetLocalDataSheetValue(String[][] inputDataArray, int iteration, String parameterName){

		int columna = 0;
		
        for ( int r = 0; r < inputDataArray.length; r++) {  //
            for (int c = 0; c < inputDataArray[r].length; c++) {
            	if(inputDataArray[r][c].equalsIgnoreCase(parameterName)){
            		columna = c;
            	}	
                }
            } 
				
		return inputDataArray[iteration][columna];
	}
	
	
	public String GetObject(String[][] inputDataArray, int iteration, String parameterName){

		int columna = 0;
		
        for ( int r = 0; r < inputDataArray.length; r++) {  //
            for (int c = 0; c < inputDataArray[r].length; c++) {
            	if(inputDataArray[r][c].equalsIgnoreCase(parameterName)){
            		columna = c;
            	}	
                }
            } 
				
		return inputDataArray[iteration][columna];
	}
	
	
}
