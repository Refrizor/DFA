# DFA

DiamondFire Activities repository. This repository is *private* access, be mindful about sharing any information. Maintained by **Refrizor**


## Development
The project solely uses Java, with some use cases of JSON for world generation and YAML for configuration. It depends on the latest stable version of Spigot (run BuildTools.jar), and requires the latest version of mysql-connector-java. DFA runs on JDK 17.

We stay true to organization and naming conventions. In the repo/source files, you will notice we use "Command" before labeling any command, and add "Event" after each event class, and we stay as true as possible for naming classes, so follow that type of format and continue the organization efforts for common practice and ease of reading, and ease of interpretation from new developers.

## Requirements
The base requirements to run our system:
- Preferably the IntellJ Idea IDE. If you use another IDE, that is okay, but be mindful about commits - do not commit your IDE's files to our repo!
- JDK 17
- Maven. IntelliJ provides this
- Git. IntelliJ integrates this; it is recommended to use IntellJ's git integration
- MySQL. Consider using xaamp if you run on Windows. If you want to run it on a Linux distribution, set it up however you'd like. We will provide you the SQL dump file to import
- mysql-connector-java
