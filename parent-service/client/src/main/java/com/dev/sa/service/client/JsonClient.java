package com.dev.sa.service.client;




import com.dev.sa.data.response.Response;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by Anie on 12/28/2015.
 */
public class JsonClient {
    private HttpClient httpClient;
    private ObjectMapper mapper = new ObjectMapper();

    public JsonClient() {
        init();
    }

    private void init() {
        try {
            PlainConnectionSocketFactory plainConnectionSocketFactory = PlainConnectionSocketFactory.getSocketFactory();
            SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
            sslContextBuilder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContextBuilder.build(), SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            Registry<ConnectionSocketFactory> register = RegistryBuilder.<ConnectionSocketFactory>create().register("https", sslConnectionSocketFactory).register("http", plainConnectionSocketFactory).build();
            PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager(register);
            manager.setDefaultMaxPerRoute(10);
            manager.setMaxTotal(80);
            httpClient = HttpClients.custom().setConnectionManager(manager).setHostnameVerifier(SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER).setSSLSocketFactory(sslConnectionSocketFactory).build();
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        } catch (Exception e) {
            e.printStackTrace();
                    }
    }

    public Response execute(String url, Object request) throws Exception {
        final HttpPost httpPost = new HttpPost(url);
        System.out.println(mapper.writeValueAsString(request));
        final StringEntity stringEntity = new StringEntity(mapper.writeValueAsString(request));
        stringEntity.setContentType(ContentType.APPLICATION_JSON.toString());
        httpPost.setEntity(stringEntity);
        System.out.println(stringEntity.getContent().toString());
        HttpResponse httpResponse = httpClient.execute(httpPost);
        int status = httpResponse.getStatusLine().getStatusCode();
        if (status == 200)
            return mapper.readValue(httpResponse.getEntity().getContent(), Response.class);
        else
            throw new Exception("invalid response  ::::" + EntityUtils.toString(httpResponse.getEntity()));
    }

}
