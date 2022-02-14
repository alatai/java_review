package com.qipeng.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/06/13 14:05
 */
public class SafeCollectionIteration {

    public static void main(String[] args) {
        // 为了安全起见，仅使用同步列表的一个引用，这样可以确保控制了所有访问
        // 集合同步化
        List<String> wordList = Collections.synchronizedList(new ArrayList<>());

        wordList.add("Iterators");
        wordList.add("require");
        wordList.add("special");
        wordList.add("handling");

        // 多线程中安全遍历集合元素的示例
        synchronized (wordList) {
            Iterator<String> iter = wordList.iterator();
            while (iter.hasNext()) {
                String word = iter.next();
                System.out.println(word);
            }
        }
    }
}
