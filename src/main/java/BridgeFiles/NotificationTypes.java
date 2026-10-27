package BridgeFiles;

public class NotificationTypes {

    interface NotificationChannel {
        void sendNotification(String message);
    }

    class EmailChannel implements NotificationChannel {
        @Override
        public void sendNotification(String message) {
            System.out.println("Email notification:  " + message);
        }
    }

    class SMSChannel implements NotificationChannel {
        @Override
        public void sendNotification(String message) {
            System.out.println("SMS notification:  " + message);
        }
    }

    class PushChannel implements NotificationChannel {
        @Override
        public void sendNotification(String message) {
            System.out.println("Push notification:  " + message);
        }
    }

}
