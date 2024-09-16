// https://youtu.be/nOHdunGzeRc?si=u1MVLLgf0FE-I37d&t=540
package personal;

import java.util.ArrayList;
import java.util.List;

interface Developer {
	void develop();
}

class BackendDeveloper2 implements Developer {
//	// BackendDeveloper2의 메서드이름을 바꾸게된다면 main 클래스인 DiDip_큰돌 에서도 함수이름을 바꿔주어야함.
//	public void writeJava() {
//		System.out.println("자바가 좋아 인터네셔널~");
//	}
	@Override
	public void develop() {
		writeJava();
	}

	public void writeJava() {
		System.out.println("자바가 좋아 인터네셔널~");
	}
}

class FrontEndDeveloper2 implements Developer {
//	public void writeJavasctipt() {
//		System.out.println("자바스크립트가 좋아~");
//	}
	@Override
	public void develop() {
		writeJavascript();
	}

	public void writeJavascript() {
		System.out.println("자바스크립트가 최고야~ 새삥새삥");
	}
}

class IosDeveloper implements Developer {
	@Override
	public void develop() {
		writeSwift();
	}

	public void writeSwift() {
		System.out.println("스위프트는 스윗해~");
	}
}

public class DiDip_큰돌_DI_적용 {
//	private final BackendDeveloper2 backendDeveloper;
//	private final FrontEndDeveloper2 frontendDeveloper;
	private final List<Developer> developers;

//	public DiDip_큰돌_DI_적용(BackendDeveloper2 backendDeveloper, FrontEndDeveloper2 frontEndDeveloper) {
//		this.backendDeveloper = backendDeveloper;
//		this.frontendDeveloper = frontEndDeveloper;
//	}
	public DiDip_큰돌_DI_적용(List<Developer> developers) {
		this.developers = developers;
	}

	public void implement() {
//		// 여기 이 부분의 코드가 의존하고 있기 때문에 함께 수정해주어야 하는 번거로움이 생김
//		backendDeveloper.writeJava();
//		frontendDeveloper.writeJavasctipt();
		developers.forEach(Developer::develop);
	}

	public static void main(String args[]) {
//		DiDip_큰돌_DI_적용 a = new DiDip_큰돌_DI_적용(new BackendDeveloper2(), new FrontEndDeveloper2());
//		a.implement();
		List<Developer> dev = new ArrayList<>();
		dev.add(new BackendDeveloper2());
		dev.add(new FrontEndDeveloper2());
		dev.add(new IosDeveloper());
		DiDip_큰돌_DI_적용 a = new DiDip_큰돌_DI_적용(dev);
		a.implement();
	}
}
