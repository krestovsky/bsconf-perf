package krestovsky.test;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import krestovsky.test.db.UserDao;
import krestovsky.test.resources.UserResource;
import org.skife.jdbi.v2.DBI;

/**
 * @author maxim.krestovsky@gmail.com on 7/25/17.
 */
public class PerfApp extends Application<PerfConf> {

    public static void main(String[] args) throws Exception {
        new PerfApp().run(args);
    }

    @Override
    public String getName() {
        return "perf-app";
    }

    @Override
    public void initialize(Bootstrap<PerfConf> bootstrap) {
        bootstrap.addBundle(new DBIExceptionsBundle());
    }

    @Override
    public void run(PerfConf configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDatabase(), "postgresql");
        environment.jersey().register(new UserResource(jdbi.onDemand(UserDao.class)));
    }
}