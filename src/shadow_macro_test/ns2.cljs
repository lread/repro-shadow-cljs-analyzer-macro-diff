(ns shadow-macro-test.ns2
  (:require [shadow-macro-test.ns1 :include-macros true])
  (:require-macros  [shadow-macro-test.ana-dumper :refer [dump-ns resolve-ana-sym]]))

(dump-ns shadow-macro-test.ns1)
(resolve-ana-sym shadow-macro-test.ns1/t-fn)
(resolve-ana-sym shadow-macro-test.ns1/t-macro)

(defn main []
  (println "hey"))
