package krestovsky.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author maxim.krestovsky@gmail.com on 7/25/17.
 */
public class PerfConf extends Configuration {

    @Valid
    @NotNull
    @JsonProperty
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDatabase() {
        return database;
    }

}