package jp.wordsyoumet.service;

import java.util.Map;
import java.util.List;
import java.util.UUID;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;
import jp.wordsyoumet.meta.WordMeta;
import jp.wordsyoumet.model.Word;

public class WordService {
    
    private static final String KIND_NAME = "Word";

    private WordMeta t = WordMeta.get();
    
    /**
     * Wordエンティティのキーを生成します。
     * @param void
     * @return Key エンティティキー
     */
    private Key createKey() {
        return createKey(UUID.randomUUID().toString());
    }
    /**
     * キー名を元にWordエンティティのキーを生成します。
     * @param String name
     * @return Key エンティティキー
     */
    private Key createKey(String name) {
        return KeyFactory.createKey(KIND_NAME, name);
    }
    
    /**
     * Wordエンティティをkeyを元に取得します。
     */
    public Word getByKey(Key wordKey) {
        Transaction txn = Datastore.beginTransaction();
        Word word = Datastore.get(Word.class, wordKey);
        txn.rollbackAsync();
        return word;
    }
    
    /**
     * WordエンティティをIDを元に取得します。
     */
    public Word getById(String wordid) {
        return getByKey(createKey(wordid));
    }
    
    /**
     * userKeyとIDを元にWordエンティティを取得します。
     * @param String wordid
     * @param Key userKey
     * @return Word
     */
    public Word getById(String wordid, Key userKey) {
        Word word = getById(wordid);
        if ((word == null) || (! word.belongsToUser(userKey))) {
            return null;
        }
        return word;
    }

    /**
     * Wordエンティティを作成します。
     */
    public Word remember(Map<String, Object> input) {
        input.put("key", createKey());

        Word word = new Word();
        BeanUtil.copy(input, word);
        Transaction txn = Datastore.beginTransaction();
        Datastore.put(word);
        txn.commitAsync();
        return word;
    }
    
    /**
     * Wordエンティティを更新します。
     */
    public Word update(Word word) {
        Transaction txn = Datastore.beginTransaction();
        Datastore.put(word);
        txn.commitAsync();
        return word;
    }
    
    /**
     * TODO
     * Wordエンティティを削除します。
     */
    public Boolean deleteById(String wordid) {
        Key wordKey = createKey(wordid);
        Transaction txn = Datastore.beginTransaction();
        Datastore.deleteAsync(wordKey);
        txn.commitAsync();
        return true;
    }
    
    /**
     * UserKeyからWordリストを取得します。
     */
    public List<Word> getWordList(Key userKey) {
        return Datastore.query(t).filter(t.userKey.equal(userKey)).sort(t.createdDate.desc).asList();
    }
}
