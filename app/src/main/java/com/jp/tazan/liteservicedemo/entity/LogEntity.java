package com.jp.tazan.liteservicedemo.entity;

import java.util.List;

/**
 * Created by Administrator on 2016-09-07.
 */
public class LogEntity {

    /**
     * code : 0
     * info :
     * data : [{"id":"2351","lock":"华力大厦1号基站","employee":"cody3","result":"5","time":"2016-09-07 14:33:26"},{"id":"2350","lock":"华力大厦1号基站","employee":"cody3","result":"5","time":"2016-09-07 14:33:16"},{"id":"2349","lock":"华力大厦1号基站","employee":"cody3","result":"5","time":"2016-09-07 14:33:02"}]
     */

    private String code;
    private String info;
    /**
     * id : 2351
     * lock : 华力大厦1号基站
     * employee : cody3
     * result : 5
     * time : 2016-09-07 14:33:26
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
        private String lock;
        private String employee;
        private String result;
        private String time;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLock() {
            return lock;
        }

        public void setLock(String lock) {
            this.lock = lock;
        }

        public String getEmployee() {
            return employee;
        }

        public void setEmployee(String employee) {
            this.employee = employee;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
