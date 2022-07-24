public enum ApiUrl {
    NASA_PICTURES("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-07-18&end_date=2022-07-21"),
    TECHNOLOGIES_PICTURES("http://localhost:8080/technologies");

    private final String link;

    ApiUrl(String x){
        this.link = x;
    }

    public String getLink(){
        return this.link;
    }
}
