package hust.cs.javacourse.search.run;

import hust.cs.javacourse.search.index.AbstractDocumentBuilder;
import hust.cs.javacourse.search.index.AbstractIndex;
import hust.cs.javacourse.search.index.AbstractIndexBuilder;
import hust.cs.javacourse.search.index.impl.DocumentBuilder;
import hust.cs.javacourse.search.index.impl.IndexBuilder;
import hust.cs.javacourse.search.util.Config;

import java.io.File;

/**
 * 测试索引构建
 */
public class TestBuildIndex {
    /**
     *  索引构建程序入口
     * @param args : 命令行参数
     */
    public static void main(String[] args){
    /*System.out.println("hello world");
    System.out.println(Config.DOC_DIR);
    System.out.println(Config.INDEX_DIR);
    System.out.println(Config.PROJECT_HOME_DIR);
    */
        AbstractIndexBuilder indexBuilder = new IndexBuilder(new DocumentBuilder());
        AbstractIndex index = indexBuilder.buildIndex(Config.DOC_DIR);
        System.out.println(index.toString());
        File file = new File(Config.INDEX_DIR + "index.dat");
        index.save(file);
    }
}
