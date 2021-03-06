package org.wso2.extension.siddhi.store.elasticsearch.test.utils;

import org.apache.log4j.Logger;

import java.net.URI;
import java.net.URISyntaxException;

public class ElasticsearchUtils {
    private static final Logger log = Logger.getLogger(ElasticsearchUtils.class);

    /**
     * Utility for get Docker running host
     *
     * @return docker host
     * @throws URISyntaxException if docker Host url is malformed this will throw
     */
    public static String getIpAddressOfContainer() {
        String ip = System.getenv("DOCKER_HOST_IP");
        String dockerHost = System.getenv("DOCKER_HOST");
        if (dockerHost != null && dockerHost.isEmpty()) {
            try {
                URI uri = new URI(dockerHost);
                ip = uri.getHost();
            } catch (URISyntaxException e) {
                log.error("Error while getting the docker Host url." + e.getMessage(), e);
            }
        }
        return ip;
    }

    public static String getContainerPort() {
        String port = System.getenv("PORT");
        return port;
    }
}
