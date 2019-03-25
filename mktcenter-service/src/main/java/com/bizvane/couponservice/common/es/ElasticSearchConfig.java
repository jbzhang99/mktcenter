//package com.bizvane.members.service.config;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.Map;
//
//import javax.annotation.PostConstruct;
//
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
//import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//
//import com.google.common.collect.Maps;
//
///**
// * Created by Administrator on 2018\8\16 0016.
// */
//@Configuration
//public class ElasticSearchConfig {
//
//  static final String COLON = ":";
//  static final String COMMA = ",";
//
//    /**
//     * 防止netty的bug
//     * java.lang.IllegalStateException: availableProcessors is already set to [4], rejecting [4]
//     */
//    @PostConstruct
//    void init() {
//        System.setProperty("es.set.netty.runtime.available.processors", "false");
//    }
//
//    @Bean
//    public TransportClient transportClient(ElasticsearchProperties properties) throws UnknownHostException {
//        TransportClient client = new PreBuiltXPackTransportClient(buidSettings(properties));
//        for (String clusterNode : properties.getClusterNodes().split(COMMA)) {
//            String hostName = clusterNode.split(COLON)[0];
//            String port = clusterNode.split(COLON)[1];
//            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(hostName), Integer.valueOf(port)));
//        }
//        return client;
//    }
//
//    private Settings buidSettings(ElasticsearchProperties properties){
//        Map<String, String> settings = Maps.newHashMap();
//        settings.put("cluster.name", properties.getClusterName());
//        settings.putAll(properties.getProperties());
//        return Settings.builder().put(settings).build();
//    }
//
//    @Bean
//    public ElasticsearchTemplate elasticsearchTemplate(Client client) {
//        return new ElasticsearchTemplate(client);
//    }
//
//}

package com.bizvane.couponservice.common.es;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2018\8\16 0016.
 */
@Configuration
public class ElasticSearchConfig {

    /**
     * 防止netty的bug
     * java.lang.IllegalStateException: availableProcessors is already set to [4], rejecting [4]
     */
    @PostConstruct
    void init() {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }

}