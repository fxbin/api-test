package cn.fxbin.wiremock;


import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

/**
 * Application
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/12/4 11:42
 */
public class Application {

    /**
     * 定义mock服务的端口
     */
    private static final int PORT = 9090;

    /**
     * 定义mock服务的地址
     */
    private static final  String LOCALHOST= "localhost";

    /**
     * 定义mapping文件目录
     */
    private static final String MOCK_DIR= "mock";

    public static void main(String[] args) {
        final WireMockConfiguration config = WireMockConfiguration.wireMockConfig()
                .port(PORT)
                .usingFilesUnderClasspath(MOCK_DIR);
        final WireMockServer wireMockServer = new WireMockServer(config);
        wireMockServer.start();
        WireMock.configureFor(LOCALHOST,PORT);
    }

}
