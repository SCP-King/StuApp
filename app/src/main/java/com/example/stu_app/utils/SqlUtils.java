package com.example.stu_app.utils;

import android.annotation.SuppressLint;

import com.example.stu_app.pojo.Days;
import com.example.stu_app.pojo.Stu;
import com.example.stu_app.pojo.Summary;
import com.example.stu_app.pojo.Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@SuppressLint("SuspiciousIndentation")
public class SqlUtils {
    private static String driver;
    private static String url;
    private static  String username;
    private static String password;
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static  int row;
    private static List<Summary> summaries=null;
    private static Days days=null;
    private static Stu stu=null;
    private static Teacher teacher=null;
    public static Boolean addstu(Stu stu){
        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    driver="com.mysql.jdbc.Driver";
                    url="jdbc:mysql://192.168.15.1:3307/school";
                    username="bill";
                    password="123456";
                   Class.forName(driver);
                   connection= DriverManager.getConnection(url,username,password);
                   preparedStatement=connection.prepareStatement("insert ignore into stu values(?,?,?,?,?) ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                   preparedStatement.setInt(1,stu.getStuid());
                   preparedStatement.setString(2,stu.getStuname());
                   preparedStatement.setString(3,stu.getStuphone());
                   preparedStatement.setString(4,stu.getStuclass());
                   preparedStatement.setInt(5, stu.getStupassword());
                   row=preparedStatement.executeUpdate();
                   preparedStatement.close();
                   connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return row>0;
    }
    public static Boolean adddays(Days days){
       Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    driver="com.mysql.jdbc.Driver";
                    url="jdbc:mysql://192.168.15.1:3307/school";
                    username="bill";
                    password="123456";
                    Class.forName(driver);
                    connection= DriverManager.getConnection(url,username,password);
                    preparedStatement=connection.prepareStatement("insert ignore into days values(?,?,?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    preparedStatement.setInt(1,days.getStuid());
                    preparedStatement.setInt(2,days.getStudays());
                    preparedStatement.setInt(3,days.getStudays());
                    row=preparedStatement.executeUpdate();
                    preparedStatement.close();
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
       thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return row>0;
    }
    public static Boolean addsummary(Summary summary){
            Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    driver="com.mysql.jdbc.Driver";
                    url="jdbc:mysql://192.168.15.1:3307/school";
                    username="bill";
                    password="123456";
                    Class.forName(driver);
                    connection= DriverManager.getConnection(url,username,password);
                    preparedStatement=connection.prepareStatement("insert  into summary values(?,?,?,?) ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    preparedStatement.setInt(1,summary.getStuid());
                    preparedStatement.setString(2,summary.getStukeywords());
                    preparedStatement.setString(3,summary.getStusummary());
                    preparedStatement.setString(4,summary.getStudate());
                    System.out.println(connection);
                    row=preparedStatement.executeUpdate();
                    System.out.println(row);
                    preparedStatement.close();
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
            thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return row>0;
    }
    public static List<Summary> selectsummary(int id){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    driver="com.mysql.jdbc.Driver";
                    url="jdbc:mysql://192.168.15.1:3307/school";
                    username="bill";
                    password="123456";
                    Class.forName(driver);
                    connection= DriverManager.getConnection(url,username,password);
                    preparedStatement=connection.prepareStatement("select * from summary where id=? order by `date`", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    preparedStatement.setInt(1,id);
                    ResultSet resultSet=preparedStatement.executeQuery();
                    summaries=new ArrayList<>();
                    if(resultSet!=null)
                    while (resultSet.next()){
                        summaries.add(new Summary(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
                    }
                    preparedStatement.close();
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
        while (summaries==null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return summaries;
    }
    public static Boolean updatedays(Days days){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    driver="com.mysql.jdbc.Driver";
                    url="jdbc:mysql://192.168.15.1:3307/school";
                    username="bill";
                    password="123456";
                    Class.forName(driver);
                    connection= DriverManager.getConnection(url,username,password);
                    preparedStatement=connection.prepareStatement("update days set days=?,longdays=? where id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    preparedStatement.setInt(1,days.getStudays());
                    preparedStatement.setInt(2,days.getStulongdays());
                    preparedStatement.setInt(3,days.getStuid());
                    row=preparedStatement.executeUpdate();
                    preparedStatement.close();
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return row>0;
    }
    public static Days selectdays(int id){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    driver="com.mysql.jdbc.Driver";
                    url="jdbc:mysql://192.168.15.1:3307/school";
                    username="bill";
                    password="123456";
                    Class.forName(driver);
                    connection= DriverManager.getConnection(url,username,password);
                    preparedStatement=connection.prepareStatement("select * from days where id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    preparedStatement.setInt(1,id);
                    ResultSet resultSet=preparedStatement.executeQuery();
                    if(resultSet!=null)
                    while (resultSet.next()){
                        days=new Days(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3));
                    }
                    preparedStatement.close();
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return days;
    }
    public static Boolean stulogin(int id,int pwd){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    driver="com.mysql.jdbc.Driver";
                    url="jdbc:mysql://192.168.15.1:3307/school";
                    username="bill";
                    password="123456";
                    Class.forName(driver);
                    connection= DriverManager.getConnection(url,username,password);
                    preparedStatement=connection.prepareStatement("select * from stu where id=? and password=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    preparedStatement.setInt(1,id);
                    preparedStatement.setInt(2,pwd);
                    ResultSet resultSet=preparedStatement.executeQuery();
                    if(resultSet!=null)
                    while (resultSet.next()){
                        stu=new Stu(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5));
                    }
                    preparedStatement.close();
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return stu!=null;
    }
    public static Boolean teacherlogin(int id,int pwd){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    driver="com.mysql.jdbc.Driver";
                    url="jdbc:mysql://192.168.15.1:3307/school";
                    username="bill";
                    password="123456";
                    Class.forName(driver);
                    connection= DriverManager.getConnection(url,username,password);
                    preparedStatement=connection.prepareStatement("select * from teacher where id=? and password=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    preparedStatement.setInt(1,id);
                    preparedStatement.setInt(2,pwd);
                    ResultSet resultSet=preparedStatement.executeQuery();
                    if(resultSet!=null)
                    while (resultSet.next()){
                        teacher=new Teacher(resultSet.getInt(1),resultSet.getInt(2));
                    }
                    preparedStatement.close();
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return teacher!=null;
    }
    public static Boolean addteacher(Teacher teacher){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    driver="com.mysql.jdbc.Driver";
                    url="jdbc:mysql://192.168.15.1:3307/school";
                    username="bill";
                    password="123456";
                    Class.forName(driver);
                    connection= DriverManager.getConnection(url,username,password);
                    preparedStatement=connection.prepareStatement("insert ignore into teacher values(?,?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    preparedStatement.setInt(1,teacher.getId());
                    preparedStatement.setInt(2,teacher.getPassword());
                    row=preparedStatement.executeUpdate();
                    preparedStatement.close();
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return row>0;
    }
    public static List<Summary> browsesummary(int id ,String keywords,String date){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    driver="com.mysql.jdbc.Driver";
                    url="jdbc:mysql://192.168.15.1:3307/school";
                    username="bill";
                    password="123456";
                    Class.forName(driver);
                    connection= DriverManager.getConnection(url,username,password);
                    String sql="select * from summary where 1=1";
                   if(id!=0) sql+=" and id=?";
                   if(keywords!=null&&!keywords.equals("")) sql+=" and keywords=?";
                   if(date!=null&&!date.equals("")) sql+=" and `date`=?";
                    sql+=" order by `date`";
                   int k=1;
                    preparedStatement=connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                   if(id!=0) {
                       preparedStatement.setInt(k,id);
                       k++;
                   }
                   if(keywords!=null&&!keywords.equals("")){
                       preparedStatement.setString(k,keywords);
                       k++;
                    }
                    if(date!=null&&!date.equals("")){
                        preparedStatement.setString(k,date);
                    }
                    ResultSet resultSet=preparedStatement.executeQuery();
                    summaries=new ArrayList<>();
                  if(resultSet!=null)
                   while (resultSet.next()){
                       summaries.add(new Summary(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
                   }
                    preparedStatement.close();
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return summaries;
    }
}
