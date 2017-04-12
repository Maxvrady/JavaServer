package PageGenerator;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class PageGenerator {

    private final String HTML_DIR = "templates";

    private Configuration configuration = new Configuration();

    public String getPage(String filename, Map<String, Object> data) {
        Writer writer = new StringWriter();
        try {
            Template template = configuration.getTemplate(HTML_DIR + File.separator + filename);
            template.process(data, writer);
        } catch (IOException | TemplateException e) {
            e.getStackTrace();
        }
        return writer.toString();
    }
}
