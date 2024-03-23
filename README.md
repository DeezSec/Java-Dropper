# Java-Dropper
![vx](https://art.vx-underground.org/art/c92ebe07-2ac3-4dce-8168-b418e20c1579.png)
No more clumsy Payload transfer methods, when you have the Ultimate droppers available.
This is simply a dropper which helps in delivering the payload to your victim. Let's go through the process step-by-step.

# Requirements
![logo](https://cdn.icon-icons.com/icons2/2699/PNG/512/java_logo_icon_168609.png)
1. JDK==17.0.10 (obvious)
- It comes preinstalled on most of the linux distros, If you don't have it, install it.
- Check by running the command: ```java --version```
2. Install **makeself**
- ```sudo apt install makeself``` and once it's done, we're good to go.
3. Assuming that your are testing this dropper on another victim machine which is **yours**.
  - Boot up your Vmware/Virtualbox and load your victim machine but do not power it on yet.

# Simple Instructions

1. Create a dir ```mkdir dropper_file```  which we will be using to store all the necessary files.
2. Download the **Dropper.java** file from this repo and store it in the above created dir, make necessary changes to it such as changing the payload and victim's default download path.
3. Run ```javac Dropper.java```, It will make a class file upon compilation. You'll get a class file and keep it with you.
4. create a jar file: ```jar cvfe Dropper.jar healthcare Dropper.class```
5. Make a shell script: ```touch run.sh``` open the file
   ```pluma run.sh``` and include the following in that script.
```
!#/bin/bash
 java -jar dropper.jar
```

  - The ``run.sh`` serves as a supporting script to make the jar file executed immediately, save the file in the same direcory.

6. run
```makeself --notemp /home/<user>/dropper_files /home/<user>/dropper_files/dropper_installer.sh "healthcare" ./run.sh```

you can name the jar file as you wish, i'm using healthcare as the name, replace the user with your actual sys user and run the command. If you have done everything correctly, you can see the ```Dropper.jar``` file.

<a href="https://ibb.co/3v3vxbL"><img src="https://i.ibb.co/xYkYnbR/show-dropper.jpg" alt="show-dropper" border="0"></a>

- once that's done, we can now transfer this ***Dropper.java** to the victim's machine by using any anonymous mail or by any other means,I suggest using temporary mails if you're doing on a real victim which i highly suggest you to not do. After the victim double clicks on the jar file It should automatically execute the files we placed inside and download the payload to the specified directory in victim's machine. I can show how an attacker can meticulously craft a social engineering attack on the victim and make him/her click on the unsuspected file, which in returns downloads the payload into the machine. ***There seems to be an issue from the SXF option in Jar file, I'll make the necessary changes and update the repository. Untill then the java dropper may not work properly.***
# Some resources that might help
> - [File.Io](https://www.file.io/)
> - [AnonMail](https://anonymous-mail.maildim.com/)
> - [Upload Anonymously](https://anonsharing.com/)
> - Thanks to VX-UnderGround for their awesome art.
[VX-UG](https://art.vx-underground.org/index.html)

# Disclaimer
All this is done to show how the whole malware drop scenarios work, don't use this to send the payloads to real victims, which will land you in bad position. While it may seem cool to do, It's not. It is completely unethical and makes the victim cause damage. I hold no responsiblity and liability in such cases. I want you to know how this works by testing this stuff on your own system. 
