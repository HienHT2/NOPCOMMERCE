package encapsulation;
public class Student{
	
	private String studentName;
	
	private void showStudent() {
		System.out.println(studentName);
	}
	
	public String getStudent() {
		return this.studentName;
	}
	public void setStudentName(String newName) {
		this.studentName= newName;
	}
}