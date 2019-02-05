package jp.wordsyoumet.controller.account;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.slim3.controller.Navigation;
import jp.wordsyoumet.controller.AuthController;
import jp.wordsyoumet.service.AccountService;

/**
 * このサービスのユーザアカウントを作成します。
 * @author satoshi
 *
 */
public class CreateController extends AuthController {

    private static final Logger log = Logger.getLogger(CreateController.class.getName()); 
    private AccountService accountService = new AccountService();

    @Override
    public Navigation run() throws Exception {
        if (null != accountService.getUserByEmail(request.getUserPrincipal().getName())) {
            // account has been already created before.
            log.warning("email already exists:" + request.getUserPrincipal().getName());
            return redirect("/words/imet");
        }

        requestScope("title", "Creating Your Account");
        
        if (isGet()) {
            return doGet();
        }
        return doPost();
    }
    
    /**
     * doPost
     */
    private Navigation doPost() {
        // TODO post case
        // check params
        // check nickname syntax [a-z0-9_¥-]{6,32}

        // check nickname exists or not
        if (null != accountService.getUserByNickname(param("account-nickname"))) {
            // error
            // nickname already exists.
            log.warning("nickname already exists:" + param("account-nickname"));
            requestScope("message", "Nickname already exists.");
            requestScope("account-nickname", param("account-nickname"));
            return doGet();
        }

        Map<String, Object> input = new HashMap<String, Object>();
        input.put("nickname", param("account-nickname"));
        input.put("email", request.getUserPrincipal());

        // save data
        accountService.create(input);
        // if success, redirect, or respond json message
        // else set error message and forward, or respond json message
        //return forward("/WEB-INF/jsp/account/create.jsp");
        return redirect("/words/imet");
    }
    
    /**
     * doGet
     */
    private Navigation doGet() {
        return forward("/WEB-INF/jsp/account/create.jsp");
    }
}
