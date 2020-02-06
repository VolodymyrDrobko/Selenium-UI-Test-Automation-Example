import core.BaseTest;
import core.Configuration;
import org.testng.annotations.Test;
import pageBO.GitHubLoginPageBO;

public class GitHubSearchTest extends BaseTest {

    @Test
    public void gitHubGeneralLogin() {
        GitHubLoginPageBO gitHubLoginPageBO = new GitHubLoginPageBO();
        gitHubLoginPageBO
                .loginToGit(Configuration.getLogin(), Configuration.getPassword())
                .checkAllAssertions();
    }

    @Test
    public void gitHubGeneralLogin2() {
        GitHubLoginPageBO gitHubLoginPageBO = new GitHubLoginPageBO();
        gitHubLoginPageBO
                .loginToGitWithFail(Configuration.getLogin(), Configuration.getPassword())
                .checkAllAssertions();
    }

    @Test
    public void test1() {
        System.out.println("Test1");
    }

    @Test
    public void test2() {
        System.out.println("Test2");
    }
}
