package jp.wordsyoumet.service;

import java.util.Map;
import java.util.List;
import java.util.UUID;
import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;
import jp.wordsyoumet.meta.MessageMeta;
import jp.wordsyoumet.model.Message;

public class MessageService {

    private static final String KIND_NAME = "Message";

    private MessageMeta t = MessageMeta.get();

    /**
     * Messageエンティティのキーを生成します。
     * @param void
     * @return Key エンティティキー
     */
    private Key createKey() {
        return createKey(UUID.randomUUID().toString());
    }
    /**
     * キー名を元にMessageエンティティのキーを生成します。
     * @param String name
     * @return Key エンティティキー
     */
    private Key createKey(String name) {
        return KeyFactory.createKey(KIND_NAME, name);
    }
    
    /**
     * MessageエンティティをIDを元に取得します。
     */
    public Message getById(String messageid) {
        Key messageKey = createKey(messageid);
        Transaction txn = Datastore.beginTransaction();
        Message message = Datastore.get(Message.class, messageKey);
        txn.rollbackAsync();
        return message;
    }
    
    /**
     * recipientKeyとIDを元にMessageエンティティを取得します。
     * @param String messageid
     * @param Key recipientKey
     * @return Message
     */
    public Message getReceivedMessageById(String messageid, Key recipientKey) {
        Message message = getById(messageid);
        if ((message == null) || (! message.isForRecipient(recipientKey))) {
            return null;
        }
        return message;
    }

    /**
     * Messageエンティティを作成します。
     */
    public Message send(Map<String, Object> input) {
        input.put("key", createKey());

        Message message = new Message();
        BeanUtil.copy(input, message);
        Transaction txn = Datastore.beginTransaction();
        Datastore.put(message);
        txn.commitAsync();
        return message;
    }
    
    /**
     * recipientKeyから受け取ったMessageリストを取得します。
     */
    public List<Message> getRecievedMessageList(Key recipientKey) {
        return Datastore.query(t).filter(t.recipientKey.equal(recipientKey)).sort(t.createdDate.desc).asList();
    }
}
