# Spring Json Properties Resouce Loader

A demo about Spring cloud config server and JSON file.

  - Embeded Spring Cloud Config Server
  - Json Perperties / Resoruce

Why this:
  - Some of config files in our project are based on JSON.
  - When do 'refresh', properties and yaml files can be updated, but not JSON.
  - This will update the josn when do refresh.
  
### The Example
  - Read config file from local or from git

### How to Use
You can 
  - copy the file ```JsonPropertySourceLoader``` and create a new file ```spring.factories``` and folder ```META-INF``` in resources, or
  - wrap this as a library.

