import BridgeFiles.*;

public class BridgeDriver {
    public static void main(String[] args) {

        System.out.println("Part 1:");

        // online + email
        PaymentTypes.PaymentNotification onlineEmail =
                new PaymentTypes.OnlinePaymentNotification(
                        new NotificationTypes.EmailChannel(), "Credit Card"
                );
        onlineEmail.notifyPayment();

        // online + sms
        PaymentTypes.PaymentNotification onlineSMS =
                new PaymentTypes.OnlinePaymentNotification(
                        new NotificationTypes.SMSChannel(), "PayPal"
                );
        onlineSMS.notifyPayment();

        // cash + email
        PaymentTypes.PaymentNotification cashEmail =
                new PaymentTypes.CashOnDeliveryNotification(
                        new NotificationTypes.EmailChannel()
                );
        cashEmail.notifyPayment();

        // cash + sms
        PaymentTypes.PaymentNotification cashSMS =
                new PaymentTypes.CashOnDeliveryNotification(
                        new NotificationTypes.SMSChannel()
                );
        cashSMS.notifyPayment();

        System.out.println("Part 2:");

        // bitcoin + email
        PaymentTypes.PaymentNotification bitcoinEmail =
                new PaymentTypes.BitcoinPaymentNotification(
                        new NotificationTypes.EmailChannel()
                );
        bitcoinEmail.notifyPayment();

        // bitcoin + sms
        PaymentTypes.PaymentNotification bitcoinSMS =
                new PaymentTypes.BitcoinPaymentNotification(
                        new NotificationTypes.SMSChannel()
                );
        bitcoinSMS.notifyPayment();

    }
}
