/** 
 * Project Name:Spring-Boot-MongoDB 
 * File Name:TestMongoConfig.java 
 * Package Name:com.rich.spring 
 * Date:2016年1月14日上午2:46:22 
 * 
*/  
  
package com.rich.springboot;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClientOptions;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;

/** 
 * ClassName:EmbedMongoDBConfig <br/> 
 * Date:     2015年10月1日 下午5:40:54 <br/> 
 * @author   rich 
 * @version   
 * @since    
 * @see       
 */
@Configuration
public class EmbedMongoDBConfig {

    @Autowired
    private MongoProperties properties;

    @Autowired(required = false)
    private MongoClientOptions options;

    @Bean(destroyMethod = "close")
    public Mongo mongo(MongodProcess mongodProcess) throws IOException {
        Net net = mongodProcess.getConfig().net();
        properties.setHost(net.getServerAddress().getHostName());
        properties.setPort(net.getPort());
        return properties.createMongoClient(this.options);
    }

    @Bean(destroyMethod = "stop")
    public MongodProcess mongodProcess(MongodExecutable mongodExecutable) throws IOException {
        return mongodExecutable.start();
    }

    @Bean(destroyMethod = "stop")
    public MongodExecutable mongodExecutable(MongodStarter mongodStarter, IMongodConfig iMongodConfig) throws IOException {
        return mongodStarter.prepare(iMongodConfig);
    }

    @Bean
    public IMongodConfig mongodConfig() throws IOException {
        return new MongodConfigBuilder().version(Version.Main.PRODUCTION).build();
    }

    @Bean
    public MongodStarter mongodStarter() {
        return MongodStarter.getDefaultInstance();
    }

}
  