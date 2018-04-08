package com.vnext.dao;

import org.springframework.stereotype.Repository;

/**
 * @author leo
 * @version 2018/4/5 8:16
 * @since 1.0.0
 */
@Repository
public class BookDao {

    private String lable = "1";

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "BookDao [lable=" + lable + "]";
    }

}
