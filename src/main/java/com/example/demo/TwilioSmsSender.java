package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
//import com.google.i18n.*;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.twilio.type.PhoneNumber;
//import com.google.i18n.*;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    private final TwilioConfiguration twilioConfiguration;

    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            LOGGER.info("Send sms" + smsRequest);
        } else {
            throw new IllegalArgumentException("Phone number [" + smsRequest.getPhoneNumber() + "]is not valid");
        }
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        try {
            com.google.i18n.phonenumbers.Phonenumber.PhoneNumber numberProto = phoneNumberUtil.parse(phoneNumber, "CA");
            return phoneNumberUtil.isValidNumber(numberProto);
        } catch (NumberParseException e) {
            LOGGER.error("NumberParseException was thrown: " + e.toString());
            return false;
        }
    }
}