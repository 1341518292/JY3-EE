package com.weian.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weian.Entity.User;
import com.weian.dao.UserDao;
import com.weian.dao.UserDaoImpl;

import java.util.List;

public class JSONDemo {
    //简单对象
    private static final String JSON_str = "{\"id\":\"15\"}";
    //数组
    private static final String JSON_Array = "[{\"id\":\"20\",\"user\":\"嘻嘻\"},{\"passowrd\":\"zwa1234\",\"qqq\":\"1\"}]";
    private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";

    //复杂
    private static final String JSON_QWE = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    public static void main(String[] args) {
        //JSON格式字符串转JSONObject
//        JSONObject jsonObject = JSONObject.parseObject(JSON_str);
//        System.out.println(jsonObject);
//        String id = jsonObject.getString("id");
//        System.out.println(id);
//        System.out.println("<---------------------------------------------分隔符---------------------------------------------------------->");
//        //JSON格式数组转JSONArray
//        JSONArray objects = JSONArray.parseArray(JSON_Array);
//        System.out.println(objects);
//        System.out.println("<---------------------------------------------分隔符---------------------------------------------------------->");
//        for(int i = 0;i<objects.size();i++){
//            JSONObject jsonObject1 = objects.getJSONObject(i);
//            System.out.println(jsonObject1);
//            String id1 = jsonObject1.getString("id");
//            System.out.println(id1);
//        }
        UserDao ud = new UserDaoImpl();
        List<User> users = ud.selectAll();
        String JSONstr = JSONArray.toJSONString(users);
        System.out.println(JSONstr);
        JSONArray objects = JSONArray.parseArray(JSONstr);
        System.out.println(objects);
    }


}

