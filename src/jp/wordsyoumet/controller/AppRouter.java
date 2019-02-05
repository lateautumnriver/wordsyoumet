package jp.wordsyoumet.controller;

import org.slim3.controller.router.RouterImpl;

public class AppRouter extends RouterImpl {

    public AppRouter() {
        addRouting("/words/", "/words/imet");
        addRouting("/words/imet/", "/words/imet");
        addRouting("/words/imet/{wordid}", "/words/imet/?wordid={wordid}");
        addRouting("/words/imet/delete/{wordid}", "/words/imet/delete?wordid={wordid}");
        addRouting("/published/imet/{nickname}", "/published/imet/index?nickname={nickname}");
        addRouting("/published/imet/{nickname}/{wordid}", "/published/imet/aword?nickname={nickname}&wordid={wordid}");
        addRouting("/message/send/{wordid}", "/message/send?wordid={wordid}");
        addRouting("/message/received/{messageid}", "/message/received?messageid={messageid}");
        
        /**
         * 新しいルーティング
         */
        addRouting("/", "/signin/"); // 認証チェック+フォーム画面表示。ログインしているなら/words/へリダイレクト
        addRouting("/account/signin/", "/account/signin"); // サインイン選択画面(FB/gmail/etc.)
        addRouting("/words/","/words/list");
        addRouting("/words/list/","/words/list");
        addRouting("/words/{wordid}", "/words/?wordid={wordid}");
    }
}
