package roomate.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "roomate.repository")
public class MongoConfiguration {

    /*
        docker run --name mongodb -d mongo:3.4.2 --auth
        docker exec -it mongodb mongo admin
        db.createUser({ user: 'user', pwd: 'password', roles: [ { role: "userAdminAnyDatabase", db: "admin" } ] });
    */

    private final MongoDbFactory mongo;

    public MongoConfiguration(MongoDbFactory mongo) {
        this.mongo = mongo;
    }

}
