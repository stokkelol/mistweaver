package com.mistweaver.client;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * The client class.
 *
 * @package com.mistweaver.client
 */
public class Client {
    /**
     * The HTTP OK status code.
     *
     * @var int
     */
    public final static int OK = 200;

    /**
     * Check if the given URL is alive.
     *
     * @param url
     * @return boolean
     */
    public boolean isAlive(String url) throws RuntimeException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.code() == OK;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
