/**
 * wordsyoumetのユーザーサービスです。
 * GAEのユーザーサービスをラップしています。
 * アプリケーションから取得するユーザー情報等は、このサービスを利用します。
 * ユーザー情報オブジェクトもwordsyoumetのユーザー情報オブジェクトを使います。
 * 従って、GAEのユーザープリファレンスを使用するのは、ユーザー認証時に限ります？
 * 
 * TODO
 * memcacheを使用すること。
 * wordsyoumetのユーザー情報を持つkindを用意します。
 */
package jp.wordsyoumet.service;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;

public class UserService {

    /**
     * GAEのユーザーサービスです。
     */
    private com.google.appengine.api.users.UserService userService = UserServiceFactory.getUserService();

    /**
     * ログインしているか判定します。
     * 
     * @param  void
     * @return boolean
     */
    public boolean isUserSigned() {
        User user = userService.getCurrentUser();
        return (user != null);
    }
    
    /**
     * ログインURLを返します。
     * 
     * @param  String  リダイレクト先URL
     * @return String  ログインURL
     */
    public String createLoginURL(String destinationURL) {
        return userService.createLoginURL(destinationURL);
    }

    /**
     * ログアウトURLを返します。
     * 
     * @param  String  リダイレクト先URL
     * @return String  ログアウトURL
     */
    public String createLogoutURL(String destinationURL) {
        return userService.createLogoutURL(destinationURL);
    }
}
