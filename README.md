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

After installing Docker, use the following command to list running containers:


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

##  In Console Output it is given 

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



Now in next step we will clone code from github 
Then build image using docker 
Then push it to dockerhub
using credentials 




![Screenshot (381)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/85723a5a-e35f-488e-aca3-f24bbe1a88d0)

The entire pipeline that shows how to push image to dockerhub


![Screenshot (382)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/8ca54537-109e-4518-b6ba-979501a86846) 

after successful build 



![Screenshot (384)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/25bc36f4-9d4c-4684-8772-e3c96754de65)


image is successfully pushed on dockerhub



Now in next step we will write script to deploy it 

![Screenshot (385)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/acacefea-631c-40e8-8f1b-d1ad3bfd0612)

after building it successfully 

![Screenshot (386)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/fba4ccb3-ed16-4898-9427-9ae81a5dc9bb)

Now let's see application is running

![Screenshot (387)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/1bafee88-4492-41a6-8cd3-aba07cbb38eb)

and yes application is running successfully on port 8000

yeah.... booyah

Now have built this pipeline but still it not robust

let's see since application was deployed successfully 
after I built it once again it shown me error 



![Screenshot (388)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/5a098a67-848e-4ed8-b971-7eb901c2cbf2)

in output it shows port 8000 already allocated 

"Started by user admin
[Pipeline] Start of Pipeline
[Pipeline] node
Running on Jenkins in /var/lib/jenkins/workspace/notes-app-cicd
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Code Clone)
[Pipeline] echo
Cloning the Code
[Pipeline] git
The recommended git tool is: NONE
No credentials specified
 > git rev-parse --resolve-git-dir /var/lib/jenkins/workspace/notes-app-cicd/.git # timeout=10
Fetching changes from the remote Git repository
 > git config remote.origin.url https://github.com/nitishmalang/django-notes-app.git # timeout=10
Fetching upstream changes from https://github.com/nitishmalang/django-notes-app.git
 > git --version # timeout=10
 > git --version # 'git version 2.34.1'
 > git fetch --tags --force --progress -- https://github.com/nitishmalang/django-notes-app.git +refs/heads/*:refs/remotes/origin/* # timeout=10
 > git rev-parse refs/remotes/origin/main^{commit} # timeout=10
Checking out Revision a4c62df06ae250c67e1d2f15bd4df2fa284065d6 (refs/remotes/origin/main)
 > git config core.sparsecheckout # timeout=10
 > git checkout -f a4c62df06ae250c67e1d2f15bd4df2fa284065d6 # timeout=10
 > git branch -a -v --no-abbrev # timeout=10
 > git branch -D main # timeout=10
 > git checkout -b main a4c62df06ae250c67e1d2f15bd4df2fa284065d6 # timeout=10
Commit message: "Update README.md"
 > git rev-list --no-walk a4c62df06ae250c67e1d2f15bd4df2fa284065d6 # timeout=10
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (Build)
[Pipeline] echo
Building the Code
[Pipeline] sh
+ docker build -t my-note-app .
Sending build context to Docker daemon  8.402MB

Step 1/7 : FROM python:3.9
 ---> 2202efa5d0ba
Step 2/7 : WORKDIR /app/backend
 ---> Using cache
 ---> 821f3b9caa34
Step 3/7 : COPY requirements.txt /app/backend
 ---> Using cache
 ---> 520dade8af82
Step 4/7 : RUN pip install -r requirements.txt
 ---> Using cache
 ---> 372994a8b75c
Step 5/7 : COPY . /app/backend
 ---> 4ed3e1989045
Step 6/7 : EXPOSE 8000
 ---> Running in bf9e4f8ffa9c
Removing intermediate container bf9e4f8ffa9c
 ---> de5481bcec5d
Step 7/7 : CMD python /app/backend/manage.py runserver 0.0.0.0:8000
 ---> Running in 3e09c0542c8f
Removing intermediate container 3e09c0542c8f
 ---> 79cb13ee7b76
Successfully built 79cb13ee7b76
Successfully tagged my-note-app:latest
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (Push to Docker Hub)
[Pipeline] echo
Pushing the image to Dockerhub
[Pipeline] withCredentials
Masking supported pattern matches of $dockerHubPass
[Pipeline] {
[Pipeline] sh
Warning: A secret was passed to "sh" using Groovy String interpolation, which is insecure.
		 Affected argument(s) used the following variable(s): [dockerHubPass]
		 See https://jenkins.io/redirect/groovy-string-interpolation for details.
+ docker login -u nitishmalang -p ****
WARNING! Using --password via the CLI is insecure. Use --password-stdin.
WARNING! Your password will be stored unencrypted in /var/lib/jenkins/.docker/config.json.
Configure a credential helper to remove this warning. See
https://docs.docker.com/engine/reference/commandline/login/#credentials-store

Login Succeeded
[Pipeline] }
[Pipeline] // withCredentials
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (Deploy)
[Pipeline] echo
Deploying the container
[Pipeline] sh
+ docker run -d -p 8000:8000 nitishmalang/my-note-app:latest
7df30ddbd9fb8558b8f92f53d66be832cfbe40702453214d1dbcfc7d7fc3f4c9
docker: Error response from daemon: driver failed programming external connectivity on endpoint beautiful_mestorf (19db5859d27b599e027fcdbed7f5a0d3834e1130d75f4ebdf3d83c1a4955ccbe):
## Bind for 0.0.0.0:8000 failed: port is already allocated.
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
ERROR: script returned exit code 125
Finished: FAILURE"

Now for solving this problem let's use docker compose 
what happened was when I deployed it again the port 8000 was already allocated highlighted in output
now what docker compose will do is it will down the running application and restart another application on same port 

Now let's install docker compose on our system

![Screenshot (389)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/42c3b7bf-3e33-4a62-8424-f059e9529855)


after that 



![Screenshot (390)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/e1941040-d293-4a8c-9905-6ab631c49316)

Now from docker compose it is very simple up and down application

![Screenshot (391)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/979d7c2b-776f-4ae6-ac6d-225c0d444716)


After that the issue of rebuilding is resolved 


Now next thing is building pipeline using SCM
which is "Source Code Management"








![Screenshot (392)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/02fbe08e-c717-4513-a5c0-f00257e6f4a7)


Now we have successfully built it using SCM
![Screenshot (393)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/34f52b6a-0929-4583-ad94-75ff38dd38e2)

After that let's build it using Github Webhook

after connecting through webhook as we commit in Github repo build will automatically start on Jenkins

This is how we have to create webhook on Github






![Screenshot (394)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/17a676e4-01a5-4ac8-ad94-0b84831eac45)



and that's how when we commit on github it will automatically build on jenkins this is the basic concept of webhook




![Screenshot (395)](https://github.com/nitishmalang/Streamlining-Continuous-Integration-and-Deployment-with-Jenkins-Declarative-Pipeline/assets/71919457/a45f6991-46aa-42c6-8b4e-053ea3c93aae)


Conclusion:

In conclusion, the implementation of the Jenkins pipeline for building, pushing, and deploying the Django Notes App using Docker Compose has been successfully achieved. The pipeline follows a well-structured approach, consisting of four stages: "Code Clone," "Build," "Push to Dockerhub," and "Deploy."

The "Code Clone" stage clones the source code from the GitHub repository's main branch, ensuring the latest codebase is used for the subsequent stages. The "Build" stage effectively builds a Docker image of the Django application using the provided Dockerfile. The "Push to Dockerhub" stage securely pushes the built Docker image to Docker Hub, enabling easy distribution and access to the application.

Finally, the "Deploy" stage orchestrates the deployment of the Docker containers using Docker Compose, ensuring seamless execution of the Django Notes App. This comprehensive pipeline has streamlined the development process, enabling faster and more efficient delivery of the application.

By leveraging automation and containerization, this pipeline enhances consistency and reliability while reducing the risk of deployment errors. Furthermore, the use of webhooks enables continuous integration and deployment, ensuring that any code changes trigger automatic pipeline execution, thereby facilitating a continuous delivery workflow.

Overall, the successful implementation of this Jenkins pipeline for the Django Notes App demonstrates the power of DevOps practices and containerization technologies in modern software development, ultimately leading to an improved development workflow and faster time-to-market for the application.






