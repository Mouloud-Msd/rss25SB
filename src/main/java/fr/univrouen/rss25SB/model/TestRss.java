package fr.univrouen.rss25SB.model;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestRss {
	public String loadFileXML() {
        Resource resource = new DefaultResourceLoader().getResource("classpath:xml/item.xml");

        try (InputStream inputStream = resource.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            return content.toString();

        } catch (Exception e) {
            return "Erreur lors de la lecture du fichier XML : " + e.getMessage();
        }
    }
}