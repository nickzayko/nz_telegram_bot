package com.example.nz_telegram_bot.bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public enum BotState {

    Start {
        @Override
        public void enter(BotContext context) {
            sendMessage(context, "Hello");
        }

        @Override
        public BotState nextState() {
            return EnterPhone;
        }
    },
    EnterPhone {
        @Override
        public void enter(BotContext context) {
            sendMessage(context,"Enter phone !!!");
        }

        @Override
        public BotState nextState() {
            return EnterPhone;
        }
    };



    private static BotState[] states;
    private final boolean inputNeeded;

    BotState() {
        this.inputNeeded = true;
    }

    BotState(boolean inputNeeded) {
        this.inputNeeded = inputNeeded;
    }

    public static BotState getInitialState() {
        return byId(0);
    }

    public static BotState byId(int id) {
        if (states == null) {
            states = BotState.values();
        }
        return states[id];
    }

    protected void sendMessage (BotContext context, String text) {
        SendMessage message = new SendMessage()
                .setChatId(context.getUser().getChatId())
                .setText(text);

        try {
            context.getBot().execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public boolean isInputNeeded() {
        return inputNeeded;
    }

    public void handleInput (BotContext context) {
//        do nothing by default
    }

    public abstract void enter (BotContext context);
    public abstract BotState nextState ();

}