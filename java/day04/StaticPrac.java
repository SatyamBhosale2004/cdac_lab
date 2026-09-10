
public class StaticPrac {

int num1;
static int tempStatic;

static {
	tempStatic = 2;
	System.out.println("Static block");
}


{
	System.out.println("Init block");
}

public StaticPrac(){
	System.out.println("Data constructor");
}
 public static void main(String args[]) {
	 
 }
}
