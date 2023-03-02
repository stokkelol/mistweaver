package com.mistweaver.checker;

import com.mistweaver.client.Client;
import com.mistweaver.telegram.Api;

/**
 * The task class.
 *
 * @package com.mistweaver.checker
 */
public class Task implements Runnable {

    /**
     * The API instance.
     *
     * @var Api
     */
    private final Api api;

    /**
     * The constructor.
     *
     * @param api
     * @return void
     */
    public Task(Api api) {
        this.api = api;
    }

    /**
     * The run method.
     *
     * @return void
     */
    public void run() {
        String[] addr = System.getenv("ADDRESSES").split(",");
        Client client = new Client();
        for (String address : addr) {
            if (!address.startsWith("http://")) {
                address = address.replaceFirst("http://", "");
            }

            if (!address.startsWith("https://")) {
                address = "https://" + address;
            }

            try {
                if (!client.isAlive(address)) {
                    api.sendMessage("The address " + address + " is alive!");
                }
            } catch (RuntimeException e) {
                api.sendMessage("Error: " + e.getMessage());
            }
        }
    }
}
