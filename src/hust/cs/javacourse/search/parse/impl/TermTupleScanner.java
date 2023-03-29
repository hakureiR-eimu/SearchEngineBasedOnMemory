package hust.cs.javacourse.search.parse.impl;

import hust.cs.javacourse.search.index.AbstractTerm;
import hust.cs.javacourse.search.index.AbstractTermTuple;
import hust.cs.javacourse.search.index.impl.Term;
import hust.cs.javacourse.search.index.impl.TermTuple;
import hust.cs.javacourse.search.parse.AbstractTermTupleScanner;
import hust.cs.javacourse.search.parse.AbstractTermTupleStream;
import hust.cs.javacourse.search.util.Config;
import hust.cs.javacourse.search.util.StringSplitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TermTupleScanner extends AbstractTermTupleScanner {
	private int position = 0;
	private List<String> buf;
	private StringSplitter stringSplitter = new StringSplitter();

	/**
	 * 获得下一个三元组
	 *
	 * @return: 下一个三元组；如果到了流的末尾，返回null
	 */
	@Override
	public AbstractTermTuple next() {
		try {
			if (buf.isEmpty()) {
				String s;
				StringBuilder sbu = new StringBuilder();
				while ((s = input.readLine()) != null) {
					sbu.append(s).append("\n");
				}
				s = sbu.toString().trim();
				s = s.toLowerCase();
				buf = stringSplitter.splitByRegex(s);
			}
			if(buf.size()==0)
				return null;
			AbstractTerm term=new Term(buf.get(0));
			buf.remove(0);
			return new TermTuple(term,position++);


		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭流
	 */
	@Override
	public void close() {
	}
	public TermTupleScanner(BufferedReader input){
		super(input);
		buf=new ArrayList<>();
		stringSplitter.setSplitRegex(Config.STRING_SPLITTER_REGEX);
	}
}
