package jp.wordsyoumet.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.HashMap;
import java.util.Map;
import org.slim3.datastore.Datastore;
import jp.wordsyoumet.model.User;

public class AccountServiceTest extends AppEngineTestCase {

    private AccountService service = new AccountService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
    
    @Test
    public void putandget() throws Exception {
        Map<String, Object> input = new HashMap<String, Object>();
        input.put("nickname", "Bear");
        input.put("email", "test@example.com");
        User user = service.create(input);
        assertThat(user, is(notNullValue()));
        User stored = Datastore.get(User.class, user.getKey());
        assertThat(stored.getEmail(), is("test@example.com"));
        assertThat(stored.getNickname(), is("Bear"));
    }
}
