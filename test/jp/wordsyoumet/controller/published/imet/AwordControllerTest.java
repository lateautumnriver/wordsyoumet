package jp.wordsyoumet.controller.published.imet;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AwordControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/published/imet/aword");
        AwordController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/published/imet/aword.jsp"));
    }
}
