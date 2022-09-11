package moscato.admin.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * @author jsw
 * @since 2021-11-03
 * @version 1.0.0
 * @comment basic mvc interceptor config / filter patterns
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer  {

    private static final List<String> EXCLUDE_URL_PATTERNS = Arrays.asList(
            "/static"
    );


}
