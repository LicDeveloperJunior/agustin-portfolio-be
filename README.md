---

## 📁 `README.md` para el **backend (Spring Boot 2.7.4)**

# 🧑‍💻 Agustin Portfolio - Backend

Este es el backend de mi portfolio personal, desarrollado con **Spring Boot 2.7.4** el cual expone una API REST que gestiona autenticación, envío de mails y CRUDs para proyectos, experiencia, tecnologías, formacion y mucho más contenido sobre mí.

---

## 🚀 Tecnologías utilizadas

- **Java 17**
- **Spring Boot 2.7.4**
  - Spring Web
  - Spring Security + JWT
  - Spring Data JPA
  - Spring Mail
- **MySQL 8**
- **Lombok**
- **Dotenv (para variables de entorno)**
- **Apache HttpClient**
- **JJWT 0.9.1**

---

## ⚙️ Requisitos previos

- JDK 17 o superior
- Maven
- MySQL local en `localhost:3307` con base de datos `portfolio_bd`
- application.properties:
```bash
spring.datasource.url=jdbc:mysql://localhost:3307/portfolio_bd?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

#JWT Token
jwt.secret=${JWT_SECRET}
jwt.expiration=3600000
```
---

## 🛠️ Instalación y ejecución local
```bash
git clone https://github.com/LicDeveloperJunior/agustin-portfolio-be.git
cd agustin-portfolio-be
mvn spring-boot:run
