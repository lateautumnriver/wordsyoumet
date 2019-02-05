package jp.wordsyoumet.service;

import java.util.Map;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;
import jp.wordsyoumet.meta.UserMeta;
import jp.wordsyoumet.model.User;

public class AccountService {
    
    private UserMeta t = UserMeta.get();

    /**
     * ユーザエンティティを作成します。
     * @param input
     * @return
     */
    public User create(Map<String, Object> input) {
        User user = new User();
        BeanUtil.copy(input, user);
        Transaction txn = Datastore.beginTransaction();
        Datastore.put(user);
        txn.commit();
        return user;
    }
    
    /**
     * キーを指定してユーザ情報を取得します。
     * @param userKey
     * @return
     */
    public User getByKey(Key userKey) {
        Transaction txn = Datastore.beginTransaction();
        User user = Datastore.get(User.class, userKey);
        txn.rollbackAsync();
        return user;
    }

    public User getUserByEmail(String email) {
        return Datastore.query(t).filter(t.email.equal(email)).asSingle();
    }
    
    public User getUserByNickname(String nickname) {
        return Datastore.query(t).filter(t.nickname.equal(nickname)).asSingle();
    }
}
