/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo.diDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-05-28
 */
@Data
@ToString
public class Book {

    private AnotherBook anotherBook;
    private String name;

    private AnotherBook anotherBook1;
    private String name1;

    private List<String> nameList;
    private List<AnotherBook> anotherBookList;

    private Map<String, String> nameMap;
    private Map<AnotherBook, AnotherBook> anotherBookMap;

    private Set<String> nameSet;
    private Set<AnotherBook> anotherBookSet;

    private Properties properties;

    private AnotherBook anotherBook2;

    public Book(AnotherBook anotherBook, String name) {
        this.anotherBook = anotherBook;
        this.name = name;
    }
}
