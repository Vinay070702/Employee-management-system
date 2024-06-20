# Employee Management System (EMS)

## Overview

Employee Management System (EMS) is a web application built with Spring Boot, using MySQL as the database. This repository provides instructions on how to build a Docker image for EMS, deploy it on Kubernetes using Minikube, and manage the deployment lifecycle.

## login
```bash
username : admin
password : admin123
```

## Prerequisites

Before you begin, ensure you have the following installed:
- Docker (for building and managing Docker images)
- Minikube (for running Kubernetes locally)

## 1. Docker Image Creation

### Dockerfile

Create a Dockerfile in your project directory to define how your application should be packaged into a Docker image.

```dockerfile
# Use an official OpenJDK runtime as a parent image
FROM openjdk:12

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container at /app
COPY target/ems-app.jar /app

# Expose the port the app runs in
EXPOSE 9999

# Command to run the application when the container starts
CMD ["java", "-jar", "ems-app.jar"]
```
### Build Docker Image
Build your Docker image using the provided Dockerfile:
```bash
docker build -t ems-app:latest .
```
This command tags the built image as 'ems-app' with the 'latest' tag.

## 2. Kubernetes Deployment with Minikube
### Kubernetes Manifests
Create Kubernetes manifests to deploy your application ('mysql-secrets.yaml', 'mysql-pv.yaml', 'mysql-deployment.yaml', 'app-deployment.yaml').

### Deploy to Kubernetes
Apply the Kubernetes manifests to create a deployment, service, and persistent volume for your application:
```bash
kubectl apply -f mysql-secrets.yaml
kubectl apply -f mysql-pv.yaml
kubectl apply -f mysql-deployment.yaml
kubectl apply -f app-deployment.yaml
```
Verify the deployment by checking the status of your pods and services:
```bash
kubectl get pods
kubectl get services
```
### Accessing the Application
Find the Node IP:
Find the IP of your Minikube or kind node. For Minikube, you can use:
```bash
minikube ip
```
Access the Application:
Access your application using the Node IP and NodePort:
```bash
http://<NODE_IP>:31903
```
or just use this command 
```bash
minikube service app --url
```
Now the application is ready in kubernetes
## 3. Managing Kubernetes Resources (Optinal)
### Deleting Kubernetes Resources
To delete the deployment, service, persistent volume, and claim:
```bash
kubectl delete deployment ems-app
kubectl delete service ems-app
kubectl delete persistentvolume mysql-pv-volume
kubectl delete persistentvolumeclaim mysql-pv-claim
```
### Stopping Minikube
When you're done with Minikube, stop the Minikube VM:
```bash
minikube stop
```

### Deleting Minikube
Optionally, delete the Minikube VM and all associated resources:
```bash
minikube delete
```




# Tools and technologies

* JDK - Java 1.8
* IDE- Spring Tool suite 4

* Framework - Spring Boot
security - Spring boot security

* Database – MySql Workbench 8.0, Spring Boot JDBC, Spring Data JPA (Hibernate)

* Front-end: 
HTML, bootstrap 4, Thymeleaf.

# Challenges Faced 

* Faced error into database issue.
* Faced not getting any data from user input.
* Front end logical issue.
* Faced Some Little bugs.





