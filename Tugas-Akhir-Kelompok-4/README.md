# Kelompok 4 [![Maven central](https://maven-badges.herokuapp.com/maven-central/org.mybatis.spring.boot/mybatis-spring-boot/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.mybatis.spring.boot/mybatis-spring-boot) [![Build Status](https://travis-ci.com/abasjr/rscs_silabor.svg?token=s2onCVRpBxKToXoqFnEV&branch=master)](https://travis-ci.com/abasjr/rscs_silabor) [![PRs Welcome](https://img.shields.io/badge/PRs-welcome-green.svg)](https://github.com/abasjr/rscs_silabor/issues) [![Javadocs](http://javadoc.io/badge/org.postgresql/postgresql.svg)](http://javadoc.io/doc/org.postgresql/postgresql)
Pada pengerjaan Project Tugas Akhir ini menggunakan metode kerja Agile dengan kerangka kerja Automated Kanban terlampir pada [Project KANBAN Kelompok 4](https://github.com/users/abasjr/projects/5) 

## Members:
- [Anggit Baskorojati](https://github.com/abasjr) (17061066466)
- Hanna Tria Stephany Silitonga (1706106753)
- Nur Hildayanti Utami (1706106886)
- Poniman Sibarani (1706106910)
- Rufina Fitri Anjani (1706106955)
- [Ryan Ardhy Risanto](https://github.com/ryanrisanto) (1706106961)
- Sonia Eka Putri (1706107024)
- Wiwin Nur'aini (1706107081)

## Tools
Spring Boot + PostgreSQL + Heroku,  Deployed at https://silabor-kelompok4.herokuapp.com/

![silabor kelompok4](https://user-images.githubusercontent.com/36306922/58885637-c7071c00-870c-11e9-80c6-3f44747b5cc8.gif)


## Installing
Install `java` at least version `1.8.0`, follow [this instruction](https://www.java.com/en/download/help/download_options.xml) to install Java 1.8 JDK.

After Java installed, Follow this instructions
```bash
$ git clone https://github.com/abasjr/rscs_silabor.git
$ cd rscs_silabor
$ ./mvnw install
$ ./mvnw build
$ ./mwnw spring-boot:run
```
Go to `http://localhost:8080/` to [start this application.](http://localhost:8080/)

## Version
```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.5.RELEASE</version>
    <relativePath/>
</parent>
<groupId>com.apap</groupId>
<artifactId>silabor</artifactId>
<version>0.0.1-SNAPSHOT</version>
<name>demo</name>
<description>Demo project for Spring Boot</description>
<properties>
    <java.version>1.8</java.version>
</properties>
```

## Documentation
Our Application Programming Interface is available at [API page.](API.md)

## Styleguide
Our styleguide to write this application available at [Styleguide.](STYLEGUIDE.md)

## Deployment
Once `spring-boot-maven-plugin` has been included in your `pom.xml`, it automatically tries to rewrite archives to make them executable by using the `spring-boot:repackage` goal.
You should configure your project to build a jar or war (as appropriate) by using the usual packaging element, as shown in the following example:
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<!-- ... -->
	<packaging>jar</packaging>
	<!-- ... -->
</project>
```
[See more](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#build-tool-plugins-maven-packaging)
 

## Features
- [x] Login
- [x] Logout
- [x] Membuat perencanaan kebutuhan reagen
- [x] Melihat perencanaan kebutuhan reagen
- [x] Web Service untuk mengembalikan data perencanaan kebutuhan reagen
- [x] Mengelola perencanaan kebutuhan reagen
- [x] Melihat daftar permintaan pemeriksaan lab
- [x] Web Service untuk menerima permintaan pemeriksaan lab
- [x] Mengubah status pemeriksaan lab
- [x] Membuat jadwal staf lab jaga
- [x] Melihat jadwal staf lab jaga
- [x] Mengubah jadwal staf lab jaga
- [x] Membuat data persediaan lab
- [x] Mengubah data persediaan lab

## Important links
- [VIM Config](https://github.com/abasjr/vimrc)
- [Maven](https://maven.apache.org/)
- [Rest Cheatsheet](https://github.com/RestCheatSheet/api-cheat-sheet#api-design-cheat-sheet)
- [Spring Boot Homepage](https://docs.spring.io/spring-boot/docs/current/reference/html/index.html)
- [JUnit Test Framework](https://junit.org/junit5/)
- [Java Documentation](https://docs.oracle.com/javase/8/docs/api/)
