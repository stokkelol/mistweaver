package com.mistweaver.checker;

import com.mistweaver.telegram.Api;
import com.pengrad.telegrambot.TelegramBot;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * The checker class.
 *
 * @package com.mistweaver.checker
 */
public class Checker {
    /**
     * The executor service.
     *
     * @var ScheduledExecutorService
     */
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

    /**
     * The API instance.
     *
     * @var Api
     */
    private final Api api;

    /**
     * The constructor.
     *
     * @return void
     */
    public Checker() {
        api = new Api(new TelegramBot(System.getenv("TELEGRAM_BOT_TOKEN")));
    }

    /**
     * Start the checker.
     *
     * @return void
     */
    public void start() {
        executorService.scheduleAtFixedRate(new Task(api), 0, 10, TimeUnit.SECONDS);
    }
}
