package com.jp.tazan.liteservicedemo.entity;

/**
 * Created by Administrator on 2016-09-07.
 */
public class KeyExsitedEntity {


    /**
     * code : 0
     * info :
     * data : {"existed":1,"enable":1}
     */

    private String code;
    private String info;
    /**
     * existed : 1
     * enable : 1
     */

    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int existed;
        private int enable;

        public int getExisted() {
            return existed;
        }

        public void setExisted(int existed) {
            this.existed = existed;
        }

        public int getEnable() {
            return enable;
        }

        public void setEnable(int enable) {
            this.enable = enable;
        }
    }
}
