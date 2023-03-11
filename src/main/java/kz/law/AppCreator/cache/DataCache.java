package kz.law.AppCreator.cache;

import kz.law.AppCreator.botapi.BotState;
import kz.law.AppCreator.botapi.handlers.fillingprofile.UserProfileData;


public interface DataCache {
    void setUsersCurrentBotState(long userId, BotState botState);

    BotState getUsersCurrentBotState(long userId);

    UserProfileData getUserProfileData(long userId);

    void saveUserProfileData(long userId, UserProfileData userProfileData);
}
