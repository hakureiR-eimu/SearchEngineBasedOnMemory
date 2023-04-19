package hust.cs.javacourse.search.run;

import hust.cs.javacourse.search.index.impl.Term;
import hust.cs.javacourse.search.parse.AbstractTermTupleStream;
import hust.cs.javacourse.search.query.AbstractHit;
import hust.cs.javacourse.search.query.AbstractIndexSearcher;
import hust.cs.javacourse.search.query.Sort;
import hust.cs.javacourse.search.query.impl.IndexSearcher;
import hust.cs.javacourse.search.query.impl.SimpleSorter;
import hust.cs.javacourse.search.util.Config;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 测试搜索
 */
public class TestSearchIndex {
    /**
     *  搜索程序入口
     * @param args ：命令行参数
     */
    public static void main(String[] args){
        //System.out.println("hello world");
        List<Integer> sc=null;
        IndexSearcher indexSearcher = new IndexSearcher();
        indexSearcher.open(Config.INDEX_DIR + "index.dat");
        SimpleSorter sorter = new SimpleSorter();
        System.out.println("Input one word to query or input q to exit:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String target;
        /*
        int x=sc.
        for (int x: sc){

        }

         */
        try {
            while ((target = bufferedReader.readLine()) != null && !target.equals("q") && !target.equals("Q")) {
                String[] split = target.split(" ");
                if (split.length == 1) {
                    AbstractHit[] hits = indexSearcher.search(new Term(target), sorter);
                    if (hits == null)
                        System.out.println("Not Found");
                    else for (AbstractHit hit : hits)
                        System.out.println(hit.toString());
                    System.out.println("Input one word to query or input q to exit:");
                }else if(split.length == 2){
                    AbstractHit[] hits = indexSearcher.search(new Term(split[0]),new Term(split[1]),sorter);
                    if (hits == null)
                        System.out.println("Not Found");
                    else for (AbstractHit hit : hits)
                        System.out.println(hit.toString());
                    System.out.println("Input one word to query or input q to exit:");
                }
                else if(split.length == 3){
                    AbstractHit[] hits = indexSearcher.search(new Term(split[0]), new Term(split[2]), sorter, AbstractIndexSearcher.LogicalCombination.valueof(split[1]));
                    if (hits == null)
                        System.out.println("Not Found");
                    else for (AbstractHit hit : hits)
                        System.out.println(hit.toString());
                    System.out.println("Input one word to query or input q to exit:");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
