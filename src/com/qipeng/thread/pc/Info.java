package com.qipeng.thread.pc;

/**
 * 信息类（表示资源）
 *
 * @author Alatai
 * @version 1.0
 * @date 2021/06/16 14:45
 */
public class Info {

    private String name = "name";
    private String content = "content";
    private boolean flag = true; // 标志位，初始时先生产

    public synchronized void set(String name, String content) {
        while (!flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.setName(name);

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.setContent(content);
        this.flag = false; // 改变标志位，表示可以取走
        super.notify();
    }

    public synchronized void get() {
        while (flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.getName() + " --> " + this.getContent());
        this.flag = true; // 改变标志位，表示可以生产
        super.notify();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
