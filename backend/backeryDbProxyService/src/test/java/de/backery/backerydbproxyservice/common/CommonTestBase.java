package de.backery.backerydbproxyservice.common;

import de.backery.backerydbproxyservice.constant.Constants;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class CommonTestBase {
    @LocalServerPort
    protected int port;

    protected String getUrl() {
        return UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host("localhost")
                .path(Constants.TEST_BASE_PATH)
                .port(port)
                .toUriString();
    }
}
