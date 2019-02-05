package jp.wordsyoumet.controller.words;

import java.util.List;
//import java.util.logging.Logger;
import org.slim3.controller.Navigation;
import jp.wordsyoumet.controller.AuthController;
import jp.wordsyoumet.service.AccountService;
import jp.wordsyoumet.service.WordService;
import jp.wordsyoumet.model.Word;

/**
 * ユーザのマイページ
 * @author satoshi
 *
 */
public class ImetController extends AuthController {

    //private static final Logger log = Logger.getLogger(ImetController.class.getName());
    private AccountService accountService = new AccountService();
    private WordService wordService = new WordService();

    @Override
    public Navigation run() throws Exception {
        requestScope("title", "Words");
        
        // get the word list
        List<Word> wordList = wordService.getWordList(accountService.getUserByEmail(request.getUserPrincipal().getName()).getKey());
        requestScope("wordList", wordList);

        return forward("/WEB-INF/jsp/words/imet.jsp");
    }
}
