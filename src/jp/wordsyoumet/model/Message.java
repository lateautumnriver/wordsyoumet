package jp.wordsyoumet.model;

import java.io.Serializable;
import java.util.Date;
import com.google.appengine.api.datastore.Key;
import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    // created date
    private Date createdDate = new Date();

    // sender key
    private Key senderKey;
    
    // recipient key
    private Key recipientKey;
    
    // word key
    private Key wordKey;
    
    // message
    private String message;

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * get id
     * 
     */
    public String getId() {
        return key.getName();
    }

    /**
     * set/get created date
     */
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * set/get sender key
     */
    public Key getSenderKey() {
        return senderKey;
    }
    public void setSenderKey(Key senderKey) {
        this.senderKey = senderKey;
    }

    /**
     * set/get recipient key
     */
    public Key getRecipientKey() {
        return recipientKey;
    }
    public void setRecipientKey(Key recipientKey) {
        this.recipientKey = recipientKey;
    }
    
    /**
     * set/get word key
     */
    public Key getWordKey() {
        return wordKey;
    }
    public void setWordKey(Key wordKey) {
        this.wordKey = wordKey;
    }

    /**
     * set/get message
     */
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     * エンティティがrecipientKeyで指定されたユーザに対するメッセージか判定します。
     */
    public Boolean isForRecipient(Key recipientKey) {
        if (recipientKey.equals(getRecipientKey())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Message other = (Message) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
}
