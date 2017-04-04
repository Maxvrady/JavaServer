package pageGen;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class PageGenerator {

    private static final String HTML_DIR = "templates";

    private static PageGenerator pageGenerator;
    private final Configuration conf;

    public static PageGenerator inst() {
        if (pageGenerator == null)
            pageGenerator = new PageGenerator();
        return pageGenerator;
    }

    public String getPage(String filename, Map<String, Object> var) {
        Writer string = new StringWriter();
        try {
            Template template = conf.getTemplate(HTML_DIR + File.separator + filename);
            template.process(var, string);
        } catch (IOException | TemplateException e) {
            e.getStackTrace();
        }
        return string.toString();
    }

    private PageGenerator() {
        conf = new Configuration();
    }
}
