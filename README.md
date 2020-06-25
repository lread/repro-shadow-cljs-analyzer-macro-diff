# repro-shadow-cljs-analyzer-macro-diff

There are differences in the analyzer compiler env maps when compiling under 
ClojureScript vs when compiling under Shadow CLJS. 

I noticed this when trying to compile a project with Shadow CLJS that uses 
[rewrite-cljc](https://github.com/lread/rewrite-cljc-playground) 
which includes an internal cljs version of potemkin import-vars.

The difference that tripped up the cljs version of import-vars was that 
ClojureScript analysis includes macros under `:defs` and `:macros` whereas Shadow
CLJS only includes macros under `:macros`.

This little project demonstrates this difference.

Run `./script/test.sh` or checkout the results on CircleCI.

The script:

1. dumps cljs analyzer's view of `shadow-macro-test.ns1` when compiling under ClojureScript
2. dumps same when compiling under Shadow CLJS
3. diffs the edn of above
