package BridgeFiles;

public class PaymentTypes {

    public abstract static class PaymentNotification {
        protected NotificationTypes.NotificationChannel channel;

        public PaymentNotification(NotificationTypes.NotificationChannel channel) {
            this.channel = channel;
        }

        public abstract void notifyPayment();
    }

    public static class OnlinePaymentNotification extends PaymentNotification {
        private final String paymentMethod;

        public OnlinePaymentNotification(NotificationTypes.NotificationChannel channel, String paymentMethod) {
            super(channel);
            this.paymentMethod = paymentMethod;
        }

        @Override
        public void notifyPayment() {
            String message = "Online payment successful using "
                    + paymentMethod + ".";
            channel.sendNotification(message);
        }
    }

    public static class CashOnDeliveryNotification extends PaymentNotification {
        public CashOnDeliveryNotification(NotificationTypes.NotificationChannel channel) {
            super(channel);
        }

        @Override
        public void notifyPayment() {
            String message = "Order confirmed, please pay cash on delivery.";
            channel.sendNotification(message);
        }
    }

    public static class BitcoinPaymentNotification extends PaymentNotification {
        public BitcoinPaymentNotification(NotificationTypes.NotificationChannel channel) {
            super(channel);
        }

        @Override
        public void notifyPayment() {
            String message = "Bitcoin payment successful.";
            channel.sendNotification(message);
        }
    }

}
