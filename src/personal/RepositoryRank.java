// 백기선 - 스프링 제대로 공부했는지 5분안에 확인하는 방법, 아래 코드를 테스트가 가능한 코드로 만들기
// https://youtu.be/bJfbPWEMj_c?si=4wox2rx6go_SUlcy&t=162

package personal;

import org.kohsuke.github.*;
import java.io.IOException;

public class RepositoryRank {

	public int getPoint(String repositoryName) throws IOException {
		GitHub gitHub = GitHub.connect();   // 1. 이 부분이 에스테틱 호출이잖아요? 스프링 psa를 설명할때, Portable Service Abstraction 라고 해서 추상화를 얻어야함. 테스트하기 어려운 코드를 테스트하기 편리한 코드를 만들 수 있다! 이정도는 확실히 해야한다! 여기서 아이디어를 얻고 출발해야함.
		GHRepository repository = gitHub.getRepository(repositoryName);

		int points = 0;
		if (repository.hasIssues()) {
			points += 1;
		}
		if (repository.getReadme() != null) {
			points += 1;
		}
		if (repository.getPullRequests(GHIssueState.CLOSED).size() > 0) {
			points += 1;
		}

		points += repository.getStargazersCount();
		points += repository.getForksCount();

		return points;
	}

	public static void main(String[] args) throws IOException {
		RepositoryRank spring = new RepositoryRank();
		int point = spring.getPoint("whiteship/live-study");
		System.out.println(point);
	}
}
