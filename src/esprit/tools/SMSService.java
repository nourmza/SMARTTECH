///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package esprit.tools;
//
///**
// *
// * @author mznou
// */
//public class SMSService {
//    
//    
//    // Obtenez les valeurs du SID, du token et du numéro de téléphone depuis des variables d'environnement
//    private final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
//    private final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
//    private final String FROM_PHONE_NUMBER = System.getenv("TWILIO_FROM_PHONE_NUMBER");
//
//    public void sendSMS(String recipientPhoneNumber, String messageContent) {
//        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "warn");
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        Message message = Message.creator(
//            new PhoneNumber(recipientPhoneNumber),
//            new PhoneNumber(FROM_PHONE_NUMBER),
//            messageContent
//        ).create();
//        System.out.println("Message sent: " + message.getSid());
//    }
//
//}
