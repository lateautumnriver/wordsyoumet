package jp.wordsyoumet.controller.message;

import java.util.List;
//import java.util.logging.Logger;
import jp.wordsyoumet.controller.AuthController;
import org.slim3.controller.Navigation;
import jp.wordsyoumet.service.AccountService;
import jp.wordsyoumet.service.MessageService;
import jp.wordsyoumet.model.Message;

public class IndexController extends AuthController {

    //private static final Logger log = Logger.getLogger(ImetController.class.getName());
    private AccountService accountService = new AccountService();
    private MessageService messageService = new MessageService();

    @Override
    public Navigation run() throws Exception {
        requestScope("title", "Messages");

        // get the word list
        List<Message> messageList = messageService.getRecievedMessageList(accountService.getUserByEmail(request.getUserPrincipal().getName()).getKey());
        requestScope("messageList", messageList);

        return forward("/WEB-INF/jsp/message/index.jsp");
    }
}
