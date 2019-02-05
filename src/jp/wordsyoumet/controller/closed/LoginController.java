package jp.wordsyoumet.controller.closed;

import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;
import org.slim3.controller.Navigation;
import jp.wordsyoumet.controller.AppController;
import jp.wordsyoumet.service.UserService;

/**
 * prototype用サービス認証コントローラ
 * サインインしている必要はないため、AppControllerを継承しています。
 * @author satoshi
 *
 */
public class LoginController extends AppController {

    private UserService userService = new UserService();

    @Override
    public Navigation run() throws Exception {
        Logger log = Logger.getLogger(LoginController.class.getName());
        log.warning("login controller run");

        if (! isPost()) {
            response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            return redirect("/");
        }
        if (! "wordsyoumet".equals(param("closed-service-account"))) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return redirect("/");
        }
        if (! "imetaword".equals(param("closed-service-password"))) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return redirect("/");
        }

        // TODO Set cookie for the rest of requests
        // cookie life time will be 1 week
    
        if (userService.isUserSigned()) {
            return redirect("/words/imet");
        }
        return redirect(userService.createLoginURL("/words/imet"));
    }
}
