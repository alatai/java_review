package com.qipeng.jdbc.model;

import com.qipeng.jdbc.util.Column;
import com.qipeng.jdbc.util.Table;

import java.math.BigDecimal;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/12/31 17:44
 */
@Table("salgrade")
public class Salgrade {

    @Column("GRADE")
    private BigDecimal grade;
    @Column("LOSAL")
    private BigDecimal losal;
    private BigDecimal HISAL;

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public BigDecimal getLosal() {
        return losal;
    }

    public void setLosal(BigDecimal losal) {
        this.losal = losal;
    }

    public BigDecimal getHISAL() {
        return HISAL;
    }

    public void setHISAL(BigDecimal HISAL) {
        this.HISAL = HISAL;
    }

    @Override
    public String toString() {
        return "Salgrade{" +
                "grade=" + grade +
                ", losal=" + losal +
                ", HISAL=" + HISAL +
                '}';
    }
}
