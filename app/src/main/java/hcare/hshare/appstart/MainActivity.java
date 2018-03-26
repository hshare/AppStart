package hcare.hshare.appstart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document doc = Jsoup.connect("http://www.duwenzhang.com/wenzhang/qinqingwenzhang/").get();
                    Elements elements = doc.select("center table tbody tr td table tbody tr td table.tbspan");
                    for (int i = 0; i < elements.size(); i++) {
                        Elements es = elements.get(i).select("tr td");
                        if (es.size() == 6) {
                            String title = es.get(2).text();
                            String url = es.get(2).select("a").attr("href");
                            String date = es.get(4).text();
                            String content = es.get(5).text();
                            Log.i("hzl", title + "\n" + date + "\n" + url + "\n" + content + "\n-------------------\n");
                        }
                    }

                } catch (Exception e) {
                    Log.i("hzl", e.toString());
                }

            }
        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Document doc = Jsoup.connect("http://www.duwenzhang.com/wenzhang/youqingwenzhang/").get();
//                    Elements elements = doc.select("center table tbody tr td table tbody tr td table.tbspan");
//                    for (int i = 0; i < elements.size(); i++) {
//                        Elements es = elements.get(i).select("tr td");
//                        if (es.size() == 6) {
//
//                            String title = es.get(2).text();
//                            String url = es.get(2).select("a.ulink").attr("href");
//                            Elements titles = es.get(2).select("a");
//                            if (titles.size() == 2){
//                                title = titles.get(1).text();
//                                url = titles.get(1).attr("href");
//                            }
//
//
//                            String date = es.get(4).text();
//                            String content = es.get(5).text();
//                            String pic = es.get(5).select("img").attr("src");
//                            Log.i("hzl", title + "\n" + date + "\n" + url + "\n" + pic + "\n" + content + "\n-------------------\n");
//
//                        }
//                    }
//
//                } catch (Exception e) {
//                    Log.i("hzl", e.toString());
//                }
//
//            }
//        }).start();
    }
}
