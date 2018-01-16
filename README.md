# alfresco-cloud-foundry
Alfresco integration with Cloud Foundry

This project is a PoC for a Cloud Foundry Service Broker providing access to CMIS API.

!(diagram)[https://github.com/OrderOfTheBee/alfresco-cloud-foundry/raw/master/diagram.png]

You can learn more about Pivotal Cloud Foundry product at
https://pivotal.io/platform/pcf-tutorials/getting-started-with-pivotal-cloud-foundry-dev/introduction

We were using PCF Dev platform to develop the project.

## Deployment

Create the service with the parameters

```bash
$ cf create-user-provided-service cmis-service -p '{"url":"https://cmis.alfresco.com/alfresco/api/-default-/public/cmis/versions/1.1/browser","user":"admin","pass":"admin"}'
```

Compile the application

```bash
$ ./gradlew assemble
```

Push the application to the Cloud

```bash
$ cf push cmis-test-1 -p build/libs/alfresco-cloud-foundry.jar
```

Bind the service with the application

```bash
$ cf bind-service cmis-test-1 cmis-service
```

Recreate the application in order to apply servicre parameters.

```bash
$ cf restage cmis-test-1
```

## Testing

Sample methods has been provided in order to test the service.

* Repository information

http://cmis-test-1.local.pcfdev.io/

* PDF files listing

http://cmis-test-1.local.pcfdev.io/f472543f-7218-403d-917b-7a5861257244/children

## Contributors

* David Antón
* Angel Borroy
* David Caruana
