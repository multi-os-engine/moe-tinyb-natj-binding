#!/bin/bash

set -e

cd "${0%/*}"

./gradlew build
if [ $(uname -i | grep x86_64 | wc -l) -eq 1 ]; then
    LD_LIBRARY_PATH=$LD_LIBRARY_PATH:natives:natives/x86_64-unknown-linux-gnu \
        java -Djava.library.path=natives:natives/x86_64-unknown-linux-gnu -cp build/classes/main:lib/natj-api.jar example.HelloTinyB $@
else
    LD_LIBRARY_PATH=$LD_LIBRARY_PATH:natives:natives/i686-pc-linux-gnu \
        java -Djava.library.path=natives:natives/i686-pc-linux-gnu -cp build/classes/main:lib/natj-api.jar example.HelloTinyB $@
fi
