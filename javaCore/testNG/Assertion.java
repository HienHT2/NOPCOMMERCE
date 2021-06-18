package testNG;

import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class Assertion {
	@Test
	public void TC_01_Assert() {
		String address="Ho Chi Minh";
		int studentNumber = 100;
		
		//Kiểm tra 1 điều kiện trả về đúng
		assertTrue(address.equals("Ho Chi Minh"));
		//Kiểm tra 1 điều kiện trả về sai
		assertFalse(address.equals("Ha Noi"));
		
		//Các hàm trả về kiểu boolean: isDisplay/isEnalbe/isSelected/isMultiple
		//Kiểm tra 2 điều kiện dữ liệu bằng nhau
		assertEquals(address, "Ho Chi Minh");
		assertEquals(studentNumber,100);
	}
	
}
