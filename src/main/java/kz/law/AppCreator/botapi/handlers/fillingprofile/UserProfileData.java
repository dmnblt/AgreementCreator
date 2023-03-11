package kz.law.AppCreator.botapi.handlers.fillingprofile;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileData {
    String name;
    String jobTitle;
    String phoneNumber;
    String serviceName;
    String amount;
    String sideOne;
    String sideTwo;
    String signedDate;
    String target;
    String agreementType;
    String conditionalObjects;
    String specialRequirements;
    String dealAmount;
    String payment;
    String iinBin;
    String address;
    String jskBank;
    String additionalInfo;

}
