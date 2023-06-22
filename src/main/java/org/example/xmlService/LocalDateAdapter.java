package org.example.xmlService;


import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate unmarshal(String dateString) throws Exception {
        return LocalDate.parse(dateString, dateFormatter);
    }

    @Override
    public String marshal(LocalDate date) throws Exception {
        return date.format(dateFormatter);
    }
}
