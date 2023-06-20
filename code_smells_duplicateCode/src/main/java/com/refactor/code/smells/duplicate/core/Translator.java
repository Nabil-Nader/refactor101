package com.refactor.code.smells.duplicate.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@Slf4j
public class Translator {

    private static ResourceBundleMessageSource messageSource;

    @Autowired
    Translator(ResourceBundleMessageSource messageSource) {
        Translator.messageSource = messageSource;
    }

    public static String getMessage(String msg, Long langId) {
        Locale locale;

        if (langId == null) {
            locale = LocaleContextHolder.getLocale();
        } else {
            locale = new Locale(getLangCode(langId));
        }

        return messageSource.getMessage(msg, null, locale);
    }

    private static String getLangCode(Long langId) {
        if (langId == 1L)
            return "en";
        else return "ar";
    }
}