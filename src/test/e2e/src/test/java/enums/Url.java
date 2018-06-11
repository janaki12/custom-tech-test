package enums;

public enum Url {
	BASEURL("http://localhost:3000");

    String url;

    Url(String url){
        this.url = url;
    }

    public String getURL() {
        return url;
    }
}