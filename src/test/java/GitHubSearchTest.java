import core.BaseTest;
import core.Configuration;
import org.testng.annotations.Test;
import pageBO.GitHubLoginPageBO;

public class GitHubSearchTest extends BaseTest {

    @Test
    public void gitHubGeneralLogin() {
        GitHubLoginPageBO gitHubLoginPageBO = new GitHubLoginPageBO();
        gitHubLoginPageBO
                .loginToGit(Configuration.LOGIN, Configuration.PASSWORD)
                .checkAllAssertions();
    }

    @Test
    public void gitHubGeneralLogin2() {
        GitHubLoginPageBO gitHubLoginPageBO = new GitHubLoginPageBO();
        gitHubLoginPageBO
                .loginToGitWithFail(Configuration.LOGIN, Configuration.PASSWORD)
                .checkAllAssertions();
    }
}
