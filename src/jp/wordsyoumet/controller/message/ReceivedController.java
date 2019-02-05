package jp.wordsyoumet.controller.message;

//import java.util.logging.Logger;
import jp.wordsyoumet.controller.AuthController;
import org.slim3.controller.Navigation;
import jp.wordsyoumet.model.Message;
import jp.wordsyoumet.model.Word;
import jp.wordsyoumet.model.User;
import jp.wordsyoumet.service.AccountService;
import jp.wordsyoumet.service.MessageService;
import jp.wordsyoumet.service.WordService;

public class ReceivedController extends AuthController {

    //  private static final Logger log = Logger.getLogger(IndexController.class.getName());
    private AccountService accountService = new AccountService();
    private WordService wordService = new WordService();
    private MessageService messageService = new MessageService();

    @Override
    public Navigation run() throws Exception {
        String messageid = param("messageid");
        
        // TODO
        // check param

        User user = accountService.getUserByEmail(request.getUserPrincipal().getName());
        Message message = messageService.getReceivedMessageById(messageid, user.getKey());
        if (message == null) {
            return redirect("/message/");
        }
        Word word = wordService.getByKey(message.getWordKey());
        if (word == null) {
            return redirect("/message/");
        }
        User sender = accountService.getByKey(message.getSenderKey());
        if (sender == null) {
            return redirect("/message/");
        }
        
        requestScope("message", message);
        requestScope("word", word);
        requestScope("sender", sender);

        return forward("/WEB-INF/jsp/message/received.jsp");
    }
}
