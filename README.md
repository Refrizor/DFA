<img src="https://user-images.githubusercontent.com/45441561/164153001-a89c287f-0595-40d8-ba4d-6e3f72b2a874.png" height="200" width="200">

### Project is no longer actively maintained by me. Feel free to contribute any changes or fork!
While this is no actively maintained, small updates may push out in the future if I decide to pick it back up. This could potentially turn into a full-fledged plugin that you can add to any server. Spigot version may be changed to 1.19

DiamondFire Activities repository. This repository is ~~private~~ public access. Maintained by **Refrizor**


## Development
The project solely uses Java, with some use cases of JSON for world generation and YAML for configuration. It depends on the latest stable version of Spigot (run BuildTools.jar), and requires the latest version of mysql-connector-java. DFA runs on JDK 17.

We stay true to organization and naming conventions. In the repo/source files, you will notice we use "Command" before labeling any command, and add "Event" after each event class, and we stay as true as possible for naming classes, so follow that type of format and continue the organization efforts for common practice and ease of reading, and ease of interpretation from new developers.

## Requirements
The base requirements to run our system:
- Spigot API for 1.18.5
- Preferably the <a href="https://www.jetbrains.com/idea/">IntellJ Idea</a> IDE. If you use another IDE, that is okay, but be mindful about commits - do not commit your IDE's files to our repo!
- <a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html?msclkid=7537580dc06611ecbbbf36e60c7ef60d">JDK 17</a>
- <a href="https://maven.apache.org/">Maven</a>. IntelliJ provides this
- <a href="https://git-scm.com/">Git</a>. IntelliJ integrates this; it is recommended to use IntellJ's git integration
- <a href="https://dev.mysql.com/downloads/">MySQL</a>. Consider using xaamp if you run on Windows. If you want to run it on a Linux distribution, set it up however you'd like. We will provide you the SQL dump file to import. On Linux? `sudo apt install mysql-server`
- <a href="https://mvnrepository.com/artifact/mysql/mysql-connector-java">mysql-connector-java</a>

## Optional
- <a href="https://www.phpmyadmin.net/">phpMyAdmin</a>. On Linux? `sudo apt-get install phpmyadmin`
