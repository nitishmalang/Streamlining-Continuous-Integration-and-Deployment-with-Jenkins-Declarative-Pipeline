# Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline

Setting up AWS EC2 Instance:

Launch an Amazon EC2 instance on AWS console with the desired configuration.
Download the generated key pair (.pem) file to your local machine.
Connecting via SSH:

Open your terminal and use the downloaded key to connect to the EC2 instance using SSH:

`ssh -i /path/to/your-key.pem ec2-user@your-instance-public-ip`

You are now connected to your AWS EC2 instance via SSH.





![Screenshot (370)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/a529ff1e-e8c7-44b8-892d-b1e82afdd83b)

This is how terminal is shown after connected via SSH





To clone the repository:

Run the following command in your terminal to clone the Django Notes App code:


`git clone https://github.com/nitishmalang/django-notes-app.git`

Once cloned, you can start exploring and working with the code locally on your machine.



After cloning, navigate to the repository using the cd command and view the codebase using ls:

Run the following commands in your terminal:


`cd django-notes-app`


`ls`



The ls command will display the contents of the cloned repository, allowing you to view the codebase files and directories.


![Screenshot (371)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/4b719c81-20d8-4658-be6e-e81702955bed)



After viewing the codebase, you can use the following command to update the package list on your Ubuntu system:


`sudo apt-get update`


This command will fetch the latest information about available packages from the Ubuntu repositories and update the package list on your system. It's a recommended step to ensure that you have the latest package information before installing or upgrading any software.


After that

Install Docker on Ubuntu, by using the following commands:


`sudo apt-get install docker.io`

After installation, verify Docker is installed and running: 

`sudo docker --version`

After installing Docker, use the following command to list the running containers:


`docker ps`


This command will display the currently running containers along with their details, such as Container ID, image, ports, and other information.


Now after that we have to create Dockerfile and also view requirements.txt file given in code repo





![Screenshot (373)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/ab96d979-e7a8-47d8-a807-1f6021ae6b2c)



after that we have to build docker image using command

`docker build -t notes-app .`



![Screenshot (374)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/67ccef9e-d1eb-4001-a366-2ee5e382a907)


Then we will understand about jenkins and install it

Introduction to Jenkins

1. Jenkins is an open-source automation server that enables the automation of
software development processes. It provides a platform for building, testing,
and deploying applications in an efficient and automated manner. Jenkins is
widely used in the industry due to its flexibility, extensibility, and large
community support. It supports various programming languages and integrates
with popular tools and frameworks.

2. Continuous Integration and Delivery (CI/CD): CI/CD is a software development
practice that involves automating the process of integrating code changes,
building applications, running tests, and deploying them to production. The
primary goals of CI/CD are to increase productivity, improve software quality,
and enable rapid and frequent releases. Continuous Integration (CI) focuses on
integrating code changes frequently, while Continuous Delivery (CD) ensures
that applications can be released at any time.

3. CI/CD Pipeline Overview: A CI/CD pipeline is a series of automated steps that
code goes through from version control to production deployment. It consists
of multiple stages, each representing a specific task or set of tasks. Common
stages include code compilation, unit testing, code analysis, artifact creation,
and deployment. Jenkins allows you to define and manage these stages,
ensuring that the entire process is automated, consistent, and reproducible.

## Installation of Jenkins

### Install Java

`sudo apt update`

`sudo apt install`

`openjdk-17-jre`

`java -version`

### Install Jenkins

`curl -fsSL https://pkg.jenkins.io/debianstable/jenkins.io-2023.key | sudo tee \
 /usr/share/keyrings/jenkins-keyring.asc >
/dev/null
echo deb [signed-by=/usr/share/keyrings/jenkinskeyring.asc] \
 https://pkg.jenkins.io/debian-stable binary/ |
sudo tee \
 /etc/apt/sources.list.d/jenkins.list > /dev/null
sudo apt-get update
sudo apt-get install jenkins`

After that expose port 8080 and using public IP open jenkins UI on browser and install plugins 
after all the setup the UI like this will be on the page 



![Screenshot (375)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/5057e51f-893f-4b69-9707-f95fe27f662c)


Now lets create a decelerative pipeline using pipeline option given in the job

This will be next page




![Screenshot (376)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/67bb22c9-56ca-4102-a084-24189fde5a06)



Below on build trigger option I have clicked on "GitHub Hook trigger for GITScm polling" 
this is because as code committed on repo and build will automatically start on jenkins


Now this is the most crucial aspect that is writing a decelarative pipeline



![Screenshot (377)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/0c8d1ee2-8e7f-48f7-abec-893095e5ba85)


This is the page where we have to write decelarative pipeline

now I have to write pipeline in stages
I consider Code part as a stage
then next Build part as a stage
then Push as a stage 
and then deployment is also the stage






![Screenshot (378)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/f48f4540-b8f8-4870-b6ca-7e98c206a8ab)

look at it how pipelines are written in stages

after clicking on save 


![Screenshot (379)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/32b09d70-b3ff-44c7-a9ac-27613c0418c9)

this UI is shown on this page click on build now



![Screenshot (380)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/932aa07f-e548-4a92-956b-b873b77a74fd)

after clicking on build this is how build is accomplished 

in ## Console Output it is given 

"Started by user admin
[Pipeline] Start of Pipeline
[Pipeline] node
Running on Jenkins in /var/lib/jenkins/workspace/notes-app-cicd
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Code)
[Pipeline] echo
Cloning the Code
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (Build)
[Pipeline] echo
Building the Code
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (Push to Docker Hub)
[Pipeline] echo
Pushing the image to Dockerhub
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (Deploy)
[Pipeline] echo
Deploying the container
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
"


