package jp.wordsyoumet.controller.message;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SendControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/message/send");
        SendController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/message/send.jsp"));
    }
}
