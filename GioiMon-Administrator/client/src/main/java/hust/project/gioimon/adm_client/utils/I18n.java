package hust.project.gioimon.adm_client.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class I18n {
    private static ResourceBundleMessageSource messageSource;

    @Autowired
    public I18n(ResourceBundleMessageSource messageSource) {
        I18n.messageSource = messageSource;
    }

    public static String getMessage(String msgCode) {
        Locale locale = LocaleContextHolder.getLocale();
        if (locale.getLanguage() == null || locale.getLanguage().isEmpty()) {
            locale = new Locale("vi");
        }
        return messageSource.getMessage(msgCode, null, locale);
    }

    public static String getMessage(String msgCode, Object... arg) {
        Locale locale = LocaleContextHolder.getLocale();
        if (locale.getLanguage() == null || locale.getLanguage().isEmpty()) {
            locale = new Locale("vi");
        }
        return String.format(messageSource.getMessage(msgCode,null, locale), arg);
    }
}
