static class Singleton {

    private static volatile Singleton singletonInstance = null;
    private String value;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singletonInstance == null) {
            synchronized(Singleton.class) {
                if (singletonInstance == null) {
                    singletonInstance = new Singleton();
                }
            }
        }
        return singletonInstance;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
