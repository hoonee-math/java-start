package variable;

public class Var8 {

	public static void main(String[] args){
		//정수
		byte b = 127;       // 8승 -128 ~ 127
		short s = 32767;    // 16승 -32,768 ~ 32,767
		int i = 2147483647; // 32승 -2,147,483,648 ~ 2,147,438,647 (약 20억)
		// 64승 -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
		long l = 9223372036854775807L;


		//실수
		float f = 10.0f;    // float 은 뒤에 f 를 붙여줘야함.
		double d = 10.0;    // double 이 더 넓은 범위의 숫자를 표현 가능 = 정밀도가 높다

		// 기본적으로 int와 double, String 사용함.
	}
}
