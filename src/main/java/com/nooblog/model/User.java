package com.nooblog.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "User")
@Entity
public class User {

    @JacksonXmlProperty(localName = "id")
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @JacksonXmlProperty(localName = "email")
    @Column(nullable = false)
    private String email;

    @JacksonXmlProperty(localName = "name")
    @Column(nullable = false)
    private String name;

    @JacksonXmlProperty(localName = "password")
    @Column(nullable = false)
    private String password;

}
