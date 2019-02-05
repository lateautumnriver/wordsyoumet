package jp.wordsyoumet.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public abstract class AppController extends Controller {

    /**
     * 全てのコントローラで共通のセットアップ処理を行います。
     * 
     * @return the navigation
     */
    @Override
    protected Navigation setUp() {
        // デフォルトのページタイトルを設定します。
        // 各ページでページタイトルを上書きします。
        // TODO
        // デフォルトのページタイトルやタイトルのキー（ここではpageTitle）
        // をどこかに共通化して持たせたい。
        requestScope("title", "");
        requestScope("theme", "c");
        requestScope("theme_header", "a");
        return null;
    }
}
