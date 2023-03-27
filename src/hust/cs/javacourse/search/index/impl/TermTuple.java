package hust.cs.javacourse.search.index.impl;

import hust.cs.javacourse.search.index.AbstractTermTuple;

public class TermTuple extends AbstractTermTuple {

    /**
     * 判断二个三元组内容是否相同
     *
     * @param obj ：要比较的另外一个三元组
     * @return 如果内容相等（三个属性内容都相等）返回true，否则返回false
     */
    @Override
    public boolean equals(Object obj) {
        return false;
    }

    /**
     * 获得三元组的字符串表示
     *
     * @return ： 三元组的字符串表示
     */
    @Override
    public String toString() {
        return null;
    }
}
