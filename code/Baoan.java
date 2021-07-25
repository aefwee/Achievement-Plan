package com2;
public class Baoan {
    //工号
    private String sid;
    //姓名
    private String name;
    //年龄
    private String age;
    //性别
    private String sex;
    //日期
    private String data;
    public Baoan() {
    }
    public Baoan(String sid,String name,String age,String sex,String data){
        this.sid=sid;
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.data=data;
    }
    public String getSid(){
        return sid;
    }
    public void setSid(String sid){
        this.sid=sid;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getAge(){
        return age;
    }
    public void setAge(String age){
        this.age=age;
    }
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex=sex;
    }
    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data=data;
    }
}
