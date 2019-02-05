package jp.wordsyoumet.controller.words.imet;

//import java.util.logging.Logger;
import jp.wordsyoumet.model.Word;
import jp.wordsyoumet.model.User;
import jp.wordsyoumet.service.AccountService;
import jp.wordsyoumet.service.WordService;
import jp.wordsyoumet.controller.AuthController;
import org.slim3.controller.Navigation;

public class IndexController extends AuthController {
    
//    private static final Logger log = Logger.getLogger(IndexController.class.getName());
    private AccountService accountService = new AccountService();
    private WordService wordService = new WordService();

    @Override
    public Navigation run() throws Exception {
        String wordid = param("wordid");
        
        // TODO
        // check param

        User user = accountService.getUserByEmail(request.getUserPrincipal().getName());
        Word word = wordService.getById(wordid, user.getKey());

        if (word == null) {
            // TODO
            // コンテンツが存在しないページを表示します。
            return forward("/WEB-INF/jsp/words/imet/index.jsp");
        }

        requestScope("word", word);
        requestScope("title", word.getWord());
        return forward("/WEB-INF/jsp/words/imet/index.jsp");
    }
}
