package utiity;

import org.junit.Test;

public class removechar {

	@Test

			   public void main(String args[]) {
			      String str = "this is Java";
			      System.out.println(removeCharAt(str, 3));
			   }
			   public String removeCharAt(String s, int pos) {
			      return s.substring(0, pos) + s.substring(pos + 1);
			   }
		
	
}