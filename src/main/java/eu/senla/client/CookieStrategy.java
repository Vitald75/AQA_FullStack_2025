package eu.senla.client;

public class CookieStrategy implements LoginStrategy {
    private String url;
    private String cookies;

    public CookieStrategy(String url, String cookies) {
        this.url = url;
        this.cookies = cookies;
    }

    @Override
    public void accessPage() throws Exception {
        // Example: Using HttpURLConnection with cookies
        java.net.URL loginUrl = new java.net.URL(url);
        java.net.HttpURLConnection connection = (java.net.HttpURLConnection) loginUrl.openConnection();

        // Set cookies in header
        connection.setRequestProperty("Cookie", cookies);
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Read response
        try (java.io.BufferedReader in = new java.io.BufferedReader(
                new java.io.InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            System.out.println("Page Content: " + response.toString());
        }
    }




}
