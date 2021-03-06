module com.user12043.bookportal {
    requires spring.boot;
    requires spring.context;
    requires spring.beans;
    requires spring.data.jpa;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires spring.boot.autoconfigure;
    requires spring.web;
    requires spring.webmvc;
    requires spring.tx;
    requires com.fasterxml.jackson.annotation;

    exports com.user12043.bookportal;
}
