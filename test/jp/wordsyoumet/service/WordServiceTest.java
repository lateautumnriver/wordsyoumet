package jp.wordsyoumet.service;

import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

import jp.wordsyoumet.model.Word;

import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Key;

public class WordServiceTest extends AppEngineTestCase {

    private WordService service = new WordService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
    
    @Test
    public void remember() throws Exception {
        // build data
        Map<String, Object> input = new HashMap<String, Object>();
        Key userKey = KeyFactory.createKey("User", UUID.randomUUID().toString());
        input.put("userKey", userKey);
        input.put("modifiedDate", new Date());
        input.put("word", "The universe is made up of stories, not atoms.");
        input.put("author", "Dr. Tina seelig");
        input.put("cite", "What I wanted to know when I was 20.");
        input.put("desc", "While I thought of my business, this book has given me a lot of hints.");
        input.put("note", "brah brah brah");
        
        // save
        Word saved = service.remember(input);

        // test
        assertThat(saved, is(notNullValue()));
        Word stored = Datastore.get(Word.class, saved.getKey());
        assertThat(stored.getKey(), is(saved.getKey()));
        assertThat(stored.getKey().getName(), is(saved.getKey().getName()));
        assertThat(stored.getUserKey(), is(userKey));
        assertThat(stored.getWord(), is("The universe is made up of stories, not atoms."));
        assertThat(stored.getAuthor(), is("Dr. Tina seelig"));
        assertThat(stored.getCite(), is("What I wanted to know when I was 20."));
        assertThat(stored.getDesc(), is("While I thought of my business, this book has given me a lot of hints."));
        assertThat(stored.getNote(), is("brah brah brah"));
    }

    @Test
    public void update() throws Exception {
        // test user id
        String test_user_id = "testuser";

        // build data
        Map<String, Object> input = new HashMap<String, Object>();
        input.put("userKey", KeyFactory.createKey("User", test_user_id));
        input.put("modifiedDate", new Date());
        input.put("word", "test word");
        input.put("author", "test author");
        input.put("cite", "test cite");
        input.put("desc", "test desc");
        input.put("note", "test note");
        
        // save
        Word saved = service.remember(input);
        assertThat(saved.getWord(), is(input.get("word")));
        
        // retrieve
        Word word = Datastore.get(Word.class, saved.getKey());
        
        // update
        word.setWord("updated word");
        word = service.update(word);
        
        // retrieve again
        word = Datastore.get(Word.class, saved.getKey());
        
        // test
        assertThat(word.getKey(), is(saved.getKey()));
        assertThat(word.getWord(), is("updated word"));
    }
}
