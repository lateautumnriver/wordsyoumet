package jp.wordsyoumet.controller.message;

//import java.util.logging.Logger;
import java.util.*;
import jp.wordsyoumet.model.Word;
import jp.wordsyoumet.model.User;
import jp.wordsyoumet.service.AccountService;
import jp.wordsyoumet.service.WordService;
import jp.wordsyoumet.service.MessageService;
import jp.wordsyoumet.controller.AuthController;
import org.slim3.controller.Navigation;

public class SendController extends AuthController {

//  private static final Logger log = Logger.getLogger(IndexController.class.getName());
    private AccountService accountService = new AccountService();
    private WordService wordService = new WordService();
    private MessageService messageService = new MessageService();
    private String wordid;
    private User user;
    private Word word;

    @Override
    public Navigation run() throws Exception {
        wordid = param("wordid");
        // TODO
        // check param
        if (wordid == null) {
            return redirect("/words/imet");
        }

        user = accountService.getUserByEmail(request.getUserPrincipal().getName());
        word = wordService.getById(wordid, user.getKey());
        if (word == null) {
            // TODO
            // コンテンツが存在しないページを表示します。
            return redirect("/words/imet");
        }

        if (isGet()) {
            return doGet();
        }
        return doPost();
    }
    
    private Navigation doGet() throws Exception {
        requestScope("word", word);
        requestScope("title", word.getWord());

        // 友達のニックネームリストを取得します。
        requestScope("friendList", getFriendNicknames(user));

        return forward("/WEB-INF/jsp/message/send.jsp");
    }
    
    private Navigation doPost() throws Exception {
        // TODO
        // check params
        User recipient = accountService.getUserByNickname(param("message-to"));
        if (recipient == null) {
            requestScope("error", "Select recipient.");
            return doGet();
        }

        Map<String, Object> message = new HashMap<String, Object>();
        message.put("recipientKey", recipient.getKey());
        message.put("wordKey", word.getKey());
        message.put("senderKey", user.getKey());
        message.put("message", param("message-body"));
        
        // 保存します。
        messageService.send(message);

        return redirect("/words/imet/" + wordid);
    }
    
    /**
     * 友達のニックネームリストを取得します。
     * TODO
     * 友達リストは全くの未実装
     * スタブです。
     *
     * @param user
     * @return
     */
    private List<String> getFriendNicknames(User user) {
        List<String> nicknames = new ArrayList<String>();
        if (! "sato-c".equals(user.getNickname())) {
            nicknames.add("sato-c");
        }
        if (! "mamama".equals(user.getNickname())) {
            nicknames.add("mamama");
        }
        if (! "komadev".equals(user.getNickname())) {
            nicknames.add("komadev");
        }
        if (! "komozilla".equals(user.getNickname())) {
            nicknames.add("komozilla");
        }
        return nicknames;
    }
}
