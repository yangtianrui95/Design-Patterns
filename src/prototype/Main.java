package prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangtianrui on 16-10-13.
 */
public class Main {
    public static void main(String[] args) {
        WordDocument document = new WordDocument("Title1", "Img1");
        System.out.println(document);

        try {
            // 使用原型模式进行拷贝
            WordDocument document1 = document.clone();
            List<String> titles = new ArrayList<>();
            titles.add("xxx");
            document1.setTitle(titles);
            document1.setTitle("aaaa");
            System.out.println(document1);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println();

        System.out.println(document);

    }
}
