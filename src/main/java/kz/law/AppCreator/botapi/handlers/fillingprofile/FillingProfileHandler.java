package kz.law.AppCreator.botapi.handlers.fillingprofile;

import kz.law.AppCreator.botapi.BotState;
import kz.law.AppCreator.botapi.InputMessageHandler;
import kz.law.AppCreator.cache.UserDataCache;
import kz.law.AppCreator.service.CreateWordService;
import kz.law.AppCreator.service.ReplyMessagesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Component
public class FillingProfileHandler implements InputMessageHandler {
    private final UserDataCache userDataCache;
    private final ReplyMessagesService messagesService;
    private final CreateWordService createWordService;

    public FillingProfileHandler(UserDataCache userDataCache,
                                 ReplyMessagesService messagesService,
                                 CreateWordService createWordService) {
        this.userDataCache = userDataCache;
        this.messagesService = messagesService;
        this.createWordService = createWordService;
    }

    @Override
    public SendMessage handle(Message message) {
        if (userDataCache.getUsersCurrentBotState(message.getFrom().getId()).equals(BotState.FILLING_PROFILE)) {
            userDataCache.setUsersCurrentBotState(message.getFrom().getId(), BotState.ASK_FULL_NAME);
        }
        return processUsersInput(message);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.FILLING_PROFILE;
    }

    private SendMessage processUsersInput(Message inputMsg) {
        String usersAnswer = inputMsg.getText();
        long userId = inputMsg.getFrom().getId();
        long chatId = inputMsg.getChatId();

        UserProfileData profileData = userDataCache.getUserProfileData(userId);
        BotState botState = userDataCache.getUsersCurrentBotState(userId);

        SendMessage replyToUser = null;

        if (botState.equals(BotState.ASK_FULL_NAME)) {
            replyToUser = messagesService.getReplyMessage(chatId, "reply.askFullName");
            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_JOB_TITLE);
        }

        if (botState.equals(BotState.ASK_JOB_TITLE)) {
            replyToUser = messagesService.getReplyMessage(chatId, "reply.askJobTitle");
            profileData.setName(usersAnswer);
            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_PHONE_NUMBER);
        }

        if (botState.equals(BotState.ASK_PHONE_NUMBER)) {
            replyToUser = messagesService.getReplyMessage(chatId, "reply.askPhoneNumber");
            profileData.setJobTitle(usersAnswer);
            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_SERVICE_NAME);
        }

        if (botState.equals(BotState.ASK_SERVICE_NAME)) {
            replyToUser = messagesService.getReplyMessage(chatId, "reply.askServiceName");
            profileData.setPhoneNumber(usersAnswer);
            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_TARGET);
        }

        if (botState.equals(BotState.ASK_TARGET)) {
            replyToUser = messagesService.getReplyMessage(chatId, "reply.askTarget");
            profileData.setServiceName(usersAnswer);
            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_AMOUNT);
        }

        if (botState.equals(BotState.ASK_AMOUNT)) {
            replyToUser = messagesService.getReplyMessage(chatId, "reply.askAmount");
            profileData.setTarget(usersAnswer);
            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_SIDE_ONE);
        }

        if (botState.equals(BotState.ASK_SIDE_ONE)) {
            replyToUser = messagesService.getReplyMessage(chatId, "reply.askSideOne");
            profileData.setAmount(usersAnswer);
            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_SIDE_TWO);
        }

        if (botState.equals(BotState.ASK_SIDE_TWO)) {
            replyToUser = messagesService.getReplyMessage(chatId, "reply.askSideTwo");
            profileData.setSideOne(usersAnswer);
            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_SIGNED_DATE);
        }

        if (botState.equals(BotState.ASK_SIGNED_DATE)) {
            replyToUser = messagesService.getReplyMessage(chatId, "reply.askSignedDate");
            profileData.setSideTwo(usersAnswer);
            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_AGREEMENT_TYPE);
        }

        if (botState.equals(BotState.ASK_AGREEMENT_TYPE)) {
            replyToUser = messagesService.getReplyMessage(chatId, "reply.askAgreementType");
            profileData.setSignedDate(usersAnswer);
            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_CONDITIONAL_OBJECTS);
        }

        if (botState.equals(BotState.ASK_CONDITIONAL_OBJECTS)) {
            replyToUser = messagesService.getReplyMessage(chatId, "reply.askConditionalObjects");
            profileData.setAgreementType(usersAnswer);
            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_SPECIAL_REQUIREMENTS);
        }

        if (botState.equals(BotState.ASK_SPECIAL_REQUIREMENTS)) {
            replyToUser = messagesService.getReplyMessage(chatId, "reply.askSpecialRequirements");
            profileData.setConditionalObjects(usersAnswer);
            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_DEAL_AMOUNT);
        }

        if (botState.equals(BotState.ASK_DEAL_AMOUNT)) {
            replyToUser = messagesService.getReplyMessage(chatId, "reply.askDealAmount");
            profileData.setSpecialRequirements(usersAnswer);
            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_PAYMENT);
        }

        if (botState.equals(BotState.ASK_PAYMENT)) {
            replyToUser = messagesService.getReplyMessage(chatId, "reply.askPayment");
            profileData.setDealAmount(usersAnswer);
            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_IIN_BIN);
        }

        if (botState.equals(BotState.ASK_IIN_BIN)) {
            replyToUser = messagesService.getReplyMessage(chatId, "reply.askIinBin");
            profileData.setPayment(usersAnswer);
            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_ADDRESS);
        }

        if (botState.equals(BotState.ASK_ADDRESS)) {
            replyToUser = messagesService.getReplyMessage(chatId, "reply.askAddress");
            profileData.setIinBin(usersAnswer);
            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_JSK_BANK);
        }

        if (botState.equals(BotState.ASK_JSK_BANK)) {
            replyToUser = messagesService.getReplyMessage(chatId, "reply.askJskBank");
            profileData.setAddress(usersAnswer);
            userDataCache.setUsersCurrentBotState(userId, BotState.ASK_ADDITIONAL_INFO);
        }

        if (botState.equals(BotState.ASK_ADDITIONAL_INFO)) {
            replyToUser = messagesService.getReplyMessage(chatId, "reply.askAdditionalInfo");
            profileData.setJskBank(usersAnswer);
            userDataCache.setUsersCurrentBotState(userId, BotState.PROFILE_FILLED);
        }

        if (botState.equals(BotState.PROFILE_FILLED)) {
            profileData.setAdditionalInfo(usersAnswer);
            System.out.println(profileData);
            replyToUser = new SendMessage(String.valueOf(chatId),
                    "Теперь отправьте данную заявку по адресу \n" +
                    "200103064k@sdu.edu.kz \n" +
                    "Отправьте /fillIn для заполнение еще одного договора");

            Map<String, Object> params = new HashMap<>();
            params.put("fullName", profileData.getName());
            params.put("jobTitle", profileData.getJobTitle());
            params.put("phoneNumber", profileData.getPhoneNumber());
            params.put("serviceName", profileData.getServiceName());
            params.put("target", profileData.getTarget());
            params.put("amount", profileData.getAmount());
            params.put("sideOne", profileData.getSideOne());
            params.put("sideTwo", profileData.getSideTwo());
            params.put("signedDate", profileData.getSignedDate());
            params.put("agreementType", profileData.getAgreementType());
            params.put("conditionalObjects", profileData.getConditionalObjects());
            params.put("specialRequirements", profileData.getSpecialRequirements());
            params.put("dealAmount", profileData.getDealAmount());
            params.put("payment", profileData.getPayment());
            params.put("iinBin", profileData.getIinBin());
            params.put("address", profileData.getAddress());
            params.put("jskBank", profileData.getJskBank());
            params.put("additionalInfo", profileData.getAdditionalInfo());


            createWordService.createAndSendWord(params, chatId);
        }

        userDataCache.saveUserProfileData(userId, profileData);

        return replyToUser;
    }


}



