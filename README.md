# pulp
A clojure static website generator in the Jekyll style using hiccup as
a templating system. Convert a series of clojure templates into a static
site that can be uploaded to any host.

## Usage
As a standalone jar:

git clone git@github.com:quandrum/Pulp.git && cd pulp
lein uberjar
java -jar pulp.git template-dir out-dir

As a library:

In project.clj, add [pulp "1.0.0"] to :dependencies
lein deps

In your code:

(pulp/gen-site template-dir out-dir)

## License

Copyright (C) 2012 Adam Sinnett
Distributed under the Eclipse Public License, the same as Clojure.
