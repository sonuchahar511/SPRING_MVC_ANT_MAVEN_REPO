package com.chahar.spring.mvc.controllers;


import com.chahar.spring.mvc.dto.LoggerConfInfo;
import com.chahar.spring.mvc.dto.form.LoggerInfoForm;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@RequestMapping("/logger/log4j")
@Controller
public class LoggerConfigurationController extends AbstractPageController{

    @RequestMapping(method= RequestMethod.GET)
    public String loggerPage(final Model model) {
        LOG.info(" /logger/log4j + GET ");

        model.addAttribute("loggers" , getLoggers());

        return "loggePage";
    }

    @RequestMapping(value = "/update", method= RequestMethod.POST)
    public String updateLoggerInfo(LoggerInfoForm loggerInfoForm , final Model model) {
        LOG.info(" /logger/log4j/update + POST , {} " , loggerInfoForm);

        LOG.info("---------------------------------------------------------- ");

        LoggerConfig desiredLogConfig = getOrCreateLoggerConfigFor(loggerInfoForm.getPackageName());
        Level oldLevel =  desiredLogConfig.getLevel();
        Level targetLevel = Level.getLevel(loggerInfoForm.getLogLevel());

        desiredLogConfig.setLevel(targetLevel);
        ((LoggerContext)LogManager.getContext(false)).updateLoggers();

        LOG.info("Log level changes from {} to {} for {}" , oldLevel , targetLevel , desiredLogConfig.getName());

        LOG.info("----------------------------------------------------------");

        return "redirect:" +"/logger/log4j" ;
    }

    private List<LoggerConfInfo> getLoggers(){
        List<LoggerConfInfo> result = new ArrayList<>();

        LoggerContext loggerContext = ((LoggerContext)LogManager.getContext(false));
        Configuration config = loggerContext.getConfiguration();
        Collection<LoggerConfig> loggerConfigs =  config.getLoggers().values();

        Iterator var4 = loggerConfigs.iterator();
        while(var4.hasNext()) {
            LoggerConfig loggerConfig = (LoggerConfig)var4.next();
            result.add(this.mapToConfigData(loggerConfig));
        }

        return result;
    }



    private LoggerConfig getOrCreateLoggerConfigFor(String loggerName1){
        String loggerName = "".equals(loggerName1)? "root" : loggerName1;

        LoggerContext loggerContext = ((LoggerContext)LogManager.getContext(false));
        Configuration configuration = (AbstractConfiguration) loggerContext.getConfiguration();

        LoggerConfig existingConfig = configuration.getLoggerConfig(loggerName);
        if (existingConfig.getName().equals(loggerName)) {
            return existingConfig;
        } else {
            LOG.info("Creating logger " + loggerName);
            LoggerConfig rootLoggerConfig = ((AbstractConfiguration)configuration).getRootLogger();

            LoggerConfig newLoggerConfig = LoggerConfig.createLogger("True", rootLoggerConfig.getLevel(), loggerName,
                    String.valueOf(rootLoggerConfig.isIncludeLocation()), (AppenderRef[])rootLoggerConfig.getAppenderRefs().toArray(new AppenderRef[0]),
                    (Property[])null, configuration, rootLoggerConfig.getFilter());

            rootLoggerConfig.getAppenders().forEach((k, v) -> {
                rootLoggerConfig.addAppender(v, (Level)null, (Filter)null);
            });

            configuration.addLogger(loggerName, newLoggerConfig);
            return newLoggerConfig;
        }
    }

    private LoggerConfInfo mapToConfigData(LoggerConfig source){
        LoggerConfInfo target = new LoggerConfInfo();

        target.setName(this.toPresentationFormat(source.getName()));
        target.setEffectiveLevel( source.getLevel() != null ? source.getLevel().name() : "" );
        if (source.getParent() != null) {
            target.setParentName(this.toPresentationFormat(source.getParent().getName()));
        }


        return target;
    }

    private String toPresentationFormat(String name) {
        return name.equals("") ? "root" : name;
    }
}
