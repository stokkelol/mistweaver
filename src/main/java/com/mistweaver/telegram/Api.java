package com.mistweaver.telegram;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;

/**
 * The API class.
 *
 * @package com.mistweaver.telegram
 */
public class Api {
    /**
     * The bot instance.
     *
     * @var TelegramBot
     */
    private final TelegramBot bot;

    /**
     * The constructor.
     *
     * @param bot
     * @return void
     */
    public Api(TelegramBot bot) {
        this.bot = bot;
    }

    /**
     * Send a message.
     *
     * @param message
     * @return void
     */
    public void sendMessage(String message) {
        bot.execute(new SendMessage(System.getenv("TELEGRAM_CHAT_ID"), message));
    }
}
