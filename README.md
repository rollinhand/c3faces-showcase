# C3Faces showcase
This is the showcase for the [C3Faces JSF library](http://c3faces.kivio.org). The showcase is based
on the work of [Martin Linha](https://github.com/martin-linha/c3faces-showcase) who is the initial creator of the
C3Faces library.

C3Faces is a JSF library using [C3.js](http://c3js.org) for the underlying rendering technology for every interactive 
chart.

In opposite to [Highfaces](http://highfaces.org) works C3Faces together with Apache MyFaces and Oracles Mojarra.

The latest sources for C3Faces are available at [GitHub](https://github.com/rollinhand/c3faces). This repository is a 
fork of the [original library](https://github.com/martin-linha/c3faces) created by Martin Linha.
Because this library is no longer under active development it was forked by me and is also officially released to Maven
central, so that usage of the library is that easy.

The built version of the showcase is available at [http://c3faces.kivio.org](http://c3faces.kivio.org). If you find any
issues in the showcase or requesting new features or deeper explanation please file an 
[Issue](https://github.com/rollinhand/c3faces-showcase/issues) or a pull request.

## Usage
This showcase uses TomEE 7.0.4 as application server. The whole showcase is also available as docker image.

### Starting a local server
The showcase can be executed on every local machine which has Java 8 installed. Just call the following Maven command:

```
mvn clean package tomee:run
```

and open a browser calling the URL: `http://localhost:8080/`

### Build and deploy docker image
The POM also includes the great Docker Maven plugin by fabric8.
The image can be build by running the following Maven command:

```
mvn clean package docker:build
```

or if you want to execute the image in your local docker instance, execute the following Maven command:

```
mvn clean package docker:build docker:run
```

If you have a remote machine running a docker host, deploy the image to your machine and import it with the following
command:

```
docker import docker-build.tar.gz
```

The image is available as **c3faces-showcase** or with its alias **showcase**.

A container based on that image can be started as follows:

```
docker run -d -p 8080:8080 showcase
```

Or if you want to use a different port, because 8080 is reserved by a different instance,
execute the following command:

```
docker run -d -p 8081:8080 showcase
```

In case of error a container can be automatically restarted:

```
docker run -d -p 8081:8080 --restart unless-stopped showcase
```

