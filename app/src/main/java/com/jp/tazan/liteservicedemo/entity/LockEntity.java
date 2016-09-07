package com.jp.tazan.liteservicedemo.entity;

import java.util.List;

/**
 * Created by Administrator on 2016-09-07.
 */
public class LockEntity {


    /**
     * code : 0
     * info :
     * data : [{"id":"10","number":"001","name":"华力大厦1号基站","area":"华力大厦基站","esn":"00000017","long":"104.091186","lat":"30.595466","remark":"移动"},{"id":"11","number":"002","name":"华力大厦2号基站","area":"华力大厦基站","esn":"","long":"104.091413","lat":"30.595398","remark":"电信"}]
     */

    private String code;
    private String info;
    /**
     * id : 10
     * number : 001
     * name : 华力大厦1号基站
     * area : 华力大厦基站
     * esn : 00000017
     * long : 104.091186
     * lat : 30.595466
     * remark : 移动
     */

    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String number;
        private String name;
        private String area;
        private String esn;
        @com.google.gson.annotations.SerializedName("long")
        private String longX;
        private String lat;
        private String remark;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getEsn() {
            return esn;
        }

        public void setEsn(String esn) {
            this.esn = esn;
        }

        public String getLongX() {
            return longX;
        }

        public void setLongX(String longX) {
            this.longX = longX;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
