# clotd

A QOTD server.

## Building

To build a standalone `.jar`:

```
lein uberjar
```

## Usage

You need to run the server as root, since the QOTD port is below 1024 (17).

```
[sudo] java -jar <standalone.jar> <file.fortune> [<port>]
```

* `<standalone.jar>` is the path to the standalone `.jar`
* `<file.fortune>` is the path to your quotes file. Quotes are separated with a
  `%` on its own line.
* `<port>` is optional and is the port used by the server (default is 17).

## License

Copyright © 2013 Baptiste Fontaine

Distributed under the Eclipse Public License version 1.0
