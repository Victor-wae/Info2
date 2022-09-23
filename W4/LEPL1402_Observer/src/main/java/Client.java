public class Client extends Observer {
    private String news;
    private int zone;
    public Client(int zone){
        this.zone = zone;
        this.news = "";
    }
    @Override
    public void update(Object o) {
        news = o.toString();
    }

    @Override
    public int getZone() {
        return this.zone;
    }

    @Override
    public String getNews() {

        return this.news;
    }
}
