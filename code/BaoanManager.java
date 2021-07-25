package com2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BaoanManager {
    public static void main(String[] args){
        ArrayList<Baoan> array=new ArrayList<Baoan>();
        while(true){
              System.out.println("-----欢迎来到保安室排班系统------");
            System.out.println("当前总员工数："+array.size());
            if(array.size()==0) {
                System.out.println("今日值班员工：无");

            }
            if(array.size()!=0){
                getWeek(array);
            }
            System.out.println("员工列表：");
            find(array);
            System.out.println("本周值班表：");
            System.out.println("周一\t\t周二\t\t周三\t\t周四\t\t周五\t\t周六\t\t周日");
            zhiban(array);
              System.out.println("1 添加员工");
              System.out.println("2 删除员工");
              System.out.println("3 修改员工");
              System.out.println("4 退出");
              System.out.println("请输入你的选择：");
              Scanner sc=new Scanner(System.in);
              String line=sc.nextLine();
              switch(line) {
                  case "1":
                      add(array);
                      break;
                  case "2":
                      delete(array);
                      break;
                  case "3":
                      update(array);
                      break;
                  case "4":
                      System.out.println("退出成功");
                      System.exit(0);
              }
        }
    }
    public static void add(ArrayList<Baoan> array){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入员工工号：");
        String sid=sc.nextLine();
        System.out.println("请输入员工姓名：");
        String name=sc.nextLine();
        System.out.println("请输入员工年龄：");
        String age=sc.nextLine();
        System.out.println("请输入员工性别：");
        String sex=sc.nextLine();
        System.out.println("请输入员工周几值班：");
        String data=sc.nextLine();
        Baoan s=new Baoan();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setSex(sex);
        s.setData(data);
        array.add(s);
        System.out.println("添加员工成功");
    }
    public static void find(ArrayList<Baoan> array){
        if(array.size()==0){
            System.out.println("无信息，请添加信息后再查询");
            return;
        }
        System.out.println("工号\t\t姓名\t\t年龄\t\t性别\t\t值班");
        for(int i=0;i<array.size();i++){
            Baoan s=array.get(i);
            System.out.println(s.getSid()+"\t"+s.getName()+"\t"+s.getAge()+"岁\t"+s.getSex()+"\t\t周"+s.getData());
        }
    }
    public static void delete(ArrayList<Baoan> array){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你要删除的员工的工号：");
        String sid=sc.nextLine();
        int a=-1;
        for(int i=0;i< array.size();i++){
            Baoan s=array.get(i);
            if(s.getSid().equals(sid)){
                a=i;
                break;
            }
        }
        if(a==-1){
            System.out.println("该信息不存在，请重新输入");
        }else {
            array.remove(a);
            System.out.println("删除成功");
        }
    }
    public static void update(ArrayList<Baoan> array){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你要修改的员工的工号：");
        String sid =sc.nextLine();
        System.out.println("请输入员工新姓名：");
        String name =sc.nextLine();
        System.out.println("请输入员工新年龄：");
        String age =sc.nextLine();
        System.out.println("请输入员工新性别：");
        String sex =sc.nextLine();
        System.out.println("请输入员工新值班日期：(输入周'几')");
        String data =sc.nextLine();
        Baoan s=new Baoan();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setSex(sex);
        s.setData(data);
        for(int i=0;i< array.size();i++){
            Baoan baoan=array.get(i);
            if(baoan.getSid().equals(sid)){
                array.set(i,s);
                break;
            }
        }
        System.out.println("修改成功");
    }

    public static void zhiban(ArrayList<Baoan> array){
        String [] a={"一","二","三","四","五","六","日"};
        for(int i=0;i<7;i++){
            int b=-1;
            for(int j=0;j< array.size();j++){
                Baoan baoan= array.get(j);
                if(baoan.getData().equals(a[i])){
                    b=j;
                    System.out.print(baoan.getName()+"\t");
                }
            }
            if(b==-1){
                System.out.print("无\t\t");
            }
        }
        System.out.println();

    }
    public static void getWeek(ArrayList<Baoan> array) {
        String week = "";
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        int weekday = c.get(Calendar.DAY_OF_WEEK);
        if (weekday == 1) {
            week = "日";
        } else if (weekday == 2) {
            week = "一";
        } else if (weekday == 3) {
            week = "二";
        } else if (weekday == 4) {
            week = "三";
        } else if (weekday == 5) {
            week = "四";
        } else if (weekday == 6) {
            week = "五";
        } else if (weekday == 7) {
            week = "六";
        }
        int a=-1;
        for (int i = 0; i < array.size(); i++) {
            Baoan baoan = array.get(i);
            if (baoan.getData().equals(week)) {
                System.out.println("日期："+"周"+week+"("+c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DAY_OF_MONTH)+")"+"\t今日值班员工：" + baoan.getName()+"\t工号："+baoan.getSid());
                a=i;
            }
        }
        if(a==-1) {
            System.out.println("日期："+"周"+week+"("+c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DAY_OF_MONTH)+")"+"\t今日值班员工：无");
        }
    }

}
