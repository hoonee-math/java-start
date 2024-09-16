// https://youtu.be/nOHdunGzeRc?si=LjCdUh0f2xEZAKMg&t=262
package personal;
import  java.util.*;

class BackendDeveloper {
	// BackendDeveloper의 메서드이름을 바꾸게된다면 main 클래스인 DiDip_큰돌 에서도 함수이름을 바꿔주어야함.
	public void writeJava() {
		System.out.println("자바가 좋아 인터네셔널~");
	}
}

class FrontEndDeveloper {
	public void writeJavasctipt() {
		System.out.println("자바스크립트가 좋아~");
	}
}

public class DiDip_큰돌 {
	private final BackendDeveloper backendDeveloper;
	private final FrontEndDeveloper frontendDeveloper;

	public DiDip_큰돌(BackendDeveloper backendDeveloper, FrontEndDeveloper frontEndDeveloper) {
		this.backendDeveloper = backendDeveloper;
		this.frontendDeveloper = frontEndDeveloper;
	}

	public void implement() {
		// 여기 이 부분의 코드가 의존하고 있기 때문에 함께 수정해주어야 하는 번거로움이 생김
		backendDeveloper.writeJava();
		frontendDeveloper.writeJavasctipt();
	}

	public static void main(String args[]) {
		DiDip_큰돌 a = new DiDip_큰돌(new BackendDeveloper(), new FrontEndDeveloper());
		a.implement();
	}
}
