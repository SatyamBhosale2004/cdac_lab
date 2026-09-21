package day13;

public class LambdaPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PasswordValidator basic = (String str) -> {
			if(str.length() >= 5) return true;
			else return false;
		};
		PasswordValidator adv = str -> str.length() >= 5 && str.indexOf('@') != -1;
		System.out.println(basic.validate("test"));
		System.out.println(basic.validate("testHi"));
		System.out.println(adv.validate("test@123"));
	}

}

interface PasswordValidator{
	boolean validate(String password);
}
