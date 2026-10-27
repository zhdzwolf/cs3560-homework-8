package BridgeFiles;

public class NotificationTypes {

    public interface NotificationChannel {
        void sendNotification(String message);
    }

    public static class EmailChannel implements NotificationChannel {
        @Override
        public void sendNotification(String message) {
            System.out.println("Email notification:  " + message);
        }
    }

    public static class SMSChannel implements NotificationChannel {
        @Override
        public void sendNotification(String message) {
            System.out.println("SMS notification:  " + message);
        }
    }

    public static class PushChannel implements NotificationChannel {
        @Override
        public void sendNotification(String message) {
            System.out.println("Push notification:  " + message);
        }
    }

}
