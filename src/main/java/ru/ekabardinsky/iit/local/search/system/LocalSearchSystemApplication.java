/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.ekabardinsky.iit.local.search.system;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.tartarus.snowball.SnowballStemmer;
import org.tartarus.snowball.ext.englishStemmer;
import ru.ekabardinsky.iit.local.search.system.indexer.Indexer;
import ru.ekabardinsky.iit.local.search.system.parser.Parser;

import java.util.ArrayList;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class LocalSearchSystemApplication extends SpringBootServletInitializer {

    @Bean
    public Parser parser() {
        return new Parser(new ArrayList<>());//TODO add bad words
    }

    @Bean
    public SnowballStemmer stemmer() {
        return new englishStemmer();
    }

    @Bean
    public Indexer indexer() {
        return new Indexer();
    }

    @Bean
    public MongoClient client() {
        return new MongoClient();
    }

    @Bean
    public Datastore datastore(MongoClient client) {
        return new Morphia().createDatastore(client, "local");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LocalSearchSystemApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(LocalSearchSystemApplication.class, args);
    }

}
