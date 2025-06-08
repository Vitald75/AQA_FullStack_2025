package eu.senla.client;

public class LoginPageStrategy implements LoginStrategy {
    private String loginUrl;
    private String username;
    private String password;

    public LoginPageStrategy(String loginUrl, String username, String password) {
        this.loginUrl = loginUrl;
        this.username = username;
        this.password = password;
    }

    @Override
    public void accessPage() throws Exception {
        // Example: Perform login via POST request
        java.net.URL url = new java.net.URL(loginUrl);
        java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String postData = "username=" + java.net.URLEncoder.encode(username, "UTF-8")
                + "&password=" + java.net.URLEncoder.encode(password, "UTF-8");

        try (java.io.OutputStream os = connection.getOutputStream()) {
            os.write(postData.getBytes());
        }

        int responseCode = connection.getResponseCode();
        System.out.println("Login Response Code: " + responseCode);

        // Read response
        try (java.io.BufferedReader in = new java.io.BufferedReader(
                new java.io.InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            System.out.println("Logged In Page Content: " + response.toString());
        }
    }
}