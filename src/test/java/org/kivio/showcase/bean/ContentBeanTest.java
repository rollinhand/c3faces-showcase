package org.kivio.showcase.bean;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class ContentBeanTest {
    private ContentBean contentBean;

    @Before
    public void setUp() {
        contentBean = new ContentBean();
    }

    @Test
    public void testInit() {
        contentBean.init();
        assertFalse(contentBean.isEmpty());
        assertThat(contentBean.getSize(), is(3));
    }

    @Test
    public void testGetContent() {
        contentBean.init();
        assertNotNull(contentBean.getContent());
        assertThat(contentBean.getContent().size(), is(3));
    }

    @Test
    public void testEvalContent() {
        contentBean.init();
        ContentBean.Content content = contentBean.evalContent("/bulk_changes.xhtml");
        assertNotNull(content);
        assertThat(content.getLabel(), is("Changing chart's data"));
    }
}
