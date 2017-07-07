import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class MagicSquare {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<int []> myArray=new ArrayList<>();
		FileReader fr = new FileReader("Mercury.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] parts = line.split("\\s+");
			int[] n1 = new int[parts.length];
			boolean skip = false;
			for (int i = 0; i < parts.length; i++) {
				try {
					n1[i] = Integer.parseInt(parts[i]);
				} catch (NumberFormatException exc) {
					skip = true;
				}
				
			}
			if (!skip) {
				myArray.add(n1);
			}
		}
		for(int i=0;i<myArray.size();i++){
			System.out.println("Row "+i+": "+addRow(myArray.get(i)));
			System.out.println("Column "+i+": "+addColumn(i,myArray));
		}
		
	}
	
	public static int addRow(int[] array){
		return IntStream.of(array).sum();
	}
	
	public static int addColumn(int column, ArrayList<int[]> array){
		int temp=0;
		for(int i=0; i<array.size();i++){
			temp += array.get(i)[column];
		}
		return temp;
	}
}
