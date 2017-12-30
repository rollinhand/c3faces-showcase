package org.kivio.showcase.bean;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Creates contentTable token from 'content.csv' and keeps track on Java and Facelet code snippets.
 *
 * @author <a href="mailto:rollin.hand@gmx.de">Björn Berg</a>
 */
@ApplicationScoped
@ManagedBean
public class ContentBean {
    private static final String CONTENT_FILE = "content.csv";
    private Map<String, Content> contentTable = new LinkedHashMap<>();
    private Logger log = LoggerFactory.getLogger(ContentBean.class);

    static Pattern pattern = Pattern.compile("/(?<key>.*)\\.xhtml");

    @PostConstruct
    protected void init() {
        try {
            log.error("loading tokens from {}", CONTENT_FILE);
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(CONTENT_FILE).getFile());
            Reader in = new FileReader(file);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(Header.class)
                    .withFirstRecordAsHeader().parse(in);
            for (CSVRecord record : records) {
                log.debug("creating new record");
                buildContent(record);
            }
            log.info("content has {} tokens", getSize());
        } catch (IOException e) {
            log.error("initializing content bean failed", e);
        }
    }

    protected void buildContent(CSVRecord record) {
        Content c = new Content(record.get(Header.Label),
                                record.get(Header.Outcome),
                                record.get(Header.JavaCode),
                                record.get(Header.FaceletCode));
        contentTable.put(c.getOutcome(), c);
    }
    public Content evalContent(String viewId) {
        // viewId ist something like "/area.txt"
        Matcher m = pattern.matcher(viewId);

        if (m.matches()) {
            String key = m.group("key");
            log.debug("View with key '{}' found", key);
            return contentTable.get(key);
        }

        return null;
    }

    public List<Content> getContent() {
        log.info("calling content...");
        return Collections.unmodifiableList(new ArrayList<>(contentTable.values()));
    }

    public int getSize() {
        return contentTable.size();
    }

    public boolean isEmpty() {
        return contentTable.isEmpty();
    }

    public boolean isLiveDemoEnabled(String viewId) {
        log.trace("View ID is '{}'", viewId);
        Content content = evalContent(viewId);
        return content == null ? false : content.hasCodeSnippet();
    }

    // ------------------------------------------------------------------------
    //  inner content class for getting tokens
    public final static class Content {
        private String label;
        private String outcome;
        private String[] javaCodeNames;
        private String faceletCodeName;

        // initial read code snippets are cached for faster access
        private Map<String,String> codeCache = new HashMap<>();

        public Content(String label, String outcome, String javaCodeName, String faceletCodeName) {
            this.label = label;
            this.outcome = outcome;

            if (hasMultipleClasses(javaCodeName)) {
                System.out.println("adding multiple codes");
                this.javaCodeNames = javaCodeName.split(";");
            } else {
                System.out.println("adding Java Code: " + javaCodeName);
                this.javaCodeNames = new String[] { javaCodeName };
            }

            this.faceletCodeName = faceletCodeName;
        }

        protected boolean hasMultipleClasses(String javaCodeName) {
            if (StringUtils.isNotEmpty(javaCodeName)) {
                return javaCodeName.contains(";");
            }
            return false;
        }

        public String getLabel() {
            return label;
        }

        public String getOutcome() {
            return outcome;
        }

        public boolean isOutcomeEnabled() {
            return StringUtils.isNotEmpty(outcome) ? outcome.length() > 2 : false;
        }

        public List<Code> getJavaCode() {
            List<Code> codeList = new ArrayList<>();

            for (String snippetName : javaCodeNames) {
                codeList.add(
                        new Code(snippetName,
                                 getFromCache(String.format("javaCode/%s", snippetName))));
            }
            return codeList;
        }

        public String getFaceletCode() {
            String code = getFromCache(String.format("faceletCode/%s", faceletCodeName));
            return code;
            //return StringEscapeUtils.escapeHtml4(code);
        }

        public boolean isFaceletCodeExists() {
            return StringUtils.isNotEmpty(faceletCodeName);
        }

        public boolean isJavaCodeExists() {
            if (javaCodeNames.length > 0) {
                return StringUtils.isNotEmpty(javaCodeNames[0]);
            }
            return false;
        }

        protected boolean hasCodeSnippet() {
            return isFaceletCodeExists() || isJavaCodeExists();
        }

        private boolean isCached(String snippet) {
            return codeCache.containsKey(snippet);
        }

        private String getFromCache(String snippet) {
            if (!isCached(snippet)) {
                try {
                    String code = IOUtils.resourceToString(snippet, null, getClass().getClassLoader());
                    codeCache.put(snippet, code.trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            return codeCache.get(snippet);
        }
    }

    public static class Code {
        private String name;
        private String snippet;

        public Code(String name, String snippet) {
            this.name = name;
            this.snippet = snippet;
        }

        public String getName() {
            return name;
        }

        public String getSnippet() {
            return snippet;
        }
    }

    // ------------------------------------------------------------------------
    //  CSV header definition
    public enum Header {
        Label, Outcome, FaceletCode, JavaCode;
    }
}
