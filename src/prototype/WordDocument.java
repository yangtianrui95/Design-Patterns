package prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangtianrui on 16-10-13.
 * 使用原型模式,实现深拷贝
 */
public class WordDocument implements Cloneable {


    private List<String> mTitles = new ArrayList<>();
    private List<String> mImgs = new ArrayList<>();


    public WordDocument() {

    }


    public WordDocument(String title, String imgs) {
        mTitles.add(title);
        mImgs.add(imgs);
    }

    public void setTitle(List<String> titles) {
        mTitles = titles;
    }

    public void setTitle(String title) {
        mTitles.set(0, title);
    }

    @Override
    public String toString() {
        return "Title: " + mTitles.get(0) + " imgs : " + mImgs.get(0);
    }

    /*拷贝构造函数*/
    public WordDocument(WordDocument wordDocument) {

    }

    @Override
    protected WordDocument clone() throws CloneNotSupportedException {
        // 浅拷贝
        WordDocument document = (WordDocument) super.clone();
        document.mImgs = this.mImgs;
        document.mTitles = this.mTitles;
        return document;
    }


}
