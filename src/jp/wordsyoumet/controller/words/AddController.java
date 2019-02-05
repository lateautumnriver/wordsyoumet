package jp.wordsyoumet.controller.words;

import java.util.Map;
import java.util.HashMap;
//import java.util.logging.Logger;
import org.slim3.controller.Navigation;
import jp.wordsyoumet.controller.AuthController;
import jp.wordsyoumet.service.AccountService;
import jp.wordsyoumet.service.WordService;

public class AddController extends AuthController {

    //private static final Logger log = Logger.getLogger(AddController.class.getName());
    private AccountService accountService = new AccountService();
    private WordService wordService = new WordService();

    @Override
    public Navigation run() throws Exception {
        requestScope("title", "Posting new word");

        if (isGet()) {
            return doGet();
        }
        return doPost();
    }

    public Navigation doGet() {
        return forward("/WEB-INF/jsp/words/add.jsp");
    }

    public Navigation doPost() {
        // TODO
        // check params

        // make data
        Map<String, Object> word = new HashMap<String, Object>();
        word.put("userKey", accountService.getUserByEmail(request.getUserPrincipal().getName()).getKey());
        word.put("word", param("new-word"));
        word.put("author", param("new-word-author"));
        word.put("date", param("new-word-date"));
        word.put("cite", param("new-word-cite"));
        word.put("desc", param("new-word-desc"));
        word.put("note", param("new-word-note"));

        // save data
        wordService.remember(word);
        
        return redirect("/words/imet");
    }
}
