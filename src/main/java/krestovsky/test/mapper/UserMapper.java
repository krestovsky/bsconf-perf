package krestovsky.test.mapper;

import krestovsky.test.model.User;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author maxim.krestovsky@gmail.com on 7/25/17.
 */
public class UserMapper implements ResultSetMapper<User> {

    public User map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new User(
                r.getInt("id"),
                r.getString("username"),
                r.getString("email")
        );
    }

}