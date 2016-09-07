package com.jp.tazan.liteservicedemo.entity;

import java.util.List;

/**
 * Created by Administrator on 2016-09-07.
 */
public class KeyEntity {

    /**
     * code : 0
     * info :
     * data : [{"id":"8","number":"VW001","name":"香洲1#钥匙","employee":"cody3","esn":"A4070001","remark":""},{"id":"9","number":"VW002","name":"香洲2#钥匙","employee":"cody3","esn":"A4070002","remark":""},{"id":"10","number":"XZ0001","name":"西藏钥匙1","employee":"cody3","esn":"FFFFFFFF","remark":""}]
     */

    private String code;
    private String info;
    /**
     * id : 8
     * number : VW001
     * name : 香洲1#钥匙
     * employee : cody3
     * esn : A4070001
     * remark :
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
        private String employee;
        private String esn;
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

        public String getEmployee() {
            return employee;
        }

        public void setEmployee(String employee) {
            this.employee = employee;
        }

        public String getEsn() {
            return esn;
        }

        public void setEsn(String esn) {
            this.esn = esn;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
