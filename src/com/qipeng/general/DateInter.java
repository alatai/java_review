package com.qipeng.general;

import java.util.Date;

/**
 * @author Qp
 * @version 1.0
 * @date 2020/12/11 20:03
 */
public class DateInter extends Pair<Date>{

    public DateInter() {
        super();
    }

    public DateInter(Date first, Date last) {
        super(first, last);
    }

    @Override
    public Date getFirst() {
        return super.getFirst();
    }

    @Override
    public Date getLast() {
        return super.getLast();
    }

    @Override
    public void setFirst(Date first) {
        super.setFirst(first);
    }

    @Override
    public void setLast(Date last) {
        super.setLast(last);
    }
}
