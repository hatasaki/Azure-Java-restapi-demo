# Java RestAPI sample

## Deploy to Azure AppService
1. Run the maven command below to configure the deployment (update pom.xml)
``` Bash
mvn com.microsoft.azure:azure-webapp-maven-plugin:2.5.0:config
```
2. Deploy the apps (with the configuration of pom file)
``` Bash
mvn package azure-webapp:deploy
```
For details, please refer document below  
https://learn.microsoft.com/en-us/azure/app-service/quickstart-java?tabs=tomcat&pivots=platform-linux-development-environment-maven

## Deploy to Azure Kubernetes Service (AKS) / Azure Red Hat OpenShift (ARO)
1. Create JAR
``` Bash
./mvnw clean package
```
2. Build container image (with Dockerfile)
``` Bash
docker build -t <yourregistry>.azurecr.io/restapidemo:v1 .
```
3. Push the imaget to your Azure Container Registry (ACR)
``` Bash
docker push <yourregistry>.azurecr.io/restapidemo:v1
```
4. Deploy container to AKS/ARO
Create Deployment with sample file (/yaml/deployment.yaml)  
  Note: You need to configure pull secret on AKS/ARO to pull image from your private registry.

## Deploy to ContainerApps
1. Create JAR, build container images, and push the image to ACR  
 Same as 1,2 and 3 of above section.

2. Create new ContainerApps with Portal  
See https://learn.microsoft.com/en-us/azure/container-apps/get-started-existing-container-image-portal?pivots=container-apps-private-registry


# Contributing

This project has adopted the [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/). For more information see the [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) or contact [opencode@microsoft.com](mailto:opencode@microsoft.com) with any additional questions or comments.