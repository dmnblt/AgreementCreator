package kz.law.AppCreator.service;

import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.SaveFormat;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.Version;
import kz.law.AppCreator.config.BotConfig;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.Map;

import static kz.law.AppCreator.models.Template.TEMPlATE;

@Service
@RequiredArgsConstructor
public class CreateWordService {

    private final RestTemplate restTemplate;
    private final BotConfig botConfig;


    @SneakyThrows
    public void createAndSendWord(Map<String, Object> params, Long chatId){

        String templateHtml = TEMPlATE;
        if (params != null && !params.isEmpty()) {
            val version = new Version("2.3.31");
            val configuration = new Configuration(version);
            configuration.setObjectWrapper(new DefaultObjectWrapper(version));
            configuration.setDefaultEncoding("UTF-8");
            val template = new Template("template", templateHtml, configuration);
            try (StringWriter stringWriter = new StringWriter()) {
                template.process(params, stringWriter);
                templateHtml = stringWriter.toString();
            }
        }

        val doc = new Document();
        val builder = new DocumentBuilder(doc);
        builder.insertHtml(templateHtml);
        doc.save("Договор.docx", SaveFormat.DOCX);
        val file = new File("Договор.docx");
        val targetStream = new FileInputStream(file);
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        val headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        val url = "https://api.telegram.org/bot" + botConfig.getBotToken() + "/sendDocument?chat_id=" + chatId;
        map.add("document", new MultipartInputStreamFileResource(targetStream, file.getName()));
        HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
        val response = restTemplate.postForObject(url, requestEntity, String.class);
        System.out.println(response);
    }

    static class MultipartInputStreamFileResource extends InputStreamResource {

        private final String filename;

        MultipartInputStreamFileResource(InputStream inputStream, String filename) {
            super(inputStream);
            this.filename = filename;
        }

        @Override
        public String getFilename() {
            return this.filename;
        }

        @Override
        public long contentLength() {
            return -1; // we do not want to generally read the whole stream into memory ...
        }
    }
}
