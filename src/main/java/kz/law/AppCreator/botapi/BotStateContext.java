package kz.law.AppCreator.botapi;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BotStateContext {
    private Map<BotState, InputMessageHandler> messageHandlers = new HashMap<>();

    public BotStateContext(List<InputMessageHandler> messageHandlers) {
        messageHandlers.forEach(handler -> this.messageHandlers.put(handler.getHandlerName(), handler));
    }

    public SendMessage processInputMessage(BotState currentState, Message message) {
        InputMessageHandler currentMessageHandler = findMessageHandler(currentState);
        return currentMessageHandler.handle(message);
    }

    private InputMessageHandler findMessageHandler(BotState currentState) {
        if (isFillingProfileState(currentState)) {
            return messageHandlers.get(BotState.FILLING_PROFILE);
        }

        return messageHandlers.get(currentState);
    }

    private boolean isFillingProfileState(BotState currentState) {
        switch (currentState) {
            case ASK_FULL_NAME:
            case ASK_JOB_TITLE:
            case ASK_PHONE_NUMBER:
            case ASK_SERVICE_NAME:
            case ASK_TARGET:
            case ASK_AMOUNT:
            case ASK_SIDE_ONE:
            case ASK_SIDE_TWO:
            case ASK_SIGNED_DATE:
            case ASK_AGREEMENT_TYPE:
            case ASK_CONDITIONAL_OBJECTS:
            case ASK_SPECIAL_REQUIREMENTS:
            case ASK_DEAL_AMOUNT:
            case ASK_PAYMENT:
            case ASK_IIN_BIN:
            case ASK_ADDRESS:
            case ASK_JSK_BANK:
            case ASK_ADDITIONAL_INFO :
            case PROFILE_FILLED:
                return true;
            default:
                return false;
        }
    }


}





