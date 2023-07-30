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


Now let's create Dockerfile for this code 






