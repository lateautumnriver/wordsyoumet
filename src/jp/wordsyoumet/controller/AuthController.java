/**
 * wordsyoumetのユーザ認証のための抽象ベースコントローラです。
 */
package jp.wordsyoumet.controller;

import java.util.logging.Logger;
import org.slim3.controller.Navigation;
import jp.wordsyoumet.controller.AppController;
import jp.wordsyoumet.filter.ClosedServiceAuth;
import jp.wordsyoumet.service.UserService;
import jp.wordsyoumet.service.AccountService;
import jp.wordsyoumet.model.User;

public abstract class AuthController extends AppController {

    private static final Logger log = Logger.getLogger(ClosedServiceAuth.class.getName()); 
    private UserService userService = new UserService();
    private AccountService accountService = new AccountService();
    
    /**
     * ログインユーザアカウント情報
     * Userエンティティ
     */
    protected User user;

    /**
     * ユーザーがログインしているか認証を行います。 認証に成功した場合は、nullを返します。
     * 認証に失敗した場合は、リダイレクト先を指定してNavigationオブジェクトを返します。
     * 
     * @return the navigation
     */
    @Override
    protected Navigation setUp() {
        Navigation nav = super.setUp();
        if (nav != null) {
            return nav;
        }
        
        // user does not sign in
        if (! userService.isUserSigned()) {
            log.warning("Not permitted request.");
            return redirect("/");
        }
        
        // user does not create account
        // TODO
        // jp.wordsyoumet.controller.Account.CreateControllerもこのクラスを継承しているためこのURLパスを回避している。
        // でも汚いので直したい。
        user = accountService.getUserByEmail(request.getUserPrincipal().getName());
        if ((! "/account/create".equals(request.getRequestURI())) && (user == null)) {
            log.warning("User does not have account.");
            return redirect("/account/create");
        }
        
        if (user != null) {
            requestScope("userName", user.getNickname());
        }

        // user signed in and has account.
        requestScope("user", user);
        requestScope("signoutURL", userService.createLogoutURL("/"));
        return null;
    }
}
