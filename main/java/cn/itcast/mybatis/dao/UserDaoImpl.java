package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {


    private SqlSessionFactory sqlSessionFactory;
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
            this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("test.findByUserId",id);

        sqlSession.close();

        return user;

    }

    @Override
    public List<User> findUserByName(String username) throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> userList = sqlSession.selectList("test.findUserByName",username);

        sqlSession.close();

        return  userList;

    }

    @Override
    public void insertUser(User user) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.selectOne("test.insertUser",user);

        sqlSession.commit();

        sqlSession.close();

    }

    @Override
    public void deleteUser(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.selectOne("test.deleteUser",id);

        sqlSession.commit();

        sqlSession.close();

    }

}
