package com.chahar.spring.mvc.dto.form;

public class LoggerInfoForm {
    private String packageName,logLevel;

    public LoggerInfoForm() {
    }

    @Override
    public String toString() {
        return "LoggerInfoForm{" +
                "packageName='" + packageName + '\'' +
                ", logLevel='" + logLevel + '\'' +
                '}';
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }
}
