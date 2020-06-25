(ns shadow-macro-test.ana-dumper
  (:require [cljs.env :as env]
            [cljs.analyzer :as ana]
            [cljs.analyzer.api :as ana-api]
            [cljs.util :as cljs-util]))

(defmacro dump-ns
  "Debug dump analyzer's compiler env data for given namespace."
  [ ns-arg ]
  (cljs-util/debug-prn "--[begin dump ns:" ns-arg "]--")
  (cljs-util/debug-prn
   (prn-str (get-in @env/*compiler* [::ana/namespaces (symbol ns-arg)])))
  (cljs-util/debug-prn "--[end dump]--")
  ;; dummy whatever expansion
  `(println ~ns-arg))

(defmacro resolve-ana-sym
  "Resolve symbol in analyzer data"
  [ sym ]
  (let [sym-data (ana-api/resolve @env/*compiler* sym)]
    (cljs-util/debug-prn "--[resolve: " sym "]--")
    (cljs-util/debug-prn (prn-str sym-data))
    (cljs-util/debug-prn "--[end resolve]")
    ;; dummy whatever expansion
    `(println ~sym)))
