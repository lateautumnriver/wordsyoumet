package jp.wordsyoumet.controller.words.imet;

import jp.wordsyoumet.controller.AuthController;
import jp.wordsyoumet.service.WordService;
import org.slim3.controller.Navigation;

public class DeleteController extends AuthController {

    private WordService wordService = new WordService();

    @Override
    public Navigation run() throws Exception {
        String wordid = param("wordid");

        // TODO
        // check param

        wordService.deleteById(wordid);
        return redirect("/words/imet");
    }
}
