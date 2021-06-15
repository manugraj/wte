# GraalVM & Native Image builder

## Install GraalVM with SDKMAN

- Install `sdkman`

```
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```
- List all JDKSs

```
sdk list java

================================================================================
Available Java Versions
================================================================================
 Vendor        | Use | Version      | Dist    | Status     | Identifier
--------------------------------------------------------------------------------
 AdoptOpenJDK  |     | 16.0.1.j9    | adpt    |            | 16.0.1.j9-adpt
               |     | 16.0.1.hs    | adpt    |            | 16.0.1.hs-adpt
               |     | 11.0.11.j9   | adpt    |            | 11.0.11.j9-adpt
               |     | 11.0.11.hs   | adpt    |            | 11.0.11.hs-adpt
               |     | 8.0.292.j9   | adpt    |            | 8.0.292.j9-adpt
               |     | 8.0.292.hs   | adpt    |            | 8.0.292.hs-adpt
 Amazon        |     | 16.0.1.9.1   | amzn    |            | 16.0.1.9.1-amzn
               |     | 11.0.11.9.1  | amzn    |            | 11.0.11.9.1-amzn
               |     | 8.292.10.1   | amzn    |            | 8.292.10.1-amzn
 Azul Zulu     |     | 16.0.1       | zulu    |            | 16.0.1-zulu
               |     | 16.0.1.fx    | zulu    |            | 16.0.1.fx-zulu
               |     | 11.0.11      | zulu    |            | 11.0.11-zulu
               |     | 11.0.11.fx   | zulu    |            | 11.0.11.fx-zulu
               |     | 8.0.292      | zulu    |            | 8.0.292-zulu
               |     | 8.0.292.fx   | zulu    |            | 8.0.292.fx-zulu
               |     | 7.0.302      | zulu    |            | 7.0.302-zulu
 BellSoft      |     | 16.0.1.fx    | librca  |            | 16.0.1.fx-librca
               |     | 16.0.1       | librca  |            | 16.0.1-librca
               |     | 11.0.11.fx   | librca  |            | 11.0.11.fx-librca
               |     | 11.0.11      | librca  |            | 11.0.11-librca
               |     | 8.0.292.fx   | librca  |            | 8.0.292.fx-librca
               |     | 8.0.292      | librca  |            | 8.0.292-librca
  GraalVM       | >>> | 21.1.0.r16   | grl     | installed  | 21.1.0.r16-grl
               |     | 21.1.0.r11   | grl     |            | 21.1.0.r11-grl
               |     | 21.0.0.2.r11 | grl     |            | 21.0.0.2.r11-grl
               |     | 21.0.0.2.r8  | grl     |            | 21.0.0.2.r8-grl
               |     | 20.3.2.r11   | grl     |            | 20.3.2.r11-grl
               |     | 20.3.1.2.r11 | grl     |            | 20.3.1.2.r11-grl
               |     | 20.3.1.2.r8  | grl     |            | 20.3.1.2.r8-grl
               |     | 19.3.6.r11   | grl     |            | 19.3.6.r11-grl
               |     | 19.3.5.r11   | grl     |            | 19.3.5.r11-grl
               |     | 19.3.5.r8    | grl     |            | 19.3.5.r8-grl
 Java.net      |     | 17.ea.24     | open    |            | 17.ea.24-open
               |     | 17.ea.7.lm   | open    |            | 17.ea.7.lm-open
               |     | 17.ea.3.pma  | open    |            | 17.ea.3.pma-open
               |     | 16.0.1       | open    |            | 16.0.1-open
               |     | 11.0.2       | open    |            | 11.0.2-open
```

- Install latest stable version of GraalVM

```
sdk install java 21.1.0.r16-grl
``` 

- SDKMAN will install GraalVM in the system.
- Verify installation

```
$ java -version
openjdk version "16.0.1" 2021-04-20
OpenJDK Runtime Environment GraalVM CE 21.1.0 (build 16.0.1+9-jvmci-21.1-b05)
OpenJDK 64-Bit Server VM GraalVM CE 21.1.0 (build 16.0.1+9-jvmci-21.1-b05, mixed mode, sharing)
```
> Note: Execute the command in a new console

## GraalVM - Native Image

- GraalVM brings a tool `gu` - the GraalVM updater.

```
$ gu list
ComponentId              Version             Component name      Origin
--------------------------------------------------------------------------------
graalvm                  21.1.0            GraalVM Core
```

- Install GraalVM Native image

```
$ gu install native-image
```

- Verify installation

```
$ native-image --version
GraalVM 21.1.0 Java 16 CE (Java Version 16.0.1+9-jvmci-21.1-b05)
```

```
$ gu list

ComponentId              Version             Component name                Stability                     Origin
---------------------------------------------------------------------------------------------------------------------------------
graalvm                  21.1.0              GraalVM Core                  -
js                       21.1.0              Graal.js                      Experimental
native-image             21.1.0              Native Image                  Experimental                  github.com
```
