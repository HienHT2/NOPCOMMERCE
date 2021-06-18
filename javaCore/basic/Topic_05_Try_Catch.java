package basic;

public class Topic_05_Try_Catch {
	public static void main(String[] args) {
		//Negative/positive testcases
		//Happy path/Unhappy path case
		
		//Login Funtion:
		//try: khi xử lý 1 funtion thì các case mà nó luôn đùng try
		//Các case mà làm chi testcase/ chức năng nó bị dừng lại xử lý trong cath(bắt lại)
		String[] address = {"Ha Noi","Sai Gon","Da nang"};
		try {
			System.out.println(address[0]);
			System.out.println(address[1]);
			System.out.println(address[2]);
			System.out.println(address[3]);
			System.out.println(address[4]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Step 02
		System.out.println("Chay step so 1");
		
	}
}
