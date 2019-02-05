package jp.wordsyoumet.controller.published.imet;

import jp.wordsyoumet.model.Word;
import jp.wordsyoumet.model.User;
import jp.wordsyoumet.service.UserService;
import jp.wordsyoumet.service.AccountService;
import jp.wordsyoumet.service.WordService;
import jp.wordsyoumet.controller.AppController;
import org.slim3.controller.Navigation;

public class AwordController extends AppController {

    private UserService userService = new UserService();
    private AccountService accountService = new AccountService();
    private WordService wordService = new WordService();

    @Override
    public Navigation run() throws Exception {
        String nickname = param("nickname");
        String wordid = param("wordid");
        requestScope("title", nickname);
        requestScope("nickname", nickname);
        requestScope("wordid", wordid);

        Word word = wordService.getById(wordid);
        if (word == null) {
            // TODO
            // コンテンツが存在しないページを表示します。
            return forward("/WEB-INF/jsp/published/imet/aword.jsp");
        }
        requestScope("word", word);

        // TODO
        // jp.wordsyoumet.Controller.published.imet.IndexControllerと重複している。
        // get user if user signed in
        String userName = (request.getUserPrincipal() != null) ? request.getUserPrincipal().getName() : null;
        if (userName != null) {
            User user = accountService.getUserByEmail(userName);
            requestScope("user", user);
        } else {
            requestScope("signinURL", userService.createLoginURL("/published/imet/" + nickname + "/" + wordid));
        }

        return forward("/WEB-INF/jsp/published/imet/aword.jsp");
    }
}
