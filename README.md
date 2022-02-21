# About 
This is a simple app provided to present a messaging system when a user is created in the application.  Used technologies :
- JavaEE 8 
- Kafka broker
- MySql database
- WildFly application server   

# Kafka Configuration
- To download **Apache Kafka** go to the following Url and get the latest version:
https://kafka.apache.org/downloads

- This is a .gz file. Extract it in the root directory of a drive (e.g., c:\) in your system.

- Go to the kafka folder **kafka\bin\wondows**. this is the folder where you see all `.bat` files. In order to test whether Kafka is working on your machine or not, open `Command Prompt` in this directory and type `kafka.topics.bat`. You will see a bunch of options and descriptions for this command.

- The last step for configuration will be adding this path **C:\Kafka_folder\bin\windows** to `Environment Variables` on windows.

# Start kafka & Zookeeper
- In the kafka folder, add a new folder and name it `data`. Enter this `data` folder then create two new folders called `zookeeper` and another one `kafka`. 

- Copy the directory path of the `zookeeper` folder and open `zookeeper.properties` in `Config` folder. Change the `dataDir=` to the directory `zookeeper` folder that you just copied. (replace slashes (\\) with forward slashes (/))
```sh
dataDir=C:/kafka_folder/data/Zookeeper 
```

- In order for Kafka to run you must start zookeeper first. Go to the kafka folder and open `Command Prompt` in this directory. type following command to start zookeeper :
```sh
zookeeper-server-start.bat config\zookeeper.properties
```
If everything goes correct you should see **binding to port 0.0.0.0/0.0.0.0:2181**. For executing kafka you must keep zookeeper running. 

- After that, copy **\kafka\data\kafka** directory path and past it in server.properties for `log.dirs=` attribute. (notice slash again!) 
```sh
log.dirs=C:/kafka_folder/data/Kafka
```

- Open another `Command prompt` window in the kafka folder and type :
```sh
kafka-server-start.bat config\server.properties
```
you should see in logs **kafka server id=0 started**. 

