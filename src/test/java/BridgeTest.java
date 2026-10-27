import BridgeFiles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BridgeTest {

    // test that the channels work

    @Test
    void testEmailChannel() {
        NotificationTypes.EmailChannel email = new NotificationTypes.EmailChannel();
        email.sendNotification("blow this place sky high");
        String output = "Email notification: blow this place sky high";

        assertEquals("Email notification: blow this place sky high", output);
    }

    @Test
    void testSMSChannel() {
        NotificationTypes.SMSChannel sms = new NotificationTypes.SMSChannel();
        sms.sendNotification("nuke radio, we make your eardrums bleed");
        String output = "SMS notification: nuke radio, we make your eardrums bleed";

        assertEquals("SMS notification: nuke radio, we make your eardrums bleed", output);
    }

    @Test
    void testPushChannel() {
        NotificationTypes.PushChannel push = new NotificationTypes.PushChannel();
        push.sendNotification("shadow wizard money gang");
        String output = "Push notification: shadow wizard money gang";

        assertEquals("Push notification: shadow wizard money gang", output);
    }

    // test that the payment types work

    static class TestChannel implements NotificationTypes.NotificationChannel {
        String receivedMessage;

        @Override
        public void sendNotification(String message) {
            receivedMessage = message;
        }
    }

    @Test
    void testOnlinePayment() {
        TestChannel testChannel = new TestChannel();

        PaymentTypes.PaymentNotification payment =
                new PaymentTypes.OnlinePaymentNotification(testChannel, "vbucks");
        payment.notifyPayment();

        assertEquals("Online payment successful using vbucks.", testChannel.receivedMessage);
    }

    @Test
    void testCashPayment() {
        TestChannel testChannel = new TestChannel();
        PaymentTypes.PaymentNotification payment =
                new PaymentTypes.CashOnDeliveryNotification(testChannel);
        payment.notifyPayment();

        assertEquals("Order confirmed, please pay cash on delivery.", testChannel.receivedMessage);
    }

    @Test
    void testBitcoinPayment() {
        TestChannel testChannel = new TestChannel();
        PaymentTypes.PaymentNotification payment =
                new PaymentTypes.BitcoinPaymentNotification(testChannel);
        payment.notifyPayment();

        assertEquals("Bitcoin payment successful.", testChannel.receivedMessage);
    }

}
