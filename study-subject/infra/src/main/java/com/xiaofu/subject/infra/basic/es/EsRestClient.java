package com.xiaofu.subject.infra.basic.es;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpPost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaofu
 * @date 2024/1/25 1:13
 * @des
 */

@Component
@Slf4j
public class EsRestClient {

    public static Map<String, RestHighLevelClient> clientMap = new HashMap<>();

    @Autowired
    private EsConfigProperties esConfigProperties;

    @PostConstruct
    public void initialize() {
        List<EsClusterConfig> esClusterConfigList = esConfigProperties.getEsConfigs();
        for (EsClusterConfig esClusterConfig : esClusterConfigList) {
            log.info("initialize.config.name:{},node:{}", esClusterConfig.getName(), esClusterConfig.getNodes());
            RestHighLevelClient restHighLevelClient = initRestClient(esClusterConfig);
            if (restHighLevelClient != null) {
                clientMap.put(esClusterConfig.getName(), restHighLevelClient);
            } else {
                log.error("config.name:{},node:{}.initError", esClusterConfig.getName(), esClusterConfig.getNodes());
            }

        }
    }

    private RestHighLevelClient initRestClient(EsClusterConfig esClusterConfig) {
        String[] ipPortArr = esClusterConfig.getNodes().split(",");
        List<HttpHost> httpHostList = new ArrayList<>(ipPortArr.length);
        for(String ipPort: ipPortArr) {
            String[] ipPortInfo = ipPort.split(",");
            if (ipPortInfo.length == 2) {
                HttpHost httpHost = new HttpHost(ipPortInfo[0], Integer.parseInt(ipPortInfo[1]));
                httpHostList.add(httpHost);

            }
        }
        HttpHost[] httpHosts = new HttpHost[httpHostList.size()];
        httpHostList.toArray(httpHosts);

        RestClientBuilder builder = RestClient.builder(httpHosts);
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);
        return restHighLevelClient;
    }

}
