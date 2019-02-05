package jp.wordsyoumet.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class WordTest extends AppEngineTestCase {

    private Word model = new Word();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
