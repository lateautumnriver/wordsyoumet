package jp.wordsyoumet.controller.words;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ImetControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/words/imet");
        ImetController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/WEB-INF/jsp/words/imet.jsp"));
    }
}
