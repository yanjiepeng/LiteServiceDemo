package com.jp.tazan.liteservicedemo.entity;

/**
 * Created by Administrator on 2016-09-07.
 * 登录返回信息实体类
 */


public class LoginResponse {

    /**
     * code : 0
     * info :
     * data : {"token":"6c2327497c164cd7b8fbc50cc5709050","number":"001","role":"代维","department":"代维一部","area":"珠海","isadmin":"1"}
     */

    private String code;
    private String info;
    /**
     * token : 6c2327497c164cd7b8fbc50cc5709050
     * number : 001
     * role : 代维
     * department : 代维一部
     * area : 珠海
     * isadmin : 1
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
        private String token;
        private String number;
        private String role;
        private String department;
        private String area;
        private String isadmin;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getIsadmin() {
            return isadmin;
        }

        public void setIsadmin(String isadmin) {
            this.isadmin = isadmin;
        }
    }
}
