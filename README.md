# ENI Java Auction Project
[![pipeline status](https://gitlab.com/AzzRun/eni-java-project-bid/badges/dev/pipeline.svg)](https://gitlab.com/AzzRun/eni-java-project-bid/commits/dev)
[![coverage report](https://gitlab.com/AzzRun/eni-java-project-bid/badges/dev/coverage.svg)](https://gitlab.com/AzzRun/eni-java-project-bid/commits/dev)
[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg?style=flat-square)](https://github.com/your/your-project/blob/master/LICENSE)

ENI Java Auction Project, a student projet to learn Java JEE development, whithout framework (Ex Spring).

![Logo of the project](./screenshots/main.gif)

# Getting Started
## From GIT
```shell
- git clone https://gitlab.com/AzzRun/eni-java-project-bid.git
- ant builddist
# Copy ${Project.dir}\dist\ENI-Encheres.war into Tomcat webapps installation folder
- start tomcat
```

## From Gitlab Artifacts/Release
```shell
- Download the artifacts/release from gitlab
# Copy ${Project.dir}\dist\ENI-Encheres.war into Tomcat webapps installation folder
- start tomcat
```

## Prerequisites
What is needed to set up the dev environment. For instance, global dependencies or any other tools. include download links.
- Java JDK & JRE ~+8 
- Apache Tomcat ~+8.5.39
- Projet librairies
- Eclipse Oxygen.3a Release (4.7.3a) ~+

## Running the tests (Junit tests)
```shell
ant test
```


## Exemple
### Get an DAO entity
```java
IDAOEnchere EnchereDAO = AbstractDAOFactory.getFactory().getEnchereDAO();
```


Built With
Apache ant - for automating software build processes

Contributing
Please read CONTRIBUTING.md for details on our code of conduct, and the process for submitting pull requests to us.

Versioning
We use GIT for versioning. For the versions available, see the tags on this repository.

## Team

| <a href="http://github.com/azzrun" target="_blank">**Quentin Martinez @AzzRun**</a> | <a href="https://gitlab.com/fbnctn" target="_blank">**Fabien Catin @fbnctn**</a> | <a href="https://gitlab.com/ApoZLd" target="_blank">**Romain @ApoZLd**</a> |
| :---: |:---:| :---:|
| [![ Quentin Martinez @AzzRun](https://avatars0.githubusercontent.com/u/20741531?s=200)](http://azrunsoft.com)    | [![Fabien Catin @fbnctn ](https://secure.gravatar.com/avatar/75be2983e928aaf4f3d30e9ddff02cae?s=180&d=identicon)](https://gitlab.com/fbnctn) | [![Romain @ApoZLd](https://assets.gitlab-static.net/uploads/-/system/user/avatar/3144065/avatar.png?width=90)](https://gitlab.com/ApoZLd)  |
| <a href="http://github.com/azzrun" target="_blank">`github.com/azzrun`</a> | <a href="https://gitlab.com/fbnctn" target="_blank">`gitlab.com/fbnctn`</a> | <a href="https://gitlab.com/ApoZLd" target="_blank">`gitlab.com/ApoZLd`</a> |



License
This project is licensed under the MIT License - see the LICENSE.md file for details

Acknowledgments
Hat tip to anyone whose code was used
Inspiration
etc