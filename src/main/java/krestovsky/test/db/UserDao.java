package krestovsky.test.db;

import krestovsky.test.mapper.UserMapper;
import krestovsky.test.model.User;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * @author maxim.krestovsky@gmail.com on 7/25/17.
 */
@RegisterMapper(UserMapper.class)
public interface UserDao {

    @SqlQuery("select * from users")
    List<User> findAll();
}