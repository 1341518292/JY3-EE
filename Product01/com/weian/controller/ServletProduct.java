package com.weian.controller;

import com.alibaba.fastjson.JSONArray;
import com.weian.Entity.Product;
import com.weian.dao.ProductDao;
import com.weian.dao.ProductDaoImpl;
import com.weian.utils.MethodUtilDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 商品的servlet
 * @author weian
 * @since 2019-05-23
 */
@WebServlet(name = "ServletProduct",urlPatterns = "*.wo")
public class ServletProduct extends HttpServlet {

    //声明Dao引用
    private ProductDao pd;
    //声明方法工具引用
    private MethodUtilDemo mu;

    @Override
    public void init() throws ServletException {
        //初始化
        pd = new ProductDaoImpl();
        mu = MethodUtilDemo.getUtil();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String requestURI = request.getRequestURI();
        Method methodUtil = mu.getMethodUtil(requestURI);
        if(null !=methodUtil){
            try {
                methodUtil.invoke(this,request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    //查询所有商品的方法
    void selectAllPro(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        List<Product> products = pd.selectAllPro();
        String s = JSONArray.toJSONString(products);
        JSONArray objects = JSONArray.parseArray(s);
        System.out.println("查询成功");
        response.getWriter().print(objects);

    }


}
