package jp.wordsyoumet.controller.closed;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class LoginControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.param("closed-service-account", "wordsyoumet");
        tester.param("closed-service-password", "imetaword");

        tester.start("/closed/login");
        LoginController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
        assertThat(tester.getDestinationPath(), is("/words/imet"));
    }
}
