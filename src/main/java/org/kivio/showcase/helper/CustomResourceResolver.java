package org.kivio.showcase.helper;

import java.net.MalformedURLException;
import java.net.URL;
import javax.faces.view.facelets.ResourceResolver;

/**
 *
 * @author Martin Linha
 */
@SuppressWarnings("deprecation")
//@FaceletsResourceResolver
public class CustomResourceResolver extends ResourceResolver {

    private ResourceResolver resourceResolver;

    public CustomResourceResolver() {
    }

    public CustomResourceResolver(ResourceResolver resourceResolver) {
        this.resourceResolver = resourceResolver;
    }

    @Override
    public URL resolveUrl(String path) {

        try {
            return new URL("file", "",
                    "/Users/martinlinha/Projects/c3faces/showcase/src/main/webapp" + path);
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
