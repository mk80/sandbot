/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compscipunk.discord.sandbotmaven;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.naming.spi.DirStateFactory.Result;

/**
 *
 * @author michael
 */
public class ShortUrl {
    
    public static final String GOOGL_URL = "https://www.googleapis.com/urlshortener/v1/url";
    
    public static void shorten(String longUrl) throws IOException, GeneralSecurityException {
        /*
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();

        HttpHeaders headers = new HttpHeaders();
        JsonObjectParser parser = new JsonObjectParser(new JacksonFactory());
        GenericUrl url = new GenericUrl("https://www.googleapis.com/urlshortener/v1/url");

        Map<String, String> json = new HashMap<>();
        json.put("longUrl", longUrl);

        final HttpContent content = new JsonHttpContent(new JacksonFactory(), json);

        HttpRequest request = httpTransport.createRequestFactory().buildPostRequest(url, content);

        try {

            HttpResponse response = request.execute();
            Result result = response.parseAs(Result.class);
            System.out.println(result.shortUrl);
        } catch (IOException e) {
        }
*/
    }
}
