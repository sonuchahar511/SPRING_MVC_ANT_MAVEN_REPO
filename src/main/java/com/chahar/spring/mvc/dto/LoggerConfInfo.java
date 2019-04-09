package com.chahar.spring.mvc.dto;

public class LoggerConfInfo {




    private String name,parentName,effectiveLevel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getEffectiveLevel() {
        return effectiveLevel;
    }

    public void setEffectiveLevel(String effectiveLevel) {
        this.effectiveLevel = effectiveLevel;
    }

    public LoggerConfInfo() {
    }
    public LoggerConfInfo(String name, String parentName, String effectiveLevel) {
        this.name = name;
        this.parentName = parentName;
        this.effectiveLevel = effectiveLevel;
    }

    @Override
    public String toString() {
        return "LoggerConfInfo{" +
                "name='" + name + '\'' +
                ", parentName='" + parentName + '\'' +
                ", effectiveLevel='" + effectiveLevel + '\'' +
                '}';
    }
}
