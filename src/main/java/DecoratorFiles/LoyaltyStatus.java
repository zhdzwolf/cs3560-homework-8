package DecoratorFiles;


public class LoyaltyStatus {

    public enum Level {
        REGULAR,
        SILVER,
        GOLD,
        PLATINUM
    }

    private final Level level;

    public LoyaltyStatus(Level level) {
        this.level = level;
    }

    public double applyDiscount(double total) {
        double discountRate;

        switch (level) {
            case SILVER:
                discountRate = 0.05;
                break;
            case GOLD:
                discountRate = 0.10;
                break;
            case PLATINUM:
                discountRate = 0.15;
                break;
            case REGULAR:
            default:
                discountRate = 0.0;
                break;
        }

        return total * (1.0 - discountRate);
    }

    public Level getLevel() {
        return level;
    }
}

