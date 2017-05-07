package roomate.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EntityScan(basePackages = "roomate.model")
@EnableMongoRepositories(basePackages = "roomate.repository")
public class MongoConfiguration {

    /*
        docker run --name mongodb -d -p 27017:27017 mongo:3.4.2
    */

}
