#!/usr/bin/env bash

set -eou pipefail

status-line() {
    echo ""
    echo -e "\033[42m \033[30;46m $1 \033[42m \033[0m"
}

function clean() {
    rm -rf .cpcache .cljs_node_repl target/blap.js .shadow-cljs
}

status-line "starting fresh"
rm -rf node_modules
npm install
rm -rf target
mkdir target

status-line "dumping cljs analyzer data for clojurescript compile"
clean
clojure -m cljs.main --target node \
        --output-to target/blap.js \
        -c shadow-macro-test.ns2 2> target/cljs-dump.edn

status-line "dumping cljs analyzer data for shadow-cljs compile"
clean
npx shadow-cljs compile app 2> target/shadow-dump.edn

status-line "diffing analyzer data"
clojure -A:diff target/cljs-dump.edn target/shadow-dump.edn
