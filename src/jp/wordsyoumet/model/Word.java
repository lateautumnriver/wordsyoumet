package jp.wordsyoumet.model;

import java.io.Serializable;
import java.util.Date;
import com.google.appengine.api.datastore.Key;
import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class Word implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    // created date
    private Date createdDate = new Date();
    
    // modified date
    private Date modifiedDate;
    
    // user key
    private Key userKey;
    
    // word
    private String word;
    
    // author
    private String author;
    
    // date user met the word at
    private String date;
    
    // cite
    private String cite;
    
    // description
    private String desc;
    
    // note
    private String note;

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
     * set/get modified date
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    
    /**
     * set/get user key
     */
    public Key getUserKey() {
        return userKey;
    }
    public void setUserKey(Key userKey) {
        this.userKey = userKey;
    }
    
    /**
     * set/get word
     */
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    
    /**
     * set/get author
     */
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    
    /**
     * set/get date
     */
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    
    /**
     * set/get cite
     */
    public String getCite() {
        return cite;
    }
    public void setCite(String cite) {
        this.cite = cite;
    }
    
    /**
     * set/get description
     */
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    /**
     * set/get note
     */
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    
    /**
     * エンティティが指定されたユーザのものか判定します。
     * @param Key userKey
     * @return Boolean ユーザのものならばtrueを返します。
     */
    public Boolean belongsToUser(Key userKey) {
        if (userKey.equals(getUserKey())) {
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
        Word other = (Word) obj;
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
