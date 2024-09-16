// 백기선 - 스프링 제대로 공부했는지 5분안에 확인하는 방법, 테스트가 가능하도록 수정된 코드는 다음과 같다.
// https://youtu.be/bJfbPWEMj_c?si=4wox2rx6go_SUlcy&t=162

package personal;

import org.kohsuke.github.*;
import java.io.IOException;

public class RepositoryRank_to_testcode {

	// 2. 어떻게 PSA 을 활용해서 고치는 방법! 인터페이스를 정의하자! 인터페이스 안에서 여기서는 GitHub를 리턴해주는 get, connect라고 해서 임의의 인터페이스를 하나 정의 하자.
	interface GitHubService {
		GitHub connect() throws IOException;
	}

	// 3. 그리고 클래스를 만들어서, 여기서 구현을 해줘야함. 아래 getPoint 의 기능을 그대로 활용을 해서 구현을 하면됨. 그러면 예외를 던질 거기 때문에 예외도 둘 다 선언을 해줘야 함.
	class DefaultGitHubService implements GitHubService {
		@Override
		public GitHub connect() throws IOException {
			return GitHub.connect();
		}
	}

	// 4. 방금 만든 RepositoryRank 이 클래스가 GitHubService 라는 것을 주입받을 수 있는 형태로 만들어주자.
	private GitHubService gitHubService;
	public RepositoryRank(GitHubService gitHubService) {
		this.gitHubService = gitHubService;
	}// 6. 그리고 여기서 spring을 학습 했을 때 분명히 합습했을 Dependency Injection을 언급할 수 있게됨. spring IOC와 spring PSA를 제대로 제대로 공부했다면, 테스트를 만들때, 깃헙서비스를 주입해주면 되고, 가짜 깃헙서비스를 만들어서 구현해서, 거기서 가짜 깃헙 인스턴스를 만들어서 넘겨준다면 충분히 이 코드는 테스트가 가능한 코드로 변경이 됨!

	public int getPoint(String repositoryName) throws IOException {
		GitHub gitHub = gitHubService.connect(); // 5. 주입받은 다음에 주입 받은 gitHubService를 통해서 connect를 만들게 하면 테스트가 가능한 코드로 바뀜.
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
		RepositoryRank_to_testcode spring = new RepositoryRank_to_testcode();
		int point = spring.getPoint("whiteship/live-study");
		System.out.println(point);
	}
}
