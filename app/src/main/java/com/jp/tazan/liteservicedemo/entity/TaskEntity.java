package com.jp.tazan.liteservicedemo.entity;

import java.util.List;

/**
 * Created by Administrator on 2016-09-07.
 */
public class TaskEntity {


    /**
     * code : 0
     * info :
     * data : [{"id":"216","employee":"cody3","name":"cs","starttime":"2016-09-14 12:28:59","endtime":"2016-09-08 12:28:59","locks":",,","status":"1","type":"开锁任务"},{"id":"231","employee":"cody3","name":"申请临时任务","starttime":"2016-09-07 14:31:40","endtime":"2016-09-07 15:01:40","locks":"00000017","status":"2","type":"开锁任务"},{"id":"230","employee":"cody3","name":"申请临时任务","starttime":"2016-09-07 13:11:18","endtime":"2016-09-07 13:41:18","locks":"00000001","status":"2","type":"开锁任务"}]
     */

    private String code;
    private String info;
    /**
     * id : 216
     * employee : cody3
     * name : cs
     * starttime : 2016-09-14 12:28:59
     * endtime : 2016-09-08 12:28:59
     * locks : ,,
     * status : 1
     * type : 开锁任务
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
        private String employee;
        private String name;
        private String starttime;
        private String endtime;
        private String locks;
        private String status;
        private String type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEmployee() {
            return employee;
        }

        public void setEmployee(String employee) {
            this.employee = employee;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public String getLocks() {
            return locks;
        }

        public void setLocks(String locks) {
            this.locks = locks;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
