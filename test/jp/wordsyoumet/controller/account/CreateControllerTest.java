package jp.wordsyoumet.controller.account;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
// TODO
// 何をしようとしてこれをインポートしたんだっけ？
//import java.security.Principal;

public class CreateControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.request.setMethod("get");
        tester.param("nickname", "foo");
        tester.start("/account/create");
        CreateController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/WEB-INF/account/create.jsp"));
    }

    @Test
    public void test() throws Exception {
        tester.request.setMethod("post");
        tester.start("/account/create");
        CreateController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
        assertThat(tester.getDestinationPath(), is("/words/imet"));
    }
}
