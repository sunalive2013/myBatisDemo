package cn.itcast.mybatis.first;

import cn.itcast.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MybatisFirst {

    @Test
    public void findUserById() throws IOException{
        String resouce = "sqlMapConfig.xml";
        InputStream inputStream=null;
        SqlSessionFactory sqlSessionFactory=null;
        SqlSession sqlSession=null;

        try {
            inputStream = Resources.getResourceAsStream(resouce);

            // 创建会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 通过工厂得到SqlSession
            sqlSession = sqlSessionFactory.openSession();

            User user =  sqlSession.selectOne("test.findByUserId",1);



            System.out.print(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }




    }

    @Test
    public void findUserByName() throws IOException {
        String resouce = "sqlMapConfig.xml";
        InputStream inputStream=null;
        SqlSessionFactory sqlSessionFactory=null;
        SqlSession sqlSession=null;

        try {
            inputStream = Resources.getResourceAsStream(resouce);

            // 创建会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 通过工厂得到SqlSession
            sqlSession = sqlSessionFactory.openSession();

            List<User> useruserList =  sqlSession.selectList("test.findUserByName","小明");

            for (User user : useruserList) {

                System.out.print(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void insertUser() throws IOException {
        String resouce = "sqlMapConfig.xml";
        InputStream inputStream=null;
        SqlSessionFactory sqlSessionFactory=null;
        SqlSession sqlSession=null;

        try {
            inputStream = Resources.getResourceAsStream(resouce);

            // 创建会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 通过工厂得到SqlSession
            sqlSession = sqlSessionFactory.openSession();

            User user = new User();
            user.setUsername("赵丽洁");
            user.setBirthday(new Date());
            user.setSex("0");
            user.setAddress("西安市高新区");

            sqlSession.insert("test.insertUser",user);

            sqlSession.commit();

//            获取表主键ID
            System.out.println(user.getId());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteUser() throws IOException {
        String resouce = "sqlMapConfig.xml";
        InputStream inputStream=null;
        SqlSessionFactory sqlSessionFactory=null;
        SqlSession sqlSession=null;

        try {
            inputStream = Resources.getResourceAsStream(resouce);

            // 创建会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 通过工厂得到SqlSession
            sqlSession = sqlSessionFactory.openSession();

            sqlSession.selectOne("test.deleteUser",28);

            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void updateUser() throws IOException {
        String resouce = "sqlMapConfig.xml";
        InputStream inputStream=null;
        SqlSessionFactory sqlSessionFactory=null;
        SqlSession sqlSession=null;

        try {
            inputStream = Resources.getResourceAsStream(resouce);

            // 创建会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 通过工厂得到SqlSession
            sqlSession = sqlSessionFactory.openSession();

            User user = new User();
            user.setId(31);
            user.setUsername("赵丽洁");
            user.setSex("0");
            user.setAddress("陕西西安");
            DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            Date date= format1.parse("1988-12-21");
            user.setBirthday(date);

            sqlSession.selectOne("test.updateUser",user);

            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
