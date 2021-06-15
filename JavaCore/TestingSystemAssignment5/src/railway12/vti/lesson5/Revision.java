package railway12.vti.lesson5;

public class Revision {

	public static void main(String[] args) {
		String a = "abcd"; // tìm đến giá trị a trong string pool và trỏ đến đó (không tạo ô nhớ)
		String b = new String("abcd"); // TẠO một Ô NHỚ trong memory heap rồi trỏ đến ô nhớ đó (tạo con trỏ)
		System.out.println(a.equals(b));
	}

}
