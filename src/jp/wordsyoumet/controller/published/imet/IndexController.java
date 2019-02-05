package jp.wordsyoumet.controller.published.imet;

import java.util.List;
import jp.wordsyoumet.controller.AppController;
import org.slim3.controller.Navigation;
import jp.wordsyoumet.service.AccountService;
import jp.wordsyoumet.service.WordService;
import jp.wordsyoumet.model.Word;
import jp.wordsyoumet.model.User;

public class IndexController extends AppController {

    private AccountService accountService = new AccountService();
    private WordService wordService = new WordService();

    @Override
    public Navigation run() throws Exception {
        String nickname = param("nickname");
        requestScope("title", nickname);
        requestScope("nickname", nickname);
        
        // get the word list
        List<Word> wordList = wordService.getWordList(accountService.getUserByNickname(nickname).getKey());
        requestScope("wordList", wordList);
        
        // get user if user signed in
        String userName = (request.getUserPrincipal() != null) ? request.getUserPrincipal().getName() : null;
        if (userName != null) {
            User user = accountService.getUserByEmail(userName);
            requestScope("user", user);
        }
        
        return forward("/WEB-INF/jsp/published/imet/index.jsp");
    }
}
