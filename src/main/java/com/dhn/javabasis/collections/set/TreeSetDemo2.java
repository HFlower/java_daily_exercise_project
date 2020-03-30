package com.dhn.javabasis.collections.set;

import java.util.Objects;
import java.util.TreeSet;

/**
 * @description:
 * @author: Dong HuaNan
 * @date: 2020/3/29 12:38
 */
public class TreeSetDemo2 {

    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add(new R(5));
        ts.add(new R(-3));
        ts.add(new R(9));
        ts.add(new R(-2));
        System.out.println(ts);
        R first = (R) ts.first();
        first.count = 20;
        R last = (R) ts.last();
        last.count = -2;
        System.out.println(ts);

        //删除实例变量被改变的变量，删除失败
        System.out.println(ts.remove(new R(-2)));
        System.out.println(ts);
        //删除实例变量没被改变的变量，删除成功
        System.out.println(ts.remove(new R(5)));
        System.out.println(ts);

    }

}

class R implements Comparable{
    int count;

    public R(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "R{" +
                "count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && o.getClass() == R.class) {
            R r = (R) o;
            return r.count == this.count;
        }
        return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public int compareTo(Object o) {
        R r = (R) o;
        return count > r.count ? 1 : count < r.count ? -1 : 0;
    }
}
